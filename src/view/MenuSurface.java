package view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pontu on 2016-03-26.
 */
public class MenuSurface extends JPanel {
    List<JButton> buttons;

    public MenuSurface(ActionListener listener){
        initButtons();
        addListeners(listener);
        addButtons();
    }

    private void initButtons(){
        buttons = new ArrayList<>();

        buttons.add(new JButton("Start game"));
        buttons.get(0).setVerticalTextPosition(AbstractButton.CENTER);
        buttons.get(0).setHorizontalTextPosition(AbstractButton.LEADING);
    }

    private void addListeners(ActionListener listener){
        for(JButton b : buttons){
            b.addActionListener(listener);
        }
    }

    private void addButtons(){
        for(JButton b : buttons){
            add(b);
        }
    }
}
