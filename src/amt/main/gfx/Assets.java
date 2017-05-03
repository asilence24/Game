package amt.main.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author tsharman58
 */
public class Assets {
    
    public static int width=64, height=64;
    
    public static BufferedImage platform, background;
    
    private static SpriteSheet sheet;
    
    /**
     * initiates all assets
     */
    public static void init(){
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sokoban_tilesheet.png"));
        
        platform = easyLoad(1, 0);
        background = easyLoad(11, 6);
    }
    
    private static BufferedImage easyLoad(int x, int y) {
        return sheet.crop(x * width, y * height, width, height);
    }
    
    //spritesheet crop reference
    /* 0,0 1,0 2,0 ...
     * 0,1 1,1 2,1 ...
     * 0,2
     * 0,3
     */
}
