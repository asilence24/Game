package amt.main.entities;

import amt.main.Handler;
import amt.main.gfx.Assets;
import amt.main.util.Force;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Matthew Galan
 */
public class CasterBullet extends Projectile {
    
    private final float SPEED = .04f;
    private final int DAMAGE = 2;
    private final long LIFETIME = 5000;
    
    private long birthTime;
    private Caster source;
    
    public CasterBullet(float x, float y, Caster source, Handler handler) {
        super(.05f, x, y, 0f, 0f, new Rectangle(20, 20, 20, 20), handler);
        this.source = source;
        birthTime = System.currentTimeMillis();
    }

    @Override
    public void update() {
        if (System.currentTimeMillis() - birthTime >= LIFETIME) {
            destroy = true;
            return;
        }
        float deltaX = handler.getLevel().getPlayer().getCenterX() - getCenterX();
        float deltaY = handler.getLevel().getPlayer().getCenterY() - getCenterY();
        float magnitude = (float)Math.hypot(deltaX, deltaY);
        xMove = (deltaX * SPEED / magnitude) * (1f-((float)(System.currentTimeMillis() - birthTime) / (float)LIFETIME));
        yMove = deltaY * SPEED / magnitude * (1f-((float)(System.currentTimeMillis() - birthTime) / (float)LIFETIME));
        x += xMove;
        y += yMove;
        //Don't checkTileCollisions() because we go through walls.
        checkEntityCollisions();
    }
    
    @Override
    protected void checkEntityCollisions() {
        Player p = handler.getLevel().getPlayer();
        if (getBounds().intersects(p.getBounds())) {
            //Suck the player in
            p.hit(DAMAGE, new Force(p.getCenterX(), p.getCenterY(), source.getCenterX(), source.getCenterY(), knockback, 40));
            destroy = true;
        }
    }

    @Override
    public void render(Graphics g) {
        try {
            ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) Math.sqrt(1f - ((float) (System.currentTimeMillis() - birthTime) / (float) LIFETIME))));
            g.drawImage(Assets.bullet, (int) ((x - handler.getCamera().xOffset()) * Assets.tileWidth), (int) ((y - handler.getCamera().yOffset()) * Assets.tileHeight), Assets.tileWidth, Assets.tileHeight, null);
            ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        } catch (IllegalArgumentException e) {
            //idk why and idc
        }
    }
}
