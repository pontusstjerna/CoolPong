package view;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by pontu on 2016-03-26.
 */
public class MenuSurface extends JPanel {
    List<JButton> buttons;
    List<JToggleButton> toggleButtons;
    ButtonGroup radioButtons;
    JPanel playerSelection;

    public MenuSurface(ActionListener listener){
        initButtons();
        initToggleButtons();
        initRadioButtons();
        addListeners(listener);
        addButtons();
    }

    private void initButtons(){
        buttons = new ArrayList<>();

        buttons.add(new JButton("Start game"));
        buttons.get(0).setVerticalTextPosition(AbstractButton.CENTER);
        buttons.get(0).setHorizontalTextPosition(AbstractButton.LEADING);
    }

    private void initToggleButtons(){
        toggleButtons = new ArrayList<>();

        toggleButtons.add(new JToggleButton("Show vectors"));
    }

    private void initRadioButtons() {
        radioButtons = new ButtonGroup();
        playerSelection = new JPanel(new GridLayout(0,1));

        radioButtons.add(new JRadioButton("0 players (only bots)"));
        radioButtons.add(new JRadioButton("1 player"));
        radioButtons.add(new JRadioButton("2 players"));
    }

    private void addListeners(ActionListener listener){
        for(JButton b : buttons){
            b.addActionListener(listener);
        }

        for(JToggleButton t : toggleButtons){
            t.addActionListener(listener);
        }

        for(int i = 0; i < radioButtons.getButtonCount(); i++){
            radioButtons.getElements().nextElement().addActionListener(listener);
        }
    }

    private void addButtons(){
        for(JButton b : buttons){
            add(b);
        }

        for(JToggleButton t : toggleButtons){
            add(t);
        }

        for(Enumeration<AbstractButton> buttons = radioButtons.getElements(); buttons.hasMoreElements();){
            playerSelection.add(buttons.nextElement());
            //System.out.println(buttons.nextElement().getText());
        }

        add(playerSelection);
    }
}
