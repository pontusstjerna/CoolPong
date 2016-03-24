package model.rackets;

import util.Vector2D;

/**
 * Created by Pontus on 2016-03-04.
 */
public interface Racket {
    double getX();
    double getY();
    int getRotation();
    int getLength();
    int getWidth();
    Vector2D getNormal();

    void moveUp();
    void moveDown();
    void rotateRight();
    void rotateLeft();

    String toString();
}
