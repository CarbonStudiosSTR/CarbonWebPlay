package netty.handlers;


import actions.SimpleAction;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import logic.CharacterCache;

public class PlayerActionHandler extends SimpleChannelInboundHandler {

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        SimpleAction oAction = (SimpleAction)o;
        oAction.executeAction();
        CharacterCache.getInstance().listPlayers();
    }
}
