package amt.main.gfx;

import amt.main.entities.Entity;

/**
 *
 * @author asilence24
 */
public class Camera {
    
    private float xOffset, yOffset;
    private Entity centeredEntity;
    
    public void centerOnEntity(Entity e){
        centeredEntity = e;
    }
    
    public void updateCamera(){
        xOffset = centeredEntity.getX();
        yOffset = centeredEntity.getY();
    }
    
    public float xOffset(){
        return xOffset;
    }
    
    public float yOffset(){
        return yOffset;
    }
    
}

