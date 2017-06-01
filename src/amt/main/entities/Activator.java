package amt.main.entities;

import amt.main.Handler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashSet;

public class Activator extends Entity {

    private HashSet<Entity> linked;
    private Color colorKey;
    
    public Activator(float x, float y, Color colorKey, Handler handler) {
        super(x, y, new Rectangle(0, 0, 64, 64), handler);
        linked = new HashSet<>();
        this.colorKey = colorKey;
    }

    @Override
    public void update() {
        if (handler.getLevel().getPlayer().getBounds().intersects(getBounds())) {
            activate();
            destroy = true;
        }
    }

    @Override
    public void render(Graphics g) {
    }
    
    public void link(Entity e) {
        linked.add(e);
    }
    
    public void activate() {
        for (Entity e : linked) {
            handler.getLevel().addEntity(e);
        }
        handler.getLevel().removeRedundantActivators(colorKey);
    }
    
    public boolean hasSameColorKey(Color otherKey) {
        return colorKey.equals(otherKey);
    }
}
