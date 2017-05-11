package amt.main.ui;

import amt.main.Handler;
import amt.main.gfx.Assets;
import amt.main.states.State;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

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
        
        mainMenu = new Button(handler, Assets.buttonUp, Assets.buttonDown, 
                middle, (handler.getHeight()/2) - (buttonHeight/2),buttonWidth, buttonHeight, "Return to Menu");
        
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
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        g.setColor(Color.white);
        g.drawString(mainMenu.getText(), (handler.getWidth() / 2) - (g.getFontMetrics().stringWidth(mainMenu.getText()) / 2), (handler.getHeight() / 2));
    }
    
    public boolean checkPaused(){
        if(handler.getKeyManager().escapePressed){
            return true;
        }
        return false;
    }
}
