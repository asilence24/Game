/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.entities;

import amt.main.Handler;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author mgalan11
 */
public abstract class Entity {
    
    protected float x, y;
    protected Handler handler;
    protected Rectangle bounds;
    
    public Entity(float x, float y, int width, int height, Handler handler) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        bounds = new Rectangle(0, 0, width, height);
    }
    
    public abstract void update();
    
    public abstract void render(Graphics g);
    
    public float getX() {
        return x;
    }
    
    public float getY() {
        return y;
    }
}
