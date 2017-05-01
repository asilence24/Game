package amt.main;

import amt.main.input.KeyManager;
import amt.main.input.MouseManager;
import amt.main.states.State;

/**
 *
 * @author asilence24
 */
public class Handler {
    
    private Game game;
    
    public Handler(Game game){
        this.game = game;
    }
    
    public State getGameState(){return game.getGameState();}
    public void closeGame(){game.closeGame();}
    
    public int getWidth(){return game.getWidth();}
    public int getHeight(){return game.getHeight();}
    
    public KeyManager getKeyManager(){return game.getKeyManager();}
    public MouseManager getMouseManager(){return game.getMouseManager();}
    
}
