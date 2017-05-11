package amt.main.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author tsharman58
 */
public class Assets {
    
    //tilesheet
    public static int tileWidth=64, tileHeight=64;
    
    public static BufferedImage platform, background;
    public static BufferedImage player;
    
    private static SpriteSheet sheet;
    
    //buttonsheet
    public static int buttonWidth=190,buttonHeight=48;
    public static BufferedImage buttonUp, buttonDown;
    private static SpriteSheet buttonSheet;
    
    /**
     * initiates all assets
     */
    public static void init(){
        //tilesheet
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sokoban_tilesheet.png"));
        
        platform = easyLoad(1, 0);
        background = easyLoad(11, 6);
        
        player = easyLoad(5,4);
        
        //buttonsheet
        buttonSheet = new SpriteSheet(ImageLoader.loadImage("/textures/blueSheet.png"));
        
        buttonUp = buttonSheet.crop(0, 0, buttonWidth, buttonHeight);
        buttonDown = buttonSheet.crop(buttonWidth, 0, buttonWidth, buttonHeight);
    }
    
    private static BufferedImage easyLoad(int x, int y) {
        return sheet.crop(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
    }
    
    //spritesheet crop reference
    /* 0,0 1,0 2,0 ...
     * 0,1 1,1 2,1 ...
     * 0,2
     * 0,3
     */
}
