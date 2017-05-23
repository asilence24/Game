/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.entities;

import amt.main.Handler;
import amt.main.gfx.Assets;
import amt.main.util.Force;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author mgalan11
 */
public class TurretBullet extends Projectile {
    
    public TurretBullet(float x, float y, float xMove, float yMove, Handler handler) {
        super(1, .05f, x, y, xMove, yMove, new Rectangle(20, 20, 20, 20), handler);
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bullet, (int)((x - handler.getCamera().xOffset()) * Assets.tileWidth), (int)((y - handler.getCamera().yOffset()) * Assets.tileHeight), Assets.tileWidth, Assets.tileHeight, null);
    }

    @Override
    protected void checkEntityCollisions() {
        Player p = handler.getLevel().getPlayer();
        if (getBounds().intersects(p.getBounds())) {
            float magnitude = (float) Math.hypot(xMove, yMove);
                //p.hit(damage, new Force(xMove * knockback / magnitude, yMove * knockback / magnitude, 60));
                destroy = true;
        }
    }
}
