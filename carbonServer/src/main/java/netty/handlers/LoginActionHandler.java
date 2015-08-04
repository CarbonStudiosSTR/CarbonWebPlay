package netty.handlers;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.ServerInitializer;

public class LoginActionHandler extends SimpleChannelInboundHandler {

    ServerInitializer serverInitializer;

    public LoginActionHandler(ServerInitializer serverInitializer) {
        this.serverInitializer = serverInitializer;
    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

    }
}
