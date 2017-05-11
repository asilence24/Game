package amt.main.gfx;

import amt.main.Handler;
import amt.main.entities.Entity;

/**
 *
 * @author asilence24
 */
public class Camera {
    
    private Handler handler;
    private float xOffset, yOffset;
    private Entity centeredEntity;
    
    public Camera(Handler handler) {
        this.handler = handler;
    }
    
    public void centerOnEntity(Entity e){
        centeredEntity = e;
    }
    
    public void updateCamera(){
        xOffset = centeredEntity.getX() - handler.getWidth() / Assets.tileWidth / 2;
        yOffset = centeredEntity.getY() - handler.getHeight() / Assets.tileHeight / 2;
    }
    
    public float xOffset(){
        return xOffset;
    }
    
    public float yOffset(){
        return yOffset;
    }
    
}

