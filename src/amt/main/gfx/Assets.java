package amt.main.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author tsharman58
 */
public class Assets {
    
    public BufferedImage blah;
    
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sokoban_spritesheet.png"));
    }
    
}
