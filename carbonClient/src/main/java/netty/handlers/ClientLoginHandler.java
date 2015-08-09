package netty.handlers;

import actions.actionImpl.LoginAnswer;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import utils.Connection;

public class ClientLoginHandler extends SimpleChannelInboundHandler<LoginAnswer> {


    @Override
    protected void messageReceived(ChannelHandlerContext ctx, LoginAnswer la) throws Exception {
        Connection.CONNECTION_ID = la.getId();
    }
}
