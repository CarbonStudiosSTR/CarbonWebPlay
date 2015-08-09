package netty.handlers;

import actions.actionImpl.LoginAction;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import utils.Connection;

public class ClientLoginHandler extends SimpleChannelInboundHandler<LoginAction> {


    @Override
    protected void messageReceived(ChannelHandlerContext ctx, LoginAction la) throws Exception {
        Connection.CONNECTION_ID = la.getConnectionId();
    }
}
