package dl.netty.handlers;

import actions.actionImpl.LoginAction;
import entities.Player;
import entities.wrapers.PlayerWrapper;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import dl.logic.cache.CharacterCache;
import dl.netty.ServerInitializer;

public class LoginActionHandler extends SimpleChannelInboundHandler<LoginAction> {

    ServerInitializer serverInitializer;

    public LoginActionHandler(ServerInitializer serverInitializer) {
        this.serverInitializer = serverInitializer;
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, LoginAction la) throws Exception {
        Player p = new Player(la.getLogin());
        Integer id = CharacterCache.getInstance().addPlayer(p);
        PlayerWrapper playerWrapper = new PlayerWrapper();
        playerWrapper.setId(id);
        playerWrapper.setPlayer(p);
        serverInitializer.setPlayerId(id);
        ctx.write(playerWrapper);
        ctx.flush();
    }
}
