package model;

import model.balls.Ball;
import model.balls.StandardBall;
import model.rackets.Racket;
import model.rackets.StandardRacket;
import util.Vector2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Pontus on 2016-03-04.
 */
public class World{
    public static final int WORLD_WIDTH = 500;
    public static final int WORLD_HEIGHT = 300;

    private final double WORLD_SPEED;

    private Racket[] rackets;
    private List<Ball> balls;

    private Random rand;

    public World(int speed){
        rand = new Random();
        this.WORLD_SPEED = speed;
        createWorld();
    }

    public void update(double deltaTime) {
        controlRacket(1, deltaTime);
        //controlRacket(0, deltaTime);

        updateBalls(deltaTime);
    }

    public void addBall(){
        int x = WORLD_WIDTH/2;
        int y = WORLD_HEIGHT/2;
        balls.add(new StandardBall(x, y, WORLD_SPEED));
        System.out.println("Added ball at (" + x + "," + y + "). " + balls.size() + " ball(s).");
    }

    public void addBalls(){

        for(int i = 0; i < 20000; i++){
            int x = rand.nextInt(WORLD_WIDTH);
            int y = rand.nextInt(WORLD_HEIGHT);
            balls.add(new StandardBall(x, y, WORLD_SPEED));

            if(i % 100000 == 0){
                System.out.println(i/100000);
            }
        }
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
                new StandardRacket(50, WORLD_HEIGHT/2, 100, 50, WORLD_SPEED),
                new StandardRacket(450, WORLD_HEIGHT/2, 100, 50, WORLD_SPEED)
        };
    }

    private void createBalls(){
        balls = new ArrayList<>();
        //addBall();
    }

    private void updateBalls(double deltaTime){
        List<Ball> removeBalls = new ArrayList<>();

        checkCollisions();

        for(Ball b : balls){
            b.update(deltaTime);

            if(b.getX() < 0){ //Add balls out of bounds to remove-list
                rackets[1].addScore();
                removeBalls.add(b);
            }else if(b.getX() > WORLD_WIDTH){
                rackets[0].addScore();
                removeBalls.add(b);
            }
        }

        for(Ball b : removeBalls){ //Remove balls that's outside world
            balls.remove(b);
            addBall();
        }
    }

    private void checkCollisions(){
        for(Racket r : rackets){
            for(Ball b : balls){
                if((b.getX() - b.getRadius() < r.getX() + r.getWidth()/2 &&
                        b.getX() + b.getRadius() > r.getX() - r.getWidth()/2) &&
                        (b.getY() - b.getRadius() < r.getY() + r.getLength()/2 &&
                        b.getY() + b.getRadius() > r.getY() - r.getLength()/2)){
                    b.bounce(new Vector2D(r.getNormal()));
                }
            }
        }
    }

    private void controlRacket(int i, double deltaTime){
        if(rackets[1].getRotation() < 180){
            rackets[1].rotateRight(deltaTime);
        }else if(rackets[1].getRotation() > 180){
            rackets[1].rotateLeft(deltaTime);
        }

        if(balls.size() > 0){
            if(balls.get(0).getY() > rackets[i].getY()){
                rackets[i].moveDown(deltaTime);
            }else{
                rackets[i].moveUp(deltaTime);
            }
        }
    }

    @Override
    public String toString(){
        return "World with " + rackets.length + " rackets and " + balls.size() + " balls.";
    }
}
