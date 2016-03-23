package model;

import model.character.CharacterFactory;
import model.character.characters.IPlayable;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pontus on 2016-03-04.
 */
public class World{
    public static final int WORLD_WIDTH = 4000;
    public static final int WORLD_HEIGHT = 2000;

    private IPlayable player;
    private List<IDrawable> objects = new ArrayList<>();

    public World(){
        createWorld();
    }

    public void update(){

    }

    public IPlayable getPlayer(){
        return player;
    }

    public List<IDrawable> getDrawables(){
        return objects;
    }

    private void createWorld(){
        createCharacters();

        System.out.println("World created with " + (objects.size() - 1) + " objects.");
    }

    private void createCharacters(){
        player = CharacterFactory.createPlayer(1000, 1000);
        objects.add(player);
        objects.add(CharacterFactory.createMackerel(100, 300));
        objects.add(CharacterFactory.createMackerel(100, 50));
    }

    @Override
    public String toString(){
        return "World with " + (objects.size() - 1) + " objects.";
    }
}
