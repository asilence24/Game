package physics;

public class Vector {
    
    private double x, y;
    
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Vector(double magnitude, int direction) {
        x = magnitude * Math.cos(direction);
        y = magnitude * Math.sin(direction);
    }
    
    public void add(Vector v) {
        x += v.getX();
        y += v.getY();
    }
    
    public Vector multiply(double m) {
        return new Vector(x * m, y * m);
    }
    
    public Vector divide(double d) {
        return new Vector(x / d, y / d);
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
}
