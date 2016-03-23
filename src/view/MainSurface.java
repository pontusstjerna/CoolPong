package view;

import model.Ball;
import model.Racket;

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
        System.out.println("Surface initialized!");

        this.rackets = rackets;
        this.balls = balls;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);
    }
}
