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
    
    private Handler handler;
    private float speed;
    
    public Player (int maxHealth, float speed, float x, float y, Handler handler) {
        super(maxHealth, speed, x, y, handler);
        this.speed = speed;
        this.handler = handler;
    }

    @Override
    public void update() {
        if(handler.getKeyManager().getWPresed()){
            y-=speed;
        }
        if(handler.getKeyManager().getSPresed()){
            y+=speed;
        }
        if(handler.getKeyManager().getAPresed()){
            x-=speed;
        }
        if(handler.getKeyManager().getDPresed()){
            x+=speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int)((x - handler.getCamera().xOffset()) * Assets.tileWidth), (int)((y - handler.getCamera().yOffset()) * Assets.tileHeight), null);
    }
}
