package Actions.ActionImpl;

import Actions.SimpleAction;

public class LoginAction extends SimpleAction {

    String login;

    public LoginAction(String login){
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
