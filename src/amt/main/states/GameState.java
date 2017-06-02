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
    
    private String levelName;
    
    public static String curLevel;
    
    public GameState(Handler handler){    
        super(handler);
        //temp
        level = LevelLoader.loadLevel("Level5", handler);
        handler.setLevel(level);
        curLevel= "Level5";
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
    
    @Override
    public void setLevel(String levelName){
        level = LevelLoader.loadLevel(levelName, handler);
        handler.setLevel(level);
        curLevel = levelName;
    }
    
}
