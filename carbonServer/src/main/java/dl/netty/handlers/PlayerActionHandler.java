package dl.netty.handlers;


import actions.PlayerAction;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import dl.logic.CharacterCache;

public class PlayerActionHandler extends SimpleChannelInboundHandler<PlayerAction> {

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, PlayerAction o) throws Exception {

        o.executeAction();
        CharacterCache.getInstance().listPlayers();
    }
}
