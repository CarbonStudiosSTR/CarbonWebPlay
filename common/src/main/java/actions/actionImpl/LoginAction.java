package actions.actionImpl;

import actions.SimpleAction;

public class LoginAction extends SimpleAction {

    private String login;
    private String password;
    private Integer connectionId;

    public Integer getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(Integer connectionId) {
        this.connectionId = connectionId;
    }

    public LoginAction(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public void executeAction() {
        System.out.println(login + ", " + password);
    }

    public String getLogin() {
        return login;
    }
}
