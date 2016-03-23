package model.character;

import model.IDrawable;
import model.ImageHandler;
import model.World;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pontus on 2016-03-04.
 */
public abstract class Character implements IDrawable {
    public enum Direction {RIGHT, LEFT, UP, DOWN}
    public List<Character> characters = new ArrayList<>();

    protected BufferedImage image;
    protected Point.Double position;
    protected double speedX = 1;
    protected double speedY = 1;
    protected String name = "Unnamed.";
    protected int width = 100;
    protected int height = 100;
    public Character(){
        characters.add(this);
        name = getClass().getSimpleName();
        position = new Point.Double(0,0);
        image = ImageHandler.loadImage(getClass().getSimpleName());
    }

    public double getDistance(double x, double y){
        double dx = position.x - x;
        double dy = position.y - y;

        //Pythagoras
        return Math.sqrt((dx*dx) + (dy*dy));
    }

    public double getDistance(Point.Double position){
        return position.distance(this.position);
    }

    @Override
    public BufferedImage getImage(){
        return image;
    }

    @Override
    public int getX(){
        return (int)position.x;
    }

    @Override
    public int getY(){
        return (int)position.y;
    }

    public void move(Direction dir){
        switch(dir){
            case RIGHT:
                moveRight();
                break;
            case LEFT:
                moveLeft();
                break;
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
        }
    }

    @Override
    public String toString(){
        return name + " X: " + position.x + " Y: " + position.y + " SpeedX: " + speedX + " SpeedY: " + speedY;
    }

    /*
    private BufferedImage loadImage(){
        BufferedImage image = null;
            try{
                image = ImageIO.read(getClass().getResource("/model/images/" + name + ".png"));
            }catch(IOException e){
                System.out.println("Unable to load " + name + ".png! This was the cause: " + e.toString());
            }
        return image;
    }*/

    private void moveRight(){
        if(position.x < World.WORLD_WIDTH - width) {
            position.x += speedX;
        }
    }

    private void moveLeft(){
        if(position.x > 0){
            position.x -= speedX;
        }
    }

    private void moveUp(){
        if(position.y > 0) {
            position.y -= speedY;
        }
    }

    private void moveDown(){
        if(position.y < World.WORLD_HEIGHT - height) {
            position.y += speedY;
        }
    }
}
