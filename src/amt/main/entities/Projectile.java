package amt.main.entities;

import amt.main.Handler;
import amt.main.gfx.Assets;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Projectile extends Entity {

    protected float xMove, yMove;
    
    public Projectile(float x, float y, float xMove, float yMove, Rectangle bounds, Handler handler) {
        super(x, y, bounds, handler);
        this.xMove = xMove;
        this.yMove = yMove;
    }
    
    public void update() {
        float newX = x + xMove;
        float newY = y + yMove;
        if (!collisionWithTile(newX + xBound, newY + yBound) && !collisionWithTile(newX + xBound, newY + yBound + boundHeight)
                && !collisionWithTile(newX + xBound + boundWidth, newY + yBound) && !collisionWithTile(newX + xBound + boundWidth, newY + yBound + boundHeight)) {
            //Ran into a wall, so destroy this projectile.
            destroy = true;
        }
    }

    public abstract void render(Graphics g);
    
    protected boolean collisionWithTile(float x, float y) {
        return handler.getLevel().getTile(x, y).isSolid();
    }
}
