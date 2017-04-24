/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main;

import amt.main.gfx.Display;

/**
 *
 * @author asilence24
 */
public class Game extends GameLoop{
    
    private Display display;
    
    @Override
    public void startup() {
        display = new Display("Game",1280,720);
    }

    @Override
    public void shutdown() {
        
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render() {
        
    }
    
}
