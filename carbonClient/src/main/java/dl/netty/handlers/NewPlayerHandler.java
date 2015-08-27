package dl.netty.handlers;

import dl.logic.cache.CharacterCache;
import dl.utils.Connection;
import entities.wrapers.PlayerWrapper;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NewPlayerHandler extends SimpleChannelInboundHandler<PlayerWrapper> {
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, PlayerWrapper playerWrapper) throws Exception {
        CharacterCache.getInstance().addPlayer(playerWrapper.getPlayer(), playerWrapper.getId());
        Connection.CONNECTION_ID = playerWrapper.getId();
    }
}
