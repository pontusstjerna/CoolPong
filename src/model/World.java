package model;

import model.balls.Ball;
import model.rackets.Racket;
import model.rackets.StandardRacket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pontus on 2016-03-04.
 */
public class World{
    public static final int WORLD_WIDTH = 500;
    public static final int WORLD_HEIGHT = 300;

    private Racket[] rackets;
    private List<Ball> balls;

    public World(){
        createWorld();
    }

    public void update() {

    }

    public void addBall(){
        System.out.println("Added ball. " + balls.size() + " balls.");
    }

    public Racket[] getRackets(){
        return rackets;
    }

    public List<Ball> getBalls(){
        return balls;
    }

    private void createWorld(){
        createRackets();
        createBalls();
        System.out.println("World created with " + rackets.length + " rackets and " + balls.size() + " balls.");
    }

    private void createRackets(){
        rackets = new Racket[] {
                new StandardRacket(50, WORLD_HEIGHT/2, 1, 50),
                new StandardRacket(450, WORLD_HEIGHT/2, 1, 50)
        };
    }

    private void createBalls(){
        balls = new ArrayList<>();
    }

    @Override
    public String toString(){
        return "World with " + rackets.length + " rackets and " + balls.size() + " balls.";
    }
}
