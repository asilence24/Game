/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.tiles;

public abstract class Tile {
    //If the tile can not be passed through
    private boolean isSolid;
    
    public Tile(boolean isSolid) {
        this.isSolid = isSolid;
    }
    
    /**
     * @return If the tile can not be passed through
     */
    public boolean isSolid() {
        return isSolid;
    }
}
