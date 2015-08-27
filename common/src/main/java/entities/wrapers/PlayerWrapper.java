package entities.wrapers;

import entities.Player;

import java.io.Serializable;

public class PlayerWrapper implements Serializable {
    private int Id;
    private Player player;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
