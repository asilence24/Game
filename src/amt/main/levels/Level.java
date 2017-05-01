/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.levels;

import amt.main.tiles.Tile;

/**
 *
 * @author mgalan11
 */
public class Level {
    Tile[][] tiles;
    
    public Level(int width, int height) {
        Tile[][] tile = new Tile[width][height];
    }
    
    /**
     * Set the tile at coordinates (x, y) from the top left
     * @param x The x coordinate (starts at 0)
     * @param y The y coordinate (starts at 0)
     * @param tile The tile to set the spot to
     */
    public void setTile(int x, int y, Tile tile) {
        tiles[x][y] = tile;
    }
    
    /**
     * Get the tile at coordinates (x, y) from the top left
     * @param x The x coordinate (starts at 0)
     * @param y The y coordinate (starts at 0)
     * @return The tile at the spot
     */
    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }
}
