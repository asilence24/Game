/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.entities;

import amt.main.Handler;
import amt.main.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author mgalan11
 */
public class Turret extends Mob {

    private static final float RANGE = 10f;
    private long fireRate = 1500; //Milliseconds between shooting
    private long warningTime = 500; //Seconds before shooting that the laser stops tracking the player
    private long lastFire, timeSinceLastShot;
    private boolean tracking = true;
    private float shotDirX, shotDirY;
    private float lastKnownX, lastKnownY;
    private Color laserColor;
    
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
        
        float distance = (float)Math.hypot(handler.getLevel().getPlayer().getX() - x, handler.getLevel().getPlayer().getY() - y);

        
        //If the player is in range and in sight
        if (distance < RANGE && handler.getLevel().raycast(x, y, handler.getLevel().getPlayer().getX(), handler.getLevel().getPlayer().getY())) {
            timeSinceLastShot = System.currentTimeMillis() - lastFire;
            laserColor = Color.RED;
            if (tracking) {
                //Update our known location of him
                lastKnownX = handler.getLevel().getPlayer().getX();
                lastKnownY = handler.getLevel().getPlayer().getY();
            }
            //If we're within the warning time
            if (timeSinceLastShot > fireRate - warningTime) {
                laserColor = Color.ORANGE;
                tracking = false;
            }
            g.setColor(laserColor);
            g.drawLine(myX + Assets.tileWidth / 2, myY + Assets.tileHeight / 2, (int) ((lastKnownX - handler.getCamera().xOffset()) * Assets.tileWidth) + Assets.tileWidth / 2, (int) ((lastKnownY - handler.getCamera().yOffset()) * Assets.tileHeight) + Assets.tileHeight / 2);
        }
        if (timeSinceLastShot > fireRate) { //Shoot
            float lastDistance = (float) Math.hypot(lastKnownX - x, lastKnownY - y);
            handler.getLevel().addEntity(new TurretBullet(x, y, .1f * (lastKnownX - x) / lastDistance, .1f * (lastKnownY - y) / lastDistance, handler));
            lastFire = System.currentTimeMillis();
            tracking = true;
        }
        g.drawImage(Assets.turret, myX, myY, Assets.tileWidth, Assets.tileHeight, null);
        
    }
}
