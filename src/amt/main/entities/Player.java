package amt.main.entities;

import amt.main.Handler;
import amt.main.gfx.Assets;
import amt.main.input.KeyManager;
import amt.main.ui.IconBar;
import amt.main.util.Force;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Mob {
    
    private float knockBack = .1f;
    private int knockBackTime = 40;
    private float speed;
    
    //bullets
    private int maxBullets=5, curBullets=5, bulletsStored;
    private IconBar bulletBar;
    private long lastReload, reloadTimer = lastReload, reloadCooldown=500,
            lastCharge, chargeTimer = lastCharge,  chargeCooldown = 500;
    private boolean charging;
    
    public Player (int maxHealth, float speed, float x, float y, Handler handler) {
        super(x, y, maxHealth, speed, new Rectangle(10, 5, 44, 52), handler);
        this.speed = speed;
        bulletBar = new IconBar(maxBullets, 10, 10, Assets.bullet);
    }
    
    @Override
    public void update() {
        movement();
        attacks();
        bullets();
    }
    
    private void movement(){
        xMove = 0;
        if(handler.getKeyManager().getSpaceTapped() && onGround()){
            body.addForce(new Force(0, -.25f, 60));
        }
        if(handler.getKeyManager().getAPressed()){
            xMove = -speed;
        }
        if(handler.getKeyManager().getDPressed()){
            xMove = speed;
        }
        move();
    }
    
    private void attacks(){
        KeyManager km = handler.getKeyManager();
        chargeTimer = System.currentTimeMillis() - lastCharge;
        //If we have bullets to shoot and we've waited long enough to charge another shot
        if (curBullets > 0 && chargeTimer > chargeCooldown) {
            //If we're pressing an arrow key
            if (km.getUpPressed() || km.getDownPressed() || km.getLeftPressed() || km.getRightPressed()) {
                //Charge up a bullet
                charging = true;
                bulletsStored++;
                curBullets--;
                chargeTimer = 0;
                lastCharge = System.currentTimeMillis();
            }
        }
        if (bulletsStored > 0) {
            if (km.getUpReleased()) {
                //Shoot up
                charging = false;                
                handler.getLevel().addEntity(new PlayerBullet(x, y, bulletsStored, 0f, -.2f, handler));
                body.addForce(new Force(0f, bulletsStored * knockBack, knockBackTime));
                bulletsStored = 0;
            } else if (km.getDownReleased()) {
                //Shoot down
                charging = false;
                handler.getLevel().addEntity(new PlayerBullet(x, y, bulletsStored, 0f, .2f, handler));
                body.addForce(new Force(0f, bulletsStored * -knockBack, knockBackTime));
                bulletsStored = 0;
            } else if (km.getRightReleased()) {
                //Shoot right
                charging = false;
                handler.getLevel().addEntity(new PlayerBullet(x, y, bulletsStored, .2f, 0f, handler));
                body.addForce(new Force(bulletsStored * -knockBack, 0f, knockBackTime));
                bulletsStored = 0;
            } else if (km.getLeftReleased()) {
                //Shoot left
                charging = false;
                handler.getLevel().addEntity(new PlayerBullet(x, y, bulletsStored, -.2f, 0f, handler));
                body.addForce(new Force(bulletsStored * knockBack, 0f, knockBackTime));
                bulletsStored = 0;
            }
        }
    }
    
    private void bullets(){
        if (!charging && curBullets < maxBullets) {
            reloadTimer += System.currentTimeMillis() - lastReload;
            lastReload = System.currentTimeMillis();
            if (reloadTimer > reloadCooldown) {
                curBullets++;
                reloadTimer=0;
            }
        }
        bulletBar.update(curBullets);
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int)((x - handler.getCamera().xOffset()) * Assets.tileWidth), (int)((y - handler.getCamera().yOffset()) * Assets.tileHeight), Assets.tileWidth, Assets.tileHeight, null);
        g.setColor(Color.red);
        g.drawRect((int)((x - handler.getCamera().xOffset()) * Assets.tileWidth) + bounds.x, (int)((y - handler.getCamera().yOffset()) * Assets.tileHeight) + bounds.y, bounds.width, bounds.height);
        bulletBar.render(g);
    }
}
