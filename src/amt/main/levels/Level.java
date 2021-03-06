/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.levels;

import amt.main.Handler;
import amt.main.entities.Activator;
import amt.main.entities.Entity;
import amt.main.entities.Player;
import amt.main.gfx.Camera;
import amt.main.tiles.Tile;
import java.awt.Color;
import java.awt.Graphics;
import java.util.HashSet;

/**
 *
 * @author mgalan11
 */
public class Level {
    Tile[][] tiles;
    HashSet<Entity> entities, oldEntities, newEntities;
    private Camera camera;
    private Player player;
    private int shakeTimer = 0;
    private int shakeAmount = 0;
    
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
            if (e.isDestroyed()) {
                oldEntities.add(e);
                continue;
            }
            e.update();
        }
        entities.removeAll(oldEntities);
        oldEntities.clear();
        camera.updateCamera();
        
        if (shakeTimer > 0) {
            shakeTimer--;
            shakeAmount --;
        }
    }
    
    public void render(Graphics g) {
        if (shakeTimer > 0) {
            g.translate((int)(2 * shakeAmount * Math.random() - shakeAmount), (int)(2 * shakeAmount * Math.random() - shakeAmount));
        } else {
            g.translate(0, 0);
        }
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[0].length; y++) {
                tiles[x][y].render(x, y, g);
            }
        }
        for (Entity e : entities) {
            e.render(g);
        } 
    }
    
    public void screenShake(int amount, int length) {
        shakeTimer = length;
        shakeAmount = amount;
    }
    
    /**
     * Cast a ray between two points to see if the path of the line is clear.
     * @param x1 The x coordinate of the first target.
     * @param y1 The y coordinate of the first target.
     * @param x2 The x coordinate of the second target.
     * @param y2 The y coordinate of the second target.
     * @return True if the raycast successfully connected the points. (No obstruction). False otherwise.
     */
    public boolean raycast(float x1, float y1, float x2, float y2) {
        float length = (float)Math.hypot(x1 - x2, y1 - y2);
        int checks = (int)(length / .1f);
        float xStep = (x2 - x1) / checks;
        float yStep = (y2 - y1) / checks;
        for (int i = 0; i < checks; i++) {
            if (getTile(x1, y1).isSolid()) {
                return false;
            }
            x1 += xStep;
            y1 += yStep;
        }
        return true;
    }
    
    /**
     * Destroys all activators that have the same colorKey as the activator that called this.
     * Allows you to have an activator that is more than one tile large.
     * @param colorKey The colorKey of the activator that called this method.
     */
    public void removeRedundantActivators(Color colorKey) {
        for (Entity e : entities) {
            if (e instanceof Activator && ((Activator) e).hasSameColorKey(colorKey)) {
                e.destroy();
            }
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
    
    public HashSet<Entity> getEntities() {
        return entities;
    }
    
    public Player getPlayer() {
        return player;
    }
}
