package model.rackets;

import model.World;
import util.Vector2D;

/**
 * Created by pontu on 2016-03-23.
 */
public class StandardRacket implements Racket {
    private double x,y;
    private int rotation;
    private double speed;
    private int length;
    private int width = 10;

    public StandardRacket(int x, int y, int speed, int length){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.length = length;
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
    public int getRotation() {
        return rotation;
    }

    @Override
    public int getLength(){
        return length;
    }

    @Override
    public int getWidth(){ return width; }

    @Override
    public Vector2D getNormal(){
        return new Vector2D(Math.cos(Math.toRadians(rotation))*50, Math.sin(Math.toRadians(rotation))*50);
    }

    @Override
    public void moveUp() {
        if(y - length/2 > 0){
            y -= speed;
        }
    }

    @Override
    public void moveDown() {
        if(y + length/2 < World.WORLD_HEIGHT){
            y += speed;
        }
    }

    @Override
    public void rotateRight() {
        rotation = (rotation + (int)speed) % 360;
    }

    @Override
    public void rotateLeft() {
        rotation = (rotation - (int)speed) % 360;
    }
}
