package model;

/**
 * Created by Pontus on 2016-03-04.
 */
public interface Racket {
    int getX();
    int getY();
    int rotation();

    void moveUp();
    void moveDown();
    void rotateRight();
    void rotateLeft();

    void addBall();

    String toString();
}
