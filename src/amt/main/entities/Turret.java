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
    private boolean tracking = true, loaded, shooting;
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

        float distance = (float) Math.hypot(handler.getLevel().getPlayer().getCenterX() - getCenterX(), handler.getLevel().getPlayer().getCenterY() - getCenterY());
        timeSinceLastShot = System.currentTimeMillis() - lastFire;
        if (timeSinceLastShot > fireRate) {
            loaded = true;
        }
        //We can see the player
        if (distance < RANGE && handler.getLevel().raycast(getCenterX(), getCenterY(), handler.getLevel().getPlayer().getCenterX(), handler.getLevel().getPlayer().getCenterY())) {
            laserColor = Color.RED;
            if (!shooting) {
                //Update our known location of him
                lastKnownX = handler.getLevel().getPlayer().getCenterX();
                lastKnownY = handler.getLevel().getPlayer().getCenterY();
            }
            //If we're within the warning time - begin firing
            if (timeSinceLastShot > fireRate - warningTime) {
                laserColor = Color.ORANGE;
                tracking = false;
                shooting = true;
            }
            g.setColor(laserColor);
            g.drawLine((int) ((getCenterX() - handler.getCamera().xOffset()) * Assets.tileWidth),
                    (int) ((getCenterY() - handler.getCamera().yOffset()) * Assets.tileHeight),
                    (int) ((lastKnownX - handler.getCamera().xOffset()) * Assets.tileWidth),
                    (int) ((lastKnownY - handler.getCamera().yOffset()) * Assets.tileHeight));
        }
        if (loaded && shooting) {
            float lastDistance = (float) Math.hypot(lastKnownX - x, lastKnownY - y);
            handler.getLevel().addEntity(new TurretBullet(x, y, .1f * (lastKnownX - x) / lastDistance, .1f * (lastKnownY - y) / lastDistance, handler));
            lastFire = System.currentTimeMillis();
            shooting = false;
            loaded = false;
        }
        g.drawImage(Assets.turret, (int) ((getX() - handler.getCamera().xOffset()) * Assets.tileWidth),
                (int) ((getY() - handler.getCamera().yOffset()) * Assets.tileHeight), Assets.tileWidth, Assets.tileHeight, null);
        if (loaded) {
            g.setColor(Color.GREEN);
        } else {
            g.setColor(Color.DARK_GRAY);
        }
        if (shooting) {
            g.setColor(Color.ORANGE);
        }
        g.fillRect((int) ((getX() - handler.getCamera().xOffset()) * Assets.tileWidth), (int) ((getY() - handler.getCamera().yOffset()) * Assets.tileHeight), 15, 15);
    }
}
