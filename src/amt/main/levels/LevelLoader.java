/*Name:	Matthew Galan
 *Date:
 *Period: 7
 *Teacher: Mrs. Krueger
 *Description:
 */
package amt.main.levels;

import amt.main.Handler;
import amt.main.entities.*;
import amt.main.tiles.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class LevelLoader
{        
    /**
     * Load a level from a .txt and .png file.
     * @param name The name of the level to be loaded. DO NOT INCLUDE .txt or .png.
     * @return The newly read level from the files.
     */
    public static Level loadLevel(String name, Handler handler) {
        try {
            BufferedImage levelPic = ImageIO.read(LevelLoader.class.getResource("/levels/" + name + ".png"));
            Level newLevel = new Level(levelPic.getWidth(), levelPic.getHeight(), handler);
            
            for (int x = 0; x < levelPic.getWidth(); x++) {
                for (int y = 0; y < levelPic.getHeight(); y++) {
                    Color pixelColor = new Color(levelPic.getRGB(x, y), true);
                    Tile t = tileFromColor(pixelColor, handler);
                    if (t != null) { //If we alreay know what that color represents
                        newLevel.setTile(x, y, t);
                    } else {
                        File file = new File(LevelLoader.class.getResource("/levels/" + name + ".txt").getFile());
                        Scanner sc = new Scanner(file);
                        boolean found = false;
                        while (sc.hasNextLine()) {
                            //System.out.println(sc.next());
                            Color textColor = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt());
                            if (pixelColor.equals(textColor)) { //Specification found
                                //Follow specifications
                                found = true;
                                newLevel.setTile(x, y, tileFromWord(sc.next(), handler));
                                switch (sc.next()) {
                                    case "ONLY":
                                        break;
                                    case "WITH":
                                        newLevel.addEntity(entityFromWord(sc.next(), x, y, sc, levelPic, handler));
                                        break;
                                    case "LINKED":
                                        System.err.println("LINKED is not yet supported! Yell at Matt.");
                                        break;
                                }
                                break;
                            } else {
                                sc.nextLine();
                            }
                        }
                        if (!found) { //Couldn't find specification
                            System.err.println("Encountered an undefined color! " + pixelColor.getRed() + " " + pixelColor.getGreen() + " " + pixelColor.getRed() + " at " + x + ", " + y);
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
    
    //Edit tile colors here:
    private static Tile tileFromColor(Color color, Handler handler) {
        if (color.equals(Color.black)) {
            return new Platform(handler);
        } else if (color.equals(Color.white)) {
            return new Background(handler);
        }
        return null;
    }
    
    //Edit tile keywords (in the text file) here:
    private static Tile tileFromWord(String word, Handler handler) {
        switch (word) {
            case "Platform":
                return new Platform(handler);
            case "Background":
                return new Background(handler);
            default:
                System.err.println("LevelLoader doesn't know what Tile \"" + word + "\" is.");
                return null;
        }
    }
    
    //Edit entity keywords (in the text file) here:
    private static Entity entityFromWord(String word, int x, int y, Scanner sc, BufferedImage pic, Handler handler) {
        switch (word) {
            case "Player":
                return new Player(x, y, handler);
            case "Turret":
                return new Turret(x, y, handler);
            case "Rusher":
                return new Rusher(x, y, handler);
            case "Caster":
                return new Caster(x, y, handler);
            case "Activator":
                Activator newActivator = new Activator(x, y, new Color(pic.getRGB(x, y)), handler);
                while (true) {
                    int targetR = sc.nextInt();
                    if (targetR == -1)
                        break;
                    int targetG = sc.nextInt();
                    int targetB = sc.nextInt();
                    String linked = sc.next();
                    for (int x1 = 0; x1 < pic.getWidth(); x1++) {
                        for (int y1 = 0; y1 < pic.getHeight(); y1++) {
                            Color pixelColor = new Color(pic.getRGB(x1, y1), true);
                            if (pixelColor.getRed() == targetR && pixelColor.getGreen() == targetG && pixelColor.getBlue() == targetB) {
                                newActivator.link(entityFromWord(linked, x1, y1, sc, pic, handler));                     
                            }
                        }
                    }
                }
                return newActivator;
            default:
                System.err.println("LevelLoader doesn't know what Entity \"" + word + "\" is.");
                return null;
        }
    }
}
