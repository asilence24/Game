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
        float deltaX = xMove;
        float deltaY = yMove;
        if (deltaX > 0) { //Moving right
            float tempX = x + deltaX + xBound + boundWidth;
            if (!collisionWithTile(tempX, y + yBound) && !collisionWithTile(tempX, y + yBound + boundHeight)) {
                x += deltaX;
            } else {
                destroy = true;
            }
        } else if (deltaX < 0) { //Moving left
            float tempX = x + deltaX + xBound;
            if (!collisionWithTile(tempX, y + yBound) && !collisionWithTile(tempX, y + yBound + boundHeight)) {
                x += deltaX;
            } else {
                destroy = true;
            }
        }
        if (deltaY > 0) { //Moving down
            float tempY = y + deltaY + yBound + boundHeight;
            if (!collisionWithTile(x + xBound, tempY) && !collisionWithTile(x + xBound + boundWidth, tempY)) {
                y += deltaY;
            } else {
                destroy = true;
            }
        } else if (deltaY < 0) { //Moving up
            float tempY = y + deltaY + yBound;
            if (!collisionWithTile(x + xBound, tempY) && !collisionWithTile(x + xBound + boundWidth, tempY)) {
                y += deltaY;
            } else {
                destroy = true;
            }
        }
    }

    public abstract void render(Graphics g);
}
