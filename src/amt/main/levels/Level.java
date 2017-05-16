/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.levels;

import amt.main.Handler;
import amt.main.entities.Entity;
import amt.main.entities.Player;
import amt.main.gfx.Camera;
import amt.main.tiles.Tile;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author mgalan11
 */
public class Level {
    Tile[][] tiles;
    HashSet<Entity> entities, oldEntities, newEntities;
    private Camera camera;
    private Player player;
    
    public Level(int width, int height, Handler handler) {
        tiles = new Tile[width][height];
        entities = new HashSet<>();
        oldEntities = new HashSet<>();
        newEntities = new HashSet<>();
        camera = new Camera(handler);
        handler.setCamera(camera);
    }
    
    public void update(){
        entities.addAll(newEntities);
        newEntities.clear();
        for (Entity e : entities) {
            e.update();
            if (e.destroy())
                oldEntities.add(e);
        }
        entities.removeAll(oldEntities);
        oldEntities.clear();
        camera.updateCamera();
    }
    
    public void render(Graphics g) {
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[0].length; y++) {
                tiles[x][y].render(x, y, g);
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
    
    public Tile getTile(float x, float y) {
        return tiles[(int)x][(int)y];
    }
    
    public void addEntity(Entity entity) {
        if (entity instanceof Player) {
            player = (Player) entity;
            camera.centerOnEntity(player);
        }
        newEntities.add(entity);
    }
    
    /** @return The width of the level, in tiles. */
    public int getWidth() {
        return tiles.length;
    }
    
    /** @return The height of the level, in tiles. */
    public int getHeight() {
        return tiles[0].length;
    }
    
    public Player getPlayer() {
        return player;
    }
}
