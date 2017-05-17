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
public class Turret extends Mob {

    private static final float RANGE = 10f;
    //private static final float FIRE_RATE = 120;
    private long fireTimer, lastFire = fireTimer, fireRate= 100;
    
    public Turret(float x, float y, Handler handler) {
        super(x, y, 100, 0, new Rectangle(0, 0, 64, 64), handler);
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render(Graphics g) {
        /*
        Graphics2D g2d = (Graphics2D) g; // Create a Java2D version of g.
        g2d.translate((int)((x - handler.getCamera().xOffset()) * Assets.tileWidth), (int)((y - handler.getCamera().yOffset()) * Assets.tileHeight));
        g2d.rotate(1);  // Rotate the image by 1 radian.
        g2d.drawImage(Assets.turret, 0, 0, Assets.tileWidth, Assets.tileHeight, null);
        g2d.rotate(-1);
        g2d.translate(-(int)((x - handler.getCamera().xOffset()) * Assets.tileWidth), -(int)((y - handler.getCamera().yOffset()) * Assets.tileHeight));
        */
        int myX = (int)((x - handler.getCamera().xOffset()) * Assets.tileWidth);
        int myY = (int)((y - handler.getCamera().yOffset()) * Assets.tileHeight);
        int playerX = (int)((handler.getLevel().getPlayer().getX() - handler.getCamera().xOffset()) * Assets.tileWidth);
        int playerY = (int)((handler.getLevel().getPlayer().getY() - handler.getCamera().yOffset()) * Assets.tileHeight);
        g.drawImage(Assets.turret, myX, myY, Assets.tileWidth, Assets.tileHeight, null);
        float distance = (float)Math.hypot(handler.getLevel().getPlayer().getX() - x, handler.getLevel().getPlayer().getY() - y);
        
        fireTimer = System.currentTimeMillis()-lastFire;
        lastFire = System.currentTimeMillis();
        
        if (distance < RANGE && //Make sure player's in range
                handler.getLevel().raycast(x, y, handler.getLevel().getPlayer().getX(), handler.getLevel().getPlayer().getY())) { //And we have line of sight
            g.drawLine(myX, myY, playerX, playerY); //Draw the aiming laser.
            
            if (fireTimer > fireRate) {
                handler.getLevel().addEntity(new TurretBullet(x, y, .01f * (handler.getLevel().getPlayer().getX() - x) / distance, .01f * (handler.getLevel().getPlayer().getY() - y) / distance, handler));
                fireTimer = 0;
            }
        }
    }
}
