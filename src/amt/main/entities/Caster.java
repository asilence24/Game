package amt.main.entities;

import amt.main.Handler;
import amt.main.gfx.Assets;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Caster extends Mob {

    private final long ORB_FIRERATE = 3000;
    private final float RUNAWAY = 5f, //How close can the player get before we run away?
            ORB_DETECT = 8f; //How close does the player have to be for us to fire orbs?
    
    private long lastOrb; //When we fired the last orb.
    
    public Caster(float x, float y, Handler handler) {
        super(x, y, 2, .06f, new Rectangle(10, 5, 44, 52), handler);
    }

    @Override
    public void update() {
        Player p = handler.getLevel().getPlayer();
        
        if (System.currentTimeMillis() - lastOrb >= ORB_FIRERATE) { //If we have another orb ready
            if (Math.hypot(p.getCenterX() - getCenterX(), p.getCenterY() - getCenterY()) < ORB_DETECT) { //If the player is close enough
                //Shoot
                handler.getLevel().addEntity(new CasterBullet(getCenterX(), getCenterY(), this, handler));
                lastOrb = System.currentTimeMillis();
            }
        }  
        
        if (Math.hypot(p.getCenterX() - getCenterX(), p.getCenterY() - getCenterY()) < RUNAWAY) {
            //Player is close - run!
            if (p.getCenterX() > getCenterX()) {
                //Player is further right - run left
                xMove = -speed;
                //Levitate over walls we run into
                if (handler.getLevel().getTile(x + xBound - .2f, y + yBound + boundHeight).isSolid()) { //If there's a solid tile to the left of us,
                    yMove = -.1f - speed;
                } else {
                    yMove = 0;
                }
            } else {
                //Player is further left - run right
                xMove = speed;
                //Levitate over walls we run into
                if (handler.getLevel().getTile(x + xBound + boundWidth + .2f, y + yBound + boundHeight).isSolid()) {
                    yMove = -.1f - speed;
                } else {
                    yMove = 0;
                }
            }
        } else {
            xMove = 0;
            yMove = 0;
        }
        move();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.caster, (int) ((x - handler.getCamera().xOffset()) * Assets.tileWidth), (int) ((y - handler.getCamera().yOffset()) * Assets.tileHeight), Assets.tileWidth, Assets.tileHeight, null);
    }
}
