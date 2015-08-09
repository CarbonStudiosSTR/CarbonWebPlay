package netty.handlers;

import Actions.ActionImpl.LoginAction;
import Entities.Player;
import io.netty.channel.ChannelFuture;
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
        la.setConnectionId(id);
        serverInitializer.setPlayerId(id);
        ChannelFuture cf = ctx.write(la);
        ctx.flush();
        if (!cf.isSuccess()) {
            System.out.println("Send failed: " + cf.cause());
        }
    }
}
