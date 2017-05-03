/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.tiles;

import java.awt.Graphics;

public abstract class Tile {
    
    public abstract void render(int x, int y, Graphics g);
    
    /** @return If the tile can not be passed through
     */
    public abstract boolean isSolid();
}
