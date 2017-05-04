/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.levels;

import amt.main.Handler;
import amt.main.entities.Entity;
import amt.main.entities.Player;
import amt.main.gfx.Assets;
import amt.main.tiles.Tile;
import java.awt.Graphics;
import java.util.HashSet;

/**
 *
 * @author mgalan11
 */
public class Level {
    Tile[][] tiles;
    HashSet<Entity> entities;
    
    public Level(int width, int height, Handler handler) {
         tiles = new Tile[width][height];
         entities = new HashSet<>();
         entities.add(new Player(100, 100f, 100f, handler));
    }
    
    public void render(Graphics g) {
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[0].length; y++) {
                tiles[x][y].render(x * Assets.width, y * Assets.height, g);
            }
        }
        for (Entity e : entities) {
            e.render(g);
        }
    }
    
    public void setTile(int x, int y, Tile tile) {
        tiles[x][y] = tile;
    }
    
    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }
    
    public void addEntity(Entity entity) {
        entities.add(entity);
    }
}
