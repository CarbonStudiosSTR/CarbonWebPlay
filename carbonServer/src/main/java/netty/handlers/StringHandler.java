package netty.handlers;

import Entities.Player;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import logic.CharacterCache;

public class StringHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, String s) throws Exception {

        Integer i = CharacterCache.getInstance().addPlayer(new Player());
        System.out.println("utworzono postaæ w pamiêci: pos"+ CharacterCache.getInstance().getPlayer(i).getPosX() + " id: "+i);

    }
}
