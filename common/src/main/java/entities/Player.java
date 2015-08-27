package entities;

public class Player implements Entity{

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
    }

    public Player() {
        this.posX = 10;
        this.posY = 10;
    }

    @Override
    public void update() {
        System.out.println("plajer zapdejtowany");
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
