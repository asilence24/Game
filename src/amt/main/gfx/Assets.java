package amt.main.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author tsharman58
 */
public class Assets {
    
    public static int width=64, height=64;
    
    public static BufferedImage platform;
    
    /**
     * initiates all assets
     */
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sokoban_tilesheet.png"));
        
        platform = sheet.crop(64, 0, width, height);
    }
    
    //spritesheet crop reference
    /* 0,0 1,0 2,0 ...
     * 0,1 1,1 2,1 ...
     * 0,2
     * 0,3
     */
}
