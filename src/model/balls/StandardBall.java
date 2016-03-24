package model.balls;

import util.Vector2D;
import java.util.Random;

/**
 * Created by pontu on 2016-03-23.
 */
public class StandardBall implements Ball {

    private double x,y;
    private Vector2D direction;
    private Random rand;

    public StandardBall(double x, double y){
        this.x = x;
        this.y = y;

        rand = new Random();
        direction = new Vector2D(rand.nextDouble(), rand.nextDouble()).normalize();
    }

    @Override
    public int getX() {
        return (int)x;
    }

    @Override
    public int getY() {
        return (int)y;
    }
}
