package physics;

/**
 *
 * @author Matthew Galan
 */
public class Force {
    
    private float x, y, xStep, yStep;
    private int t;
    private boolean done;
    
    public Force(float x, float y, int length) {
        this.x = x;
        this.y = y;
        t = length;
        xStep = x / length;
        yStep = y / length;
    }
    
    public void update() {
        t--;
        if (t <=0) {
            done = true;
        } else {
            x -= xStep;
            y -= yStep;
        }
    }
    
    public float getX() {
        return x;
    }
    
    public float getY() {
        return y;
    }
    
    public void resetX() {
        x = 0;
        xStep = 0;
    }
    
    public void resetY() {
        y = 0;
        yStep = 0;
    }
    
    public boolean done() {
        return done;
    }
}
