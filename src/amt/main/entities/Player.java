package amt.main.entities;

import amt.main.Handler;
import amt.main.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import physics.Vector;

public class Player extends Mob {
    
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
            body.addForce(new Vector(0.0, -25.0));
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
        move();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int)((x - handler.getCamera().xOffset()) * Assets.tileWidth), (int)((y - handler.getCamera().yOffset()) * Assets.tileHeight), Assets.tileWidth, Assets.tileHeight, null);
        g.setColor(Color.red);
        g.drawRect((int)((x - handler.getCamera().xOffset()) * Assets.tileWidth) + bounds.x, (int)((y - handler.getCamera().yOffset()) * Assets.tileHeight) + bounds.y, bounds.width, bounds.height);
    }
}
