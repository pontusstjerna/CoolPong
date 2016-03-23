package model.character;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pontus on 2016-03-04.
 */
public abstract class PickUpAble extends Character {
    public static List<PickUpAble> pickUpAbles = new ArrayList<>();

    public PickUpAble(){
        pickUpAbles.add(this);
    }

    public void lockToCharacter(Character character){
        position = character.position;
        System.out.println(name + " locked to " + character);
    }

    public void unlock(){
        position = new Point.Double(getX(), getY());
    }


}
