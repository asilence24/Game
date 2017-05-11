package amt.main.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author asilence24
 */
public class KeyManager implements KeyListener{
    
    private boolean[] holdKeys, tapKeys;
    private boolean wPressed,sPressed,aPressed,dPressed;
    public boolean escapePressed=false;
    
    public KeyManager(){
        holdKeys = new boolean[256];
        tapKeys = new boolean[256];
    }
    
    public void update(){
        wPressed = holdKeys[KeyEvent.VK_W];
        sPressed = holdKeys[KeyEvent.VK_S];
        aPressed = holdKeys[KeyEvent.VK_A];
        dPressed = holdKeys[KeyEvent.VK_D];
        escapePressed = tapKeys[KeyEvent.VK_ESCAPE];
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        holdKeys[e.getKeyCode()] = true;
        tapKeys[e.getKeyCode()] = !tapKeys[e.getKeyCode()];
    }

    @Override
    public void keyReleased(KeyEvent e) {
        holdKeys[e.getKeyCode()] = false;
    }
    
    public boolean getWPresed(){return wPressed;}
    public boolean getSPresed(){return sPressed;}
    public boolean getAPresed(){return aPressed;}
    public boolean getDPresed(){return dPressed;}
}
