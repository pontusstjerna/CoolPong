package view;

import model.balls.Ball;
import model.rackets.Racket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyListener;
import java.util.List;

/**
 * Created by Pontus on 2016-03-04.
 */
public class MainWindow extends JFrame implements ComponentListener {
    public static int WINDOW_WIDTH = 800;
    public static int WINDOW_HEIGHT = 600;

    private final String title;
    private MainSurface surface;
    private MenuSurface menu;

    public MainWindow(String title){
        this.title = title;
    }

    public void init(ActionListener menuListener){
        initWindow();
        menu = new MenuSurface(menuListener);
        add(menu);
        System.out.println("View initialized with width " + WINDOW_WIDTH + " and height " + WINDOW_HEIGHT + ". ");
    }

    @Override
    public void repaint(){
        surface.repaint();
    }

    private void registerKeyListener(KeyListener listener){
        surface.addKeyListener(listener);
        surface.addComponentListener(this);
    }

    public void startGame(Racket[] rackets, List<Ball> balls, KeyListener listener){
        setResizable(true);
        remove(menu);

        surface = new MainSurface(rackets, balls);
        add(surface);

        registerKeyListener(listener);
    }

    private void initWindow(){
        setTitle(title);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
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
