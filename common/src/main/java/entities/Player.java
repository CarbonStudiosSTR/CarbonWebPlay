package entities;

import java.io.Serializable;

public class Player implements Entity, Serializable {

    private String name;

    private float posX;
    private float posY;

    private float maxSpeed = 0.5f;
    private float velocity = 0.05f;

    boolean goLeft;
    boolean goRight;
    boolean goUp;
    boolean goDown;
    private float speedX;
    private float speedY;

    public Player(String name) {
        this.name = name;
        this.posX = 10;
        this.posY = 10;
    }

    public Player() {
        this.posX = 10;
        this.posY = 10;
    }

    @Override
    public void update() {
        updateSpeed();
        updatePos();
    }

    private void updateSpeed() {
        if (isMoving()) {
            if (Math.abs(speedX) < maxSpeed) {
                if (goLeft) {
                    speedX = speedX - velocity;
                    if (speedX < -maxSpeed) {
                        speedX = -maxSpeed;
                    }
                }
                if (goRight) {
                    speedX = speedX + velocity;
                    if (speedX > maxSpeed) {
                        speedX = maxSpeed;
                    }
                }
            }
            if (Math.abs(speedY) < maxSpeed) {
                if (goDown) {
                    speedY = speedY - velocity;
                    if (speedY < -maxSpeed) {
                        speedY = -maxSpeed;
                    }
                }
                if (goUp) {
                    speedY = speedY + velocity;
                    if (speedY > maxSpeed) {
                        speedY = maxSpeed;
                    }
                }
            }
        }
        if (!goLeft && !goRight) {
            if (speedX < 0) {
                speedX = speedX + velocity;
                if (speedX > 0) {
                    speedX = 0;
                }
            }
            if (speedX > 0) {
                speedX = speedX - velocity;
                if (speedX < 0) {
                    speedX = 0;
                }
            }
        }
        if (!goUp && !goDown) {
            if (speedY < 0) {
                speedY = speedY + velocity;
                if (speedY > 0) {
                    speedY = 0;
                }
            }
            if (speedY > 0) {
                speedY = speedY - velocity;
                if (speedY < 0) {
                    speedY = 0;
                }
            }
        }
    }

    private void updatePos() {
        posX = posX + speedX;
        posY = posY + speedY;
    }

    private boolean isMoving() {
        return (goDown || goUp || goRight || goLeft);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public boolean isGoLeft() {
        return goLeft;
    }

    public void setGoLeft(boolean goLeft) {
        this.goLeft = goLeft;
    }

    public boolean isGoRight() {
        return goRight;
    }

    public void setGoRight(boolean goRight) {
        this.goRight = goRight;
    }

    public boolean isGoUp() {
        return goUp;
    }

    public void setGoUp(boolean goUp) {
        this.goUp = goUp;
    }

    public boolean isGoDown() {
        return goDown;
    }

    public void setGoDown(boolean goDown) {
        this.goDown = goDown;
    }
}
