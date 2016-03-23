package model.character.characters;

import model.IDrawable;
import model.character.Character;

/**
 * Created by Pontus on 2016-03-05.
 */
public interface IPlayable extends IDrawable{
    void move(Character.Direction direction);
    void pickUp();
    void drop();
    boolean hasPickup();
}
