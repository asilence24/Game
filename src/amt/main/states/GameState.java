package amt.main.states;

import amt.main.Handler;
import amt.main.levels.LevelLoader;
import java.awt.Graphics;


public class GameState extends State{
    
    private Handler handler;
    
    public GameState(Handler handler){    
        super(handler);
        LevelLoader.loadLevel("test");
    }

    @Override
    public void update(){
        
    }

    @Override
    public void render(Graphics g){
        
    }

}
