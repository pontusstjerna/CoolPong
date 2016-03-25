package model.balls;

import model.World;
import util.Vector2D;
import java.util.Random;

/**
 * Created by pontu on 2016-03-23.
 */
public class StandardBall implements Ball {

    private double x,y;
    private Vector2D direction;
    private Random rand;
    private double speed = 100;
    private double radius = 5;

    private static int nBounces = 0;

    public StandardBall(double x, double y){
        this.x = x;
        this.y = y;

        rand = new Random();
        direction = new Vector2D(rand.nextInt(60) - 30, rand.nextInt(60) - 30).normalize().multiply(speed);
    }

    @Override
    public void update(double deltaTime){
        if(y <= 0){
            direction.negateY();
        }

        if(y + radius*2 >= World.WORLD_HEIGHT){
            direction.negateY();
        }

        x = x + direction.getX()*deltaTime;
        y = y + direction.getY()*deltaTime;
    }

    @Override
    public void bounce(Vector2D normal){
        direction = Vector2D.add(direction, (normal.normalize().multiply(speed*2))).normalize().multiply(speed);
        nBounces++;
        //System.out.println("Supposed speed: " + speed + " actual speed: " + direction.length() + ", nBounces: " + nBounces);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getRadius(){
        return radius;
    }

    @Override
    public Vector2D getDirection(){
        return direction;
    }
}
