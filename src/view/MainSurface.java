package view;

import model.World;
import model.balls.Ball;
import model.rackets.Racket;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Pontus on 2016-03-04.
 */
public class MainSurface extends JPanel {

    Racket[] rackets;
    List<Ball> balls;

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
        paintRackets(g2d);
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
        g.setColor(new Color(100,200,100));

        int scaleX = (MainWindow.WINDOW_WIDTH - (int)(World.WORLD_WIDTH*scale()))/2;
        int scaleY = (MainWindow.WINDOW_HEIGHT - (int)(World.WORLD_HEIGHT*scale()))/2;

        if(scaleX < 0){
            scaleX = 0;
        }

        if(scaleY < 0){
            scaleY = 0;
        }

        for(Racket r : rackets){
            int x = (int)(r.getX()*scale()) + scaleX;
            int y = (int)((r.getY() - r.getLength()/2)*scale()) + scaleY;
            int middleY = (int)(r.getY()*scale()) + scaleY;

            g.rotate(Math.toRadians(r.getRotation()), x, middleY);
            g.fillRect(x, y, (int)(10*scale()),
                    (int)(r.getLength()*scale()));

            g.rotate(Math.toRadians(-r.getRotation()), x, middleY);
        }
    }

    private double scale(){
        return Math.min((double)MainWindow.WINDOW_WIDTH/World.WORLD_WIDTH,
                (double)MainWindow.WINDOW_HEIGHT/World.WORLD_HEIGHT);
    }
}
