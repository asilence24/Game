/*Name:	Matthew Galan
 *Date:
 *Period: 7
 *Teacher: Mrs. Krueger
 *Description:
 */
package amt.main.levels;

import amt.main.tiles.Tile;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class LevelLoader
{
    /**
     * Load a level from a .txt and .png file.
     * @param name The name of the level to be loaded. DO NOT INCLUDE .txt or .png.
     * @return The newly read level from the files.
     */
    public static Level loadLevel(String name) {
        try {
            BufferedImage levelPic = ImageIO.read(LevelLoader.class.getResource(name + ".png"));
            for (int x = 0; x < levelPic.getWidth(); x++) {
                for (int y = 0; y < levelPic.getHeight(); y++) {
                    Color pixelColor = new Color(levelPic.getRGB(x, y), true);
                    Tile t;
                    if (pixelColor.equals(Color.black)) {
                        
                    } else if (pixelColor.equals(Color.lightGray)) {
                        
                    } else { //Color not found, read text file
                        Scanner s = new Scanner(name + ".txt");
                        boolean found = false;
                        while (s.hasNextLine()) {
                            Color textColor = new Color(s.nextInt(), s.nextInt(), s.nextInt());
                            if (pixelColor.equals(textColor)) { //Specification found
                                //Follow specifications
                                
                                found = true;
                                break;
                            } else {
                                s.nextLine();
                            }
                        }
                        if (!found) { //Couldn't find specification
                            System.err.println("Encountered an undefined color!");
                            System.exit(1);
                        } 
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
