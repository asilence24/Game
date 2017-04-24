package amt.main;

import amt.main.gfx.Display;
import amt.main.input.KeyManager;
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
    
    private KeyManager keyManager;
    
    
    /**
     * Is called on start of program
     */
    @Override
    public void startup() {
        width = 1280;
        height = 720;
        display = new Display("Game",width,height);
        
        keyManager = new KeyManager();
        
        display.getFrame().addKeyListener(keyManager);
        display.getCanvas().addKeyListener(keyManager);
        
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
        keyManager.update();
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
        
    }
    
}
