package controller;

import model.World;
import model.rackets.Racket;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pontus on 2016-03-05.
 */
public class PlayerController implements KeyListener {
    Racket player;
    World world;
    Set<Integer> movements = new HashSet<>();

    public PlayerController(World world){
        player = world.getRackets()[0];
        this.world = world;
        System.out.println("PlayerController initialized!");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        movements.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        movements.remove(e.getKeyCode());
    }

    public void update(){

        for(int i : movements) {
            switch (i) {
                case KeyEvent.VK_RIGHT:
                    player.rotateRight();
                    break;
                case KeyEvent.VK_LEFT:
                    player.rotateLeft();
                    break;
                case KeyEvent.VK_UP:
                    player.moveUp();
                    break;
                case KeyEvent.VK_DOWN:
                    player.moveDown();
                    break;
                case KeyEvent.VK_SPACE:
                    world.addBall();
                    break;
            }
        }
    }
}
