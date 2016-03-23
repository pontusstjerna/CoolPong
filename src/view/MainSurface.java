package view;

import model.IDrawable;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by Pontus on 2016-03-04.
 */
public class MainSurface extends JPanel {
    List<IDrawable> drawables;
    IDrawable player;
    BufferedImage background;
    BufferedImage world;

    private int scaleX = 1;
    private int scaleY = 1;

    public MainSurface(List<IDrawable> drawables, BufferedImage world, BufferedImage background){
        setFocusable(true);
        this.drawables = drawables;
        player = drawables.get(0);
        this.background = background;
        this.world = world;
        System.out.println("Surface initialized!");
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);

        //paintBackground(g2d);
        paintForeground(g2d);
        paintDrawables(g2d);
        paintPlayer(g2d);
    }

    private void paintPlayer(Graphics2D g){
        g.drawImage(player.getImage(),
                (MainWindow.WINDOW_WIDTH/2),
                (MainWindow.WINDOW_HEIGHT/2),
                this);
    }

    private void paintDrawables(Graphics2D g){ //From model to view coordinates
        for(int i = 1; i < drawables.size(); i++){ //Loop without first element
            g.drawImage(drawables.get(i).getImage(),
                    (drawables.get(i).getX() - player.getX() + (MainWindow.WINDOW_WIDTH/2))*scaleX,
                    (drawables.get(i).getY() - player.getY() + (MainWindow.WINDOW_HEIGHT/2))*scaleY,
                    this);
        }
    }

    private void paintForeground(Graphics2D g){
        g.drawImage(clipImage(world), (0), (0), this);
    }

    private void paintBackground(Graphics2D g){
        g.drawImage(clipImage(background),
                player.getX()/3,
                player.getY()/3,
                this);
    }

    private BufferedImage clipImage(BufferedImage uncut){
        return uncut.getSubimage(
                player.getX() - (MainWindow.WINDOW_WIDTH/2),
                player.getY() - (MainWindow.WINDOW_HEIGHT/2),
                MainWindow.WINDOW_WIDTH,
                MainWindow.WINDOW_HEIGHT);
    }
}
