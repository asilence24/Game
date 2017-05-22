package amt.main.entities;

import amt.main.Handler;
import amt.main.gfx.Assets;
import amt.main.ui.IconBar;
import amt.main.util.Force;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Mob {
    
    private float knockBack = .15f;
    private int knockBackTime = 40;
    private float speed;
    
    //bullets
    private int maxBullets=5,curBullets=5;
    private IconBar bulletBar;
    private long lastReload, reloadTimer=lastReload, reloadCooldown=1000;
    
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
        if (curBullets > 0) {
            if (handler.getKeyManager().getUpTapped()) {
                handler.getLevel().addEntity(new PlayerBullet(x, y, 0f, -.2f, handler));
                body.addForce(new Force(0f, knockBack, knockBackTime));
                curBullets--;
            }
            if (handler.getKeyManager().getDownTapped()) {
                handler.getLevel().addEntity(new PlayerBullet(x, y, 0f, .2f, handler));
                body.addForce(new Force(0f, -knockBack, knockBackTime));
                curBullets--;
            }
            if (handler.getKeyManager().getLeftTapped()) {
                handler.getLevel().addEntity(new PlayerBullet(x, y, -.2f, 0f, handler));
                body.addForce(new Force(knockBack, 0f, knockBackTime));
                curBullets--;
            }
            if (handler.getKeyManager().getRightTapped()) {
                handler.getLevel().addEntity(new PlayerBullet(x, y, .2f, 0f, handler));
                body.addForce(new Force(-knockBack, 0f, knockBackTime));
                curBullets--;
            }
        }
    }
    
    private void bullets(){
        if (curBullets < maxBullets) {
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
