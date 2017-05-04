/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.entities;

import amt.main.Handler;

/**
 *
 * @author mgalan11
 */
public abstract class Entity {
    
    private float x, y;
    private Handler handler;
    
    public Entity(float x, float y, Handler handler) {
        this.x = x;
        this.y = y;
    }
    
    public abstract void update();
    
    public abstract void render();
    
    public float getX() {
        return x;
    }
    
    public float getY() {
        return y;
    }
}
