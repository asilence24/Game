/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.entities;

import amt.main.Handler;
import amt.main.gfx.Assets;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import static java.util.function.IntUnaryOperator.identity;

/**
 *
 * @author mgalan11
 */
public class Turret extends Mob {

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
        g.drawLine(myX, myY, playerX, playerY);
    }
}
