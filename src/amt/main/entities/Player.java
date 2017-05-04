/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.entities;

import amt.main.Handler;
import amt.main.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author mgalan11
 */
public class Player extends Mob {
    
    public Player (int maxHealth, float x, float y, Handler handler) {
        super(maxHealth, x, y, handler);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics g) {
        g.fillRect(100, 100, 100, 100);
    }
}
