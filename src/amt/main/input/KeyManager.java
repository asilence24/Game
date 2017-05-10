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
    private boolean escapePressed;
    
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
        //for(int i = 0; i < tapKeys.length; i++){
           // tapKeys[i] = false;
        //}
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
    public boolean getEscapePressed(){return escapePressed;}
}
