package model.rackets;

/**
 * Created by Pontus on 2016-03-04.
 */
public interface Racket {
    int getX();
    int getY();
    int getRotation();
    int getLength();

    void moveUp();
    void moveDown();
    void rotateRight();
    void rotateLeft();

    String toString();
}
