/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.entities;

import amt.main.Handler;
import java.awt.Graphics;

/**
 *
 * @author mgalan11
 */
public abstract class Mob extends Entity {
    
    private int health, maxHealth;
    
    public Mob (int maxHealth, float speed, float x, float y, Handler handler) {
        super(x, y, handler);
        health = maxHealth;
        this.maxHealth = maxHealth;
    }
    
    /**
     * Generic move method for all entities
     */
    public void move(){
        
    }
    
    public abstract void update();
    
    public abstract void render(Graphics g);
}
