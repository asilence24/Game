package amt.main.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author asilence24
 */
public class KeyManager implements KeyListener{
    
    private boolean[] keys;
    private boolean wPressed,sPressed,aPressed,dPressed;
    
    public KeyManager(){
        keys = new boolean[256];
    }
    
    public void update(){
        wPressed = keys[KeyEvent.VK_W];
        sPressed = keys[KeyEvent.VK_S];
        aPressed = keys[KeyEvent.VK_A];
        dPressed = keys[KeyEvent.VK_D];
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    
    public boolean getWPresed(){return wPressed;}
    public boolean getSPresed(){return dPressed;}
    public boolean getAPresed(){return aPressed;}
    public boolean getDPresed(){return dPressed;}
}
