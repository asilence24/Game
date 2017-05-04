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
public abstract class Mob extends Entity {
    
    private int health, maxHealth;
    
    public Mob (int maxHealth, float x, float y, Handler handler) {
        super(x, y, handler);
        health = maxHealth;
        this.maxHealth = maxHealth;
    }
    
    public abstract void update();
    
    public abstract void render();
}
