package model.rackets;

import model.World;
import util.Vector2D;

/**
 * Created by pontu on 2016-03-23.
 */
public class StandardRacket implements Racket {
    private double x,y;
    private double rotation;
    private double speed;
    private int length;
    private int width = 10;
    private int score = 0;

    public StandardRacket(int x, int y, int speed, int length, double WORLD_SPEED){
        this.x = x;
        this.y = y;
        this.speed = speed*WORLD_SPEED;
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
        return (int)rotation;
    }

    @Override
    public int getLength(){
        return length;
    }

    @Override
    public int getWidth(){ return width; }

    @Override
    public int getScore(){
        return score;
    }

    @Override
    public void addScore(){
        score++;
        System.out.println(toString() + " scored! Current score: " + score);
    }

    @Override
    public Vector2D getNormal(){
        return new Vector2D(Math.cos(Math.toRadians(rotation))*50, Math.sin(Math.toRadians(rotation))*50);
    }

    @Override
    public void moveUp(double deltaTime) {
        if(y - length/2 > 0){
            y -= speed*deltaTime;
        }
    }

    @Override
    public void moveDown(double deltaTime) {
        if(y + length/2 < World.WORLD_HEIGHT){
            y += speed*deltaTime;
        }
    }

    @Override
    public void rotateRight(double deltaTime) {
        rotation = (rotation + speed*deltaTime) % 360;
    }

    @Override
    public void rotateLeft(double deltaTime) {
        rotation = (rotation - speed*deltaTime) % 360;
    }
}
