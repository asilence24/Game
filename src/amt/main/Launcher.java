/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main;

/**
 *
 * @author asilence24
 */
public class Launcher {
    
    private static double frameRate = 1.0/120.0; //120 frames per second
    
    public static void main(String[] args){
        Game game = new Game();
        game.run(frameRate);
    }
    
}
