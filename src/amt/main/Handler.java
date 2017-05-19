package amt.main;

import amt.main.gfx.Camera;
import amt.main.input.KeyManager;
import amt.main.input.MouseManager;
import amt.main.levels.Level;
import amt.main.states.State;

/**
 *
 * @author asilence24
 */
public class Handler {
    
    private Game game;
    private Level level;
    private Camera camera;
    
    public Handler(Game game){
        this.game = game;
    }
    
    public State getGameState(){return game.getGameState();}
    public State getMenuState(){return game.getMenuState();}
    public State getLevelSelectionState(){return game.getLevelSelectionState();}
    public void closeGame(){game.closeGame();}
    
    public int getWidth(){return game.getWidth();}
    public int getHeight(){return game.getHeight();}
    
    public KeyManager getKeyManager(){return game.getKeyManager();}
    public MouseManager getMouseManager(){return game.getMouseManager();}
    
    public void setCamera(Camera camera){this.camera = camera;}
    public Camera getCamera(){return camera;}
    
    public void setLevel(Level level){this.level = level;}
    public Level getLevel(){return level;}
}
