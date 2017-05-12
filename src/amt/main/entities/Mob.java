/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.entities;

import amt.main.Handler;
import amt.main.gfx.Assets;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author mgalan11
 */
public abstract class Mob extends Entity {
    
    private int health, maxHealth;
    protected float xMove, yMove;
    
    public Mob (float x, float y, int maxHealth, float speed, Rectangle bounds, Handler handler) {
        super(x, y, bounds, handler);
        health = maxHealth;
        this.maxHealth = maxHealth;
    }
    
    public void move(){
        //Convert bounds coordinates, which are in pixels, to tiles coordinates.
        float xBound = (float)bounds.x / Assets.width;
        float yBound = (float)bounds.y / Assets.height;
        float boundWidth = (float)bounds.width / Assets.width;
        float boundHeight = (float)bounds.height / Assets.height;
        if (xMove > 0) { //Moving right
            float tempX = x + xMove + xBound + boundWidth;
            if (!collisionWithTile(tempX, y + yBound) && !collisionWithTile(tempX, y + yBound + boundHeight)) {
                x += xMove;
            } else {
                x = (int)tempX - xBound - boundWidth - .001f;
            }
        } else if (xMove < 0) { //Moving left
            float tempX = x + xMove + xBound;
            if (!collisionWithTile(tempX, y + yBound) && !collisionWithTile(tempX, y + yBound + boundHeight)) {
                x += xMove;
            } else {
                  x = (int)tempX + 1.001f - xBound;
            }
        }
        if (yMove > 0) { //Moving down
            float tempY = y + yMove + yBound + boundHeight;
            if (!collisionWithTile(x + xBound, tempY) && !collisionWithTile(x + xBound + boundWidth, tempY)) {
                y += yMove;
            } else {
                 y = (int)tempY - yBound - boundHeight - .001f;
            }
        } else if (yMove < 0) { //Moving up
            float tempY = y + yMove + yBound;
            if (!collisionWithTile(x + xBound, tempY) && !collisionWithTile(x + xBound + boundWidth, tempY)) {
                y += yMove;
            } else {
                y = (int)tempY + 1.001f - yBound;
            }
        }
    }
    
    protected boolean collisionWithTile(float x, float y) {
        return handler.getLevel().getTile(x, y).isSolid();
    }
    
    public abstract void update();
    
    public abstract void render(Graphics g);
}
