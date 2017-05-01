/*Name:	Alex Silence
 *Date:
 *Period: 7
 *Teacher: Mrs. Krueger
 *Description:
 */
package amt.main.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import amt.main.Handler;


public class Button {
    
    private Handler handler;
    private Color texture;
    private Color highlightTexture;
    private int x,y;
    private int width, height;
    private String text;
    
    private boolean highlighted=false;
    
    public Button(Handler handler, Color texture, Color highlightTexture, int x, int y, int width, int height, String text){
        this.handler = handler;
        this.texture = texture;
        this.highlightTexture = highlightTexture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }
    
    public void update(){
        if(handler.getMouseManager().getMouseX() > x && handler.getMouseManager().getMouseX() < x + width){
            if(handler.getMouseManager().getMouseY() > y && handler.getMouseManager().getMouseY() < y + height){
                highlighted = true;
            } else {
                highlighted = false;
            }
        } else {
            highlighted = false;
        }
    }
    
    public void render(Graphics g){
        
        if(highlighted){
            g.setColor(highlightTexture);
            g.fillRect(x, y, width, height);
        } else {
            g.setColor(texture);
            g.fillRect(x, y, width, height);
        }
        
        /*
        if(highlighted){
            g.drawImage(highlightTexture, x, y, width, height, null);
        } else {
            g.drawImage(texture, x, y, width, height,null);
        }*/
    }
    
    public boolean click(){
        if(highlighted){
            if(handler.getMouseManager().getLeftPressed()){
                return true;
            }
        }
        return false;
    }
    
    //getters
    public String getText(){return text;}
    
}
