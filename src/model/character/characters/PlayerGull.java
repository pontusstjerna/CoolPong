package model.character.characters;

import model.character.Character;
import model.character.PickUpAble;

/**
 * Created by Pontus on 2016-03-04.
 */
public class PlayerGull extends Character implements IPlayable {
    private int health = 100;
    private PickUpAble pickedUp;
    private final int PICKUP_DISTANCE = 50;

    public PlayerGull(double x, double y){
        position.x = x;
        position.y = y;
    }

    @Override
    public void pickUp(){
        if(pickedUp == null){
            PickUpAble closest = closestPickup();
            if(pickUpWithinReach(closest, PICKUP_DISTANCE)){
                pickedUp = closest;
                closest.lockToCharacter(this);
            }
        }
    }

    @Override
    public void drop(){
        if(pickedUp != null){
            pickedUp.unlock();
            pickedUp = null;
        }
    }

    @Override
    public boolean hasPickup(){
        return pickedUp != null;
    }

    private PickUpAble closestPickup(){
        PickUpAble closest = PickUpAble.pickUpAbles.get(0);
        for(PickUpAble pickUp : PickUpAble.pickUpAbles){
            if(pickUp.getDistance(position) < closest.getDistance(position)){
                closest = pickUp;
            }
        }
        return closest;
    }

    private boolean pickUpWithinReach(PickUpAble pickUp, double minDistance){
        return (pickUp.getDistance(position) <= minDistance);
    }
}
