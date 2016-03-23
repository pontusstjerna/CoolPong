package model.character.characters;

import model.character.PickUpAble;

/**
 * Created by Pontus on 2016-03-04.
 */
public class Mackerel extends PickUpAble{
    public Mackerel(double x, double y){

        //Mutate the shit out of the position
        position.x = x;
        position.y = y;

        width = 100;
        height = 50;
    }
}
