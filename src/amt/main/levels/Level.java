/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.levels;

import amt.main.gfx.Assets;
import amt.main.tiles.Tile;
import java.awt.Graphics;

/**
 *
 * @author mgalan11
 */
public class Level {
    Tile[][] tiles;
    
    public Level(int width, int height) {
         tiles = new Tile[width][height];
    }
    
    public void render(Graphics g) {
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[0].length; y++) {
                tiles[x][y].render(x * Assets.width, y * Assets.height, g);
            }
        }
    }
    
    public void setTile(int x, int y, Tile tile) {
        tiles[x][y] = tile;
    }
    
    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }
}
