/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.main.entities;

import amt.main.Direction;
import amt.main.Handler;

public class PlayerBullet extends Projectile {
    
    public PlayerBullet(int x, int y, Direction dir, Handler handler) {
        super(x, y, 20, dir, handler);
    }
}
