package controller;

import model.character.Character.Direction;
import model.character.characters.IPlayable;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Pontus on 2016-03-05.
 */
public class PlayerController implements KeyListener {
    IPlayable player;
    Set<Direction> movements = new HashSet<>();

    public PlayerController(IPlayable player){
        this.player = player;
        System.out.println("PlayerController initialized!");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_RIGHT:

                //Tries to add if there is 0 of this element in the set
                movements.add(Direction.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                movements.add(Direction.LEFT);
                break;
            case KeyEvent.VK_UP:
                movements.add(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                movements.add(Direction.DOWN);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                movements.remove(Direction.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                movements.remove(Direction.LEFT);
                break;
            case KeyEvent.VK_UP:
                movements.remove(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                movements.remove(Direction.DOWN);
                break;
            case KeyEvent.VK_SPACE:
                if(!player.hasPickup()){
                    player.pickUp();
                }else{
                    player.drop();
                }
                break;
        }
    }

    public void update(){
        for(Direction dir : movements){
            player.move(dir);
        }
    }


}
