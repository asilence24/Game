package amt.main.states;

import amt.main.Handler;
import amt.main.levels.Level;
import amt.main.levels.LevelLoader;
import java.awt.Graphics;


public class GameState extends State{
    
    private Handler handler;
    private Level level;
    
    public GameState(Handler handler){    
        super(handler);
        level = LevelLoader.loadLevel("test", handler);
        handler.setLevel(level);
    }

    @Override
    public void update(){
        level.update();
    }

    @Override
    public void render(Graphics g){
        level.render(g);
    }

}
