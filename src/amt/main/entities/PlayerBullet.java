package amt.main.entities;

import amt.main.Handler;
import amt.main.gfx.Assets;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerBullet extends Projectile {

    private int size;
    
    public PlayerBullet(float x, float y, int size, float xMove, float yMove, Handler handler) {
        super(1, .2f, x - (size * .2f / 2), y - (size * .2f / 2), xMove, yMove, new Rectangle((int)((.9f + .1f * size) * 20), (int)((.9f + .1f * size) * 20), (int)((.9f + .1f * size) * 20), (int)((.9f + .1f * size) * 20)), handler);
        this.size = size;
    }
    //20
    @Override
    public void render(Graphics g) {
        float mult = 1f + .2f * (size - 1);
        g.drawImage(Assets.bullet, (int)((x - handler.getCamera().xOffset()) * Assets.tileWidth), (int)((y - handler.getCamera().yOffset()) * Assets.tileHeight),
                (int)(Assets.tileWidth * mult), (int)(Assets.tileHeight * mult), null);
    }
    
    @Override
    protected void checkEntityCollisions() {
        
    }
}
