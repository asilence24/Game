package amt.main.states;

import amt.main.Handler;
import amt.main.levels.Level;
import amt.main.levels.LevelLoader;
import amt.main.ui.PauseMenu;
import java.awt.Graphics;


public class GameState extends State{
    
    private Handler handler;
    private Level level;
    
    private boolean paused=false;
    private PauseMenu pauseMenu;
    
    public GameState(Handler handler){    
        super(handler);
        level = LevelLoader.loadLevel("test", handler);
        pauseMenu = new PauseMenu(handler);
        this.handler = handler;
    }
    
    @Override
    public void update(){
        if(!paused){
            level.update();
        } else {
            pauseMenu.update();
        }
        paused = pauseMenu.checkPaused();
    }

    @Override
    public void render(Graphics g){
        level.render(g);
        if(paused){
            pauseMenu.render(g);
        }
    }

    @Override
    public void reloadState() {
        handler.getKeyManager().escapePressed=false;
        paused = false;
    }
    
}
