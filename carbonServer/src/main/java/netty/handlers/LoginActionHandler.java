package netty.handlers;

import actions.actionImpl.LoginAction;
import actions.actionImpl.LoginAnswer;
import entities.Player;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import logic.CharacterCache;
import netty.ServerInitializer;

public class LoginActionHandler extends SimpleChannelInboundHandler<LoginAction> {

    ServerInitializer serverInitializer;

    public LoginActionHandler(ServerInitializer serverInitializer) {
        this.serverInitializer = serverInitializer;
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, LoginAction la) throws Exception {
        Player p = new Player(la.getLogin());
        Integer id = CharacterCache.getInstance().addPlayer(p);
        la.executeAction();
        serverInitializer.setPlayerId(id);
        LoginAnswer response = new LoginAnswer(id);
        ctx.write(response);

    }
}
