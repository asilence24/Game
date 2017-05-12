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
    
    private float speed;
    
    public Player (int maxHealth, float speed, float x, float y, Handler handler) {
        super(maxHealth, speed, x, y, handler);
        this.speed = speed;
    }

    @Override
    public void update() {
        xMove = 0;
        yMove = 0;
        if(handler.getKeyManager().getWPresed()){
            yMove = -speed;
        }
        if(handler.getKeyManager().getSPresed()){
            yMove = speed;
        }
        if(handler.getKeyManager().getAPresed()){
            xMove = -speed;
        }
        if(handler.getKeyManager().getDPresed()){
            xMove = speed;
        }
        move();
    }

    @Override
    public void render(Graphics g) {
        g.fillRect((int)((x - handler.getCamera().xOffset()) * Assets.width), (int)((y - handler.getCamera().yOffset()) * Assets.height), 64, 64);
        //g.drawImage(Assets.player, (int)((x - handler.getCamera().xOffset()) * Assets.width), (int)((y - handler.getCamera().yOffset()) * Assets.height), null);
    }
}
