package view;

import model.World;
import model.balls.Ball;
import model.rackets.Racket;
import util.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Pontus on 2016-03-04.
 */
public class MainSurface extends JPanel {

    private Racket[] rackets;
    private List<Ball> balls;
    private boolean showVectors = true;

    public MainSurface(Racket[] rackets, List<Ball> balls){
        setFocusable(true);
        System.out.println("Surface initialized with scale " + scale() + ". ");

        this.rackets = rackets;
        this.balls = balls;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);

        paintWorld(g2d);
        paintBalls(g2d);
        paintRackets(g2d);
    }

    public void switchShowVectors(){
        showVectors = !showVectors;
    }

    private void paintWorld(Graphics2D g){
        g.setColor(new Color(100,100,100));

        int x = MainWindow.WINDOW_WIDTH - (int)(World.WORLD_WIDTH*scale());
        int y = MainWindow.WINDOW_HEIGHT - (int)(World.WORLD_HEIGHT*scale());

        if(x < 0){
            x = 0;
        }

        if(y < 0){
            y = 0;
        }

        g.fillRect(
                x/2,
                y/2,
                (int)(World.WORLD_WIDTH*scale()),
                (int)(World.WORLD_HEIGHT*scale()));
    }

    private void paintRackets(Graphics2D g){

        for(Racket r : rackets){
            g.setColor(new Color(100,200,100));

            int x = (int)((r.getX() - r.getWidth()/2)*scale()) + scaleX();
            int y = (int)((r.getY() - r.getLength()/2)*scale()) + scaleY();
            int middleX = (int)(r.getX()*scale()) + scaleX();
            int middleY = (int)(r.getY()*scale()) + scaleY();

            g.rotate(Math.toRadians(r.getRotation()), middleX, middleY);
            g.fillRect(x, y, (int)(r.getWidth()*scale()),
                    (int)(r.getLength()*scale()));

            g.rotate(Math.toRadians(-r.getRotation()), middleX, middleY);

            g.setColor(Color.red);
            paintVector(r.getNormal(), middleX, middleY, g);
        }
    }

    private void paintBalls(Graphics2D g){
        for(Ball b : balls){
            g.setColor(Color.BLUE);

            int x = (int)(b.getX()*scale()) + scaleX();
            int y = (int)(b.getY()*scale()) + scaleY();

            g.fillRoundRect(x, y,
                    (int)(scale()*b.getRadius()*2), (int)(scale()*b.getRadius()*2),
                    (int)(scale()*b.getRadius()*2), (int)(scale()*b.getRadius())*2);

            g.setColor(Color.red);
            paintVector(b.getDirection(), (int)(x + (b.getRadius()*scale())), (int)(y + (b.getRadius()*scale())), g);
        }
    }

    private void paintVector(Vector2D vector, int startX, int startY, Graphics2D g){
        if(showVectors){
            g.drawLine(startX, startY, (int)(vector.getX()*scale()) + startX, (int)(vector.getY()*scale()) + startY);
        }
    }

    private double scale(){
        return Math.min((double)MainWindow.WINDOW_WIDTH/World.WORLD_WIDTH,
                (double)MainWindow.WINDOW_HEIGHT/World.WORLD_HEIGHT);
    }

    private int scaleX(){
        int scaleX = (MainWindow.WINDOW_WIDTH - (int)(World.WORLD_WIDTH*scale()))/2;

        if(scaleX < 0){
            scaleX = 0;
        }

        return scaleX;
    }

    private int scaleY(){
        int scaleY = (MainWindow.WINDOW_HEIGHT - (int)(World.WORLD_HEIGHT*scale()))/2;

        if(scaleY < 0){
            scaleY = 0;
        }

        return scaleY;
    }
}
