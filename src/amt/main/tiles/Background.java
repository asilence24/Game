/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.tiles;

import amt.main.gfx.Assets;
import java.awt.Graphics;

public class Background extends Tile {
    
    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public void render(int xOffset, int yOffset, Graphics g) {
        g.drawImage(Assets.background, xOffset, yOffset, Assets.width, Assets.height, null);
    }
}
