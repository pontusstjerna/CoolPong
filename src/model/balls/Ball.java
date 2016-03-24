package model.balls;

import util.Vector2D;

/**
 * Created by pontu on 2016-03-23.
 */
public interface Ball {
    double getX();
    double getY();
    double getRadius();
    Vector2D getDirection();
    void update(double deltaTime);
}
