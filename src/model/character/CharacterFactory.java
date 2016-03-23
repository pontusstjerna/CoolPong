package model.character;

import model.IDrawable;
import model.character.characters.IPlayable;
import model.character.characters.Mackerel;
import model.character.characters.PlayerGull;

/**
 * Created by Pontus on 2016-03-04.
 */
public class CharacterFactory {

    public static IPlayable createPlayer(double x, double y){
        return new PlayerGull(x, y);
    }

    public static IDrawable createMackerel(double x, double y){
        return new Mackerel(x, y);
    }

}
