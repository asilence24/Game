package amt.main.states;

import amt.main.Handler;
import amt.main.gfx.Assets;
import amt.main.ui.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author asilence24
 */
public class LevelSelectionState extends State{
    
    private Handler handler;
    
    private int buttonWidth = 150, buttonHeight = 50;
    private ArrayList<Button> buttons = new ArrayList<>();
    
    private Button backButton;
    private Button rightArrow, leftArrow;
    private Button startButton;
    
    public LevelSelectionState(Handler handler){
        super(handler);
        this.handler = handler;
        
        backButton = new Button(handler, Assets.buttonUp, Assets.buttonDown,
                0, 0, buttonWidth, buttonHeight, "<- Back To Menu");
        rightArrow = new Button(handler, Assets.rightArrow, Assets.rightArrowDown,
                ((handler.getWidth() / 2) - (buttonWidth)) / 4,100, 78, 60, "");
        leftArrow = new Button(handler, Assets.leftArrow, Assets.leftArrowDown,
                (int)(handler.getWidth() / 1.2) - (buttonWidth),100, 78, 60, "");
        startButton = new Button(handler, Assets.buttonUp, Assets.buttonDown,
                (handler.getWidth() / 2) - (buttonWidth), (int) (handler.getHeight() / 1.3) - (buttonHeight / 2), buttonWidth * 2, buttonHeight * 2, "Start Game");
        
        buttons.add(backButton);
        buttons.add(rightArrow);
        buttons.add(leftArrow);
        buttons.add(startButton);
    }
    
    @Override
    public void update() {
        buttons.forEach((b) -> {
            b.update();
        });
        buttons();
    }
    
    private void buttons(){
        if(backButton.click()){
            State.setState(handler.getMenuState());
        }
    }
    
    @Override
    public void render(Graphics g) {
        buttons.forEach((b) -> {
            b.render(g);
        });
        
        //text
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        g.setColor(Color.white);
        
        g.drawString(backButton.getText(), 10, buttonHeight/2);
        g.drawString(startButton.getText(), (handler.getWidth() / 2) - (g.getFontMetrics().stringWidth(startButton.getText()) / 2),
                (int)(startButton.getY() + 50));
        
    }

    @Override
    public void reloadState() {
        
    }
    
}
