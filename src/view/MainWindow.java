package view;

import model.Ball;
import model.Racket;

import javax.swing.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by Pontus on 2016-03-04.
 */
public class MainWindow extends JFrame implements ComponentListener {
    public static int WINDOW_WIDTH = 800;
    public static int WINDOW_HEIGHT = 600;

    private final String title;
    private MainSurface surface;

    public MainWindow(String title){
        this.title = title;
    }

    public void init(Racket[] rackets, List<Ball> balls){
        initWindow();
        surface = initSurface(rackets, balls);
        add(surface);
        System.out.println("View initialized!");
    }

    @Override
    public void repaint(){
        surface.repaint();
    }

    public void registerKeyListener(KeyListener listener){
        surface.addKeyListener(listener);
        surface.addComponentListener(this);
    }

    private void initWindow(){
        setTitle(title);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private MainSurface initSurface(Racket[] rackets, List<Ball> balls){
        return new MainSurface(rackets, balls);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        WINDOW_WIDTH = e.getComponent().getWidth();
        WINDOW_HEIGHT = e.getComponent().getHeight();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
