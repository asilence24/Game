package amt.main.entities;

import amt.main.Handler;
import amt.main.gfx.Assets;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerBullet extends Projectile {

    public PlayerBullet(float x, float y, float xMove, float yMove, Handler handler) {
        super(x, y, xMove, yMove, new Rectangle(20, 20, 20, 20), handler);
    }
    //20
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bullet, (int)((x - handler.getCamera().xOffset()) * Assets.tileWidth), (int)((y - handler.getCamera().yOffset()) * Assets.tileHeight), Assets.tileWidth, Assets.tileHeight, null);
    }
    
}
