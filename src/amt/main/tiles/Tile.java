/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.tiles;

import amt.main.gfx.Assets;
import java.awt.Graphics;

public abstract class Tile {
    //If the tile can not be passed through
    private boolean isSolid;
    
    public Tile(boolean isSolid) {
        this.isSolid = isSolid;
    }
    
    public void render(Graphics g) {
        g.drawImage(Assets.platform, Assets.width, Assets.height, 64, 64, null);
    }
    
    /** @return If the tile can not be passed through
     */
    public boolean isSolid() {
        return isSolid;
    }
}
