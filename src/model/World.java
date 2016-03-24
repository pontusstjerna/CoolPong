package model;

import model.balls.Ball;
import model.balls.StandardBall;
import model.rackets.Racket;
import model.rackets.StandardRacket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Pontus on 2016-03-04.
 */
public class World{
    public static final int WORLD_WIDTH = 500;
    public static final int WORLD_HEIGHT = 300;

    private Racket[] rackets;
    private List<Ball> balls;

    private Random rand;

    public World(){
        rand = new Random();
        createWorld();
    }

    public void update(double deltaTime) {
        updateBalls(deltaTime);
    }

    public void addBall(){
        int x = rand.nextInt(WORLD_WIDTH);
        int y = rand.nextInt(WORLD_HEIGHT);
        balls.add(new StandardBall(x, y));
        System.out.println("Added ball at (" + x + "," + y + "). " + balls.size() + " ball(s).");
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

    private void updateBalls(double deltaTime){
        for(Ball b : balls){
            b.update(deltaTime);
        }
    }

    @Override
    public String toString(){
        return "World with " + rackets.length + " rackets and " + balls.size() + " balls.";
    }
}
