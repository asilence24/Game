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
    
    /**
     * The camera will now center on e.
     * @param e The entity to center on.
     */
    public void centerOnEntity(Entity e){
        centeredEntity = e;
    }
    
    /**
     * Centers the camera on the centeredEntity.
     */
    public void updateCamera(){
        xOffset = centeredEntity.getX() - handler.getWidth() / Assets.width / 2;
        yOffset = centeredEntity.getY() - handler.getHeight() / Assets.height / 2;
        if (xOffset < 0) {
            xOffset = 0;
        }
        if (xOffset + handler.getWidth() / Assets.width > handler.getLevel().getWidth()) {
            xOffset = handler.getLevel().getWidth() - handler.getWidth() / Assets.width;
        }
        if (yOffset < 0) {
            yOffset = 0;
        }
        if (yOffset + handler.getHeight() / Assets.height > handler.getLevel().getHeight()) {
            yOffset = handler.getLevel().getHeight() - handler.getHeight() / Assets.height;
        }
    }
    
    /**
     * @return The x position of the top left corner of the camera, in tiles.
     */
    public float xOffset(){
        return xOffset;
    }
    
    /**
     * @return The y position of the top left corner of the camera
     */
    public float yOffset(){
        return yOffset;
    }
    
}

