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
public class TurretBullet extends Projectile {
    
    public TurretBullet(float x, float y, float xMove, float yMove, Handler handler) {
        super(x, y, xMove, yMove, new Rectangle(20, 20, 20, 20), handler);
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bullet, (int)((x - handler.getCamera().xOffset()) * Assets.tileWidth), (int)((y - handler.getCamera().yOffset()) * Assets.tileHeight), Assets.tileWidth, Assets.tileHeight, null);
    }
}
