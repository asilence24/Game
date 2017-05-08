package amt.main.entities;

import amt.main.Direction;
import amt.main.Handler;
import java.awt.Graphics;

public abstract class Projectile extends Entity {
    
    protected float speed;
    protected Direction dir;
    
    public Projectile(float x, float y, float speed, Direction dir, Handler handler) {
        super(x, y, handler);
        this.speed = speed;
        this.dir = dir;
    }

    @Override
    public void update() {
        switch (dir) {
            case North:
                
                break;
            case East:
                
                break;
            case South:
                
                break;
            case West:
                
                break;
            default:
                System.err.println("Unrecognized direction!");
        }
    }

    @Override
    public void render(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
