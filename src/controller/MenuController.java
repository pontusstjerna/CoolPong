package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pontu on 2016-03-26.
 */
public class MenuController implements ActionListener {
    private boolean done = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton){
            actOnButton((JButton) e.getSource());
        }
    }

    public boolean done(){
        return done;
    }

    private void actOnButton(JButton button){
        if(button.getText() == "Start game"){
            System.out.println("Starting game!");
            done = true;
        }
    }
}
