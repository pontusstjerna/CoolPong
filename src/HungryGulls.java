import controller.MainController;

import javax.swing.*;

/**
 * Created by Pontus on 2016-03-04.
 */
public class HungryGulls {
    public static void main(String args[]){
        SwingUtilities.invokeLater(() -> new MainController().startGame());
    }
}
