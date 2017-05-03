/*Name:	Matthew Galan
 *Date:
 *Period: 7
 *Teacher: Mrs. Krueger
 *Description:
 */
package amt.main.levels;

import amt.main.tiles.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
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
            BufferedImage levelPic = ImageIO.read(LevelLoader.class.getResource("/levels/" + name + ".png"));
            Level newLevel = new Level(levelPic.getWidth(), levelPic.getHeight());
            for (int x = 0; x < levelPic.getWidth(); x++) {
                for (int y = 0; y < levelPic.getHeight(); y++) {
                    Color pixelColor = new Color(levelPic.getRGB(x, y), true);
                    Tile t;
                    //PREPROGRAMMED TILE COLOR KEYS HERE:
                    if (pixelColor.equals(Color.black)) { //Black - Platform
                        newLevel.setTile(x, y, new Platform());
                    } else if (pixelColor.equals(Color.white)) { //White - Background
                        newLevel.setTile(x, y, new Background());
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
            return newLevel;
        } catch (Exception e) {
            System.err.println("Couldn't load level \"" + name + "\"!");
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
