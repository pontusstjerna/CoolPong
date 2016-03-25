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

        switch(e.getKeyCode()){
            case KeyEvent.VK_SPACE:
                world.addBall();
                break;
            case KeyEvent.VK_B:
                world.addBalls();
                break;
        }
    }

    public void update(double deltaTime){

        for(int i : movements) {
            switch (i) {
                case KeyEvent.VK_RIGHT:
                    player.rotateRight(deltaTime);
                    break;
                case KeyEvent.VK_LEFT:
                    player.rotateLeft(deltaTime);
                    break;
                case KeyEvent.VK_UP:
                    player.moveUp(deltaTime);
                    break;
                case KeyEvent.VK_DOWN:
                    player.moveDown(deltaTime);
                    break;
            }
        }
    }
}
