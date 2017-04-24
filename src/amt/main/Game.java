/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main;

import amt.main.gfx.Display;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

/**
 *
 * @author asilence24
 */
public class Game extends GameLoop{
    
    private Display display;
    private BufferStrategy bs;
    private Graphics g;
    
    private int width,height;
    
    /**
     * Is called on start of program
     */
    @Override
    public void startup() {
        width = 1280;
        height = 720;
        display = new Display("Game",width,height);
        
        //set up closing operation, don't touch this
        display.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                stop();
            }
        });
    }
    /**
     * Is called to close the program
     */
    @Override
    public void shutdown() {
        System.exit(0);//temp code to stop game
    }
    
    /**
     * Runs non graphics processes
     */
    @Override
    public void update() {
        
    }
    
    /**
     * Runs visual process
     */
    @Override
    public void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        
        draw(g);
        
        bs.show();
        g.dispose();
    }
   /**
    * Is called in render, for organization
    * @param g Current Graphics component
    */
    private void draw(Graphics g){
        g.fillRect(100, 100, 299, 300);
    }
    
}
