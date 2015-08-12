package netty.handlers;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import utils.Connection;

public class ClientLoginHandler extends SimpleChannelInboundHandler<actions.actionImpl.LoginAction> {


    @Override
    protected void messageReceived(ChannelHandlerContext ctx, actions.actionImpl.LoginAction la) throws Exception {
        System.out.println(la.getConnectionId());
        Connection.CONNECTION_ID = la.getConnectionId();
    }
}
