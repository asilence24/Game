package amt.main.entities;

import amt.main.Handler;
import amt.main.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import physics.Force;

public class Player extends Mob {
    
    private float knockBack = .15f;
    private int knockBackTime = 40;
    private float speed;
    
    public Player (int maxHealth, float speed, float x, float y, Handler handler) {
        super(x, y, maxHealth, speed, new Rectangle(10, 5, 44, 52), handler);
        this.speed = speed;
    }
    
    @Override
    public void update() {
        xMove = 0;
        //yMove = 0;
        if(handler.getKeyManager().getWTapped() && onGround()){
            body.addForce(new Force(0, -.25f, 60));
            //yMove = -speed;
        }
        if(handler.getKeyManager().getSPressed()){
            //yMove = speed;
        }
        if(handler.getKeyManager().getAPressed()){
            xMove = -speed;
        }
        if(handler.getKeyManager().getDPressed()){
            xMove = speed;
        }
        if (handler.getKeyManager().getUpTapped()) {
            handler.getLevel().addEntity(new PlayerBullet(x, y, 0f, -.2f, handler));
            body.addForce(new Force(0f, knockBack, knockBackTime));
        }
        if (handler.getKeyManager().getDownTapped()) {
            handler.getLevel().addEntity(new PlayerBullet(x, y, 0f, .2f, handler));
            body.addForce(new Force(0f, -knockBack, knockBackTime));
        }
        if (handler.getKeyManager().getLeftTapped()) {
            handler.getLevel().addEntity(new PlayerBullet(x, y, -.2f, 0f, handler));
            body.addForce(new Force(knockBack, 0f, knockBackTime));
        }
        if (handler.getKeyManager().getRightTapped()) {
            handler.getLevel().addEntity(new PlayerBullet(x, y, .2f, 0f, handler));
            body.addForce(new Force(-knockBack, 0f, knockBackTime));
        }
        move();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int)((x - handler.getCamera().xOffset()) * Assets.tileWidth), (int)((y - handler.getCamera().yOffset()) * Assets.tileHeight), Assets.tileWidth, Assets.tileHeight, null);
        g.setColor(Color.red);
        g.drawRect((int)((x - handler.getCamera().xOffset()) * Assets.tileWidth) + bounds.x, (int)((y - handler.getCamera().yOffset()) * Assets.tileHeight) + bounds.y, bounds.width, bounds.height);
    }
}
