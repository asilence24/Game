/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.entities;

/**
 *
 * @author mgalan11
 */
public abstract class Mob extends Entity {
    
    private int health, maxHealth;
    
    public Mob (int maxHealth) {
        health = maxHealth;
        this.maxHealth = maxHealth;
    }
    
    public abstract void update();
    
    public abstract void render();
}
