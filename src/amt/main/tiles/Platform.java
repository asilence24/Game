/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.tiles;

import amt.main.gfx.Assets;
import java.awt.Graphics;

public class Platform extends Tile {
    
    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public void render(int x, int y, Graphics g) {
        g.drawImage(Assets.platform, x, y, Assets.width, Assets.height, null);
    }
}
