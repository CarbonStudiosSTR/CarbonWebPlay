package entities;

import java.io.Serializable;

public class Player implements Entity, Serializable{

    private float posX;
    private float posY;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

}
