package amt.main.states;

import amt.main.Handler;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import amt.main.ui.Button;


public class MenuState extends State{
    
    private int buttonWidth=300,buttonHeight=100;
    
    private Button startButton;
    private Button closeButton;
    
    private ArrayList<Button> buttons = new ArrayList<>();
    
    private int middle;
    
    private Handler handler;
    
    public MenuState(Handler handler){
        super(handler);
        this.handler = handler;
        
        middle = (handler.getWidth()/2) - (buttonWidth/2);
        
        startButton = new Button(handler, Color.black, Color.blue,
                middle, (handler.getHeight()/4) - (buttonHeight/2), buttonWidth, buttonHeight, "Start Game");
        closeButton = new Button(handler, Color.green, Color.red, 
                middle, (handler.getHeight()/2) - (buttonHeight/2) ,buttonWidth,buttonHeight, "");
        
        buttons.add(startButton);
        buttons.add(closeButton);
    }
    
    @Override
    public void update(){
        for(Button b: buttons){
            b.update();
        }
        checkButtons();
    }
    
    /**
     * update button clicking
     */
    private void checkButtons(){
        if(startButton.click()){
            State.setState(handler.getGameState());
        } 
        if(closeButton.click()){
            handler.closeGame();
        }
    }
    
    @Override
    public void render(Graphics g){
        for(Button b: buttons){
            b.render(g);
        }
        
        //draws text
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        g.setColor(Color.white);
        
        g.drawString(startButton.getText(), middle - g.getFontMetrics().stringWidth(startButton.getText()), (handler.getHeight()/4) - (buttonHeight/2));
    }

}
