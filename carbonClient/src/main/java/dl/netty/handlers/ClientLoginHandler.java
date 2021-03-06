package dl.netty.handlers;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import dl.logic.cache.CharacterCache;
import dl.utils.Connection;

public class ClientLoginHandler extends SimpleChannelInboundHandler<actions.actionImpl.LoginAction> {

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, actions.actionImpl.LoginAction la) throws Exception {
        Connection.CONNECTION_ID = la.getPlayerId();
        CharacterCache.getInstance().addPlayer(la.getPlayer(), Connection.CONNECTION_ID);
    }
}
