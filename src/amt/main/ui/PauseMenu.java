package amt.main.ui;

import amt.main.Handler;
import amt.main.states.State;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asilence24
 */
public class PauseMenu {
    
    private Handler handler;
    private Color background = new Color(0,0,0,50);
    
    private ArrayList<Button> buttons = new ArrayList<>();
    private Button mainMenu;
    
    private int buttonWidth=300,buttonHeight=100;
    
    public PauseMenu(Handler handler){
        this.handler = handler;
        
        int middle = (handler.getWidth()/2) - (buttonWidth/2);
        
        mainMenu = new Button(handler, Color.green, Color.red, 
                middle, (handler.getHeight()/2) - (buttonHeight/2) ,buttonWidth,buttonHeight, "");
        
        buttons.add(mainMenu);
    }
    
    public void update(){
        buttons.forEach((b) -> {
            b.update();
        });
        
        checkClicks();
    }
    
    private void checkClicks(){
        if(mainMenu.click()){
            State.setState(handler.getMenuState());
        }
    }
    
    public void render(Graphics g){
        g.setColor(background);
        g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
        
        buttons.forEach((b) -> {
            b.render(g);
        });
    }
    
    public boolean checkPaused(){
        if(handler.getKeyManager().getEscapePressed()){
            return true;
        }
        return false;
    }
}
