package physics;

public class Rigidbody {
    
    private final static double GRAV_ACCEL = .0003f;
    
    private double mass;
    private Vector netForce, acceleration, velocity;
    
    public Rigidbody(double mass) {
        this.mass = mass;
        netForce = new Vector(0, 0);
        velocity = new Vector(0, 0);
    }
    
    public void tick() {
        netForce.add(new Vector(0, GRAV_ACCEL * mass)); //Add the force of gravity
        acceleration = netForce.divide(mass);
        velocity.add(acceleration.divide(60));
    }
    
    public void addForce(Vector force) {
        netForce.add(force);
    }
    
    /**
     * @return The horizontal distance moved since last tick.
     */
    public float getX() {
        return (float)velocity.getX();
    }
    
    /**
     * @return The vertical distance moved since last tick.
     */
    public float getY() {
        return (float)velocity.getY();
    }
    
    /**
     * Set the horizontal velocity to 0.
     */
    public void resetX() {
        netForce.setX(0);
    }
    
    /**
     * Set the vertical velocity to 0.
     */
    public void resetY() {
        netForce.setX(0);
    }
}
