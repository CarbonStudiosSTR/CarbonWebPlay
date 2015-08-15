package actions.actionImpl;

import actions.SimpleAction;
import entities.Player;

public class LoginAction extends SimpleAction {

    private String login;
    private String password;
    private Integer playerId;
    private Player player;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public LoginAction(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public void executeAction() {
        System.out.println(login + ", " + password);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getLogin() {
        return login;
    }
}
