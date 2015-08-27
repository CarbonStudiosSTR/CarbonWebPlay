package dl.netty.handlers;

import actions.ActionWrapper;
import actions.playerActionImpl.MoveAction;
import dl.logic.ActionQueue;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientMoveActionHandler extends SimpleChannelInboundHandler<ActionWrapper<MoveAction>> {

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, ActionWrapper<MoveAction> moveActionActionWrapper) throws Exception {
        ActionQueue.getInstance().addAction(moveActionActionWrapper);
    }
}
