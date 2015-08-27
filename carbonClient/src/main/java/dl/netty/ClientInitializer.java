package dl.netty;

import dl.netty.handlers.ClientLoginHandler;
import dl.netty.handlers.ClientMoveActionHandler;
import dl.netty.handlers.NewPlayerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class ClientInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("encoder", new ObjectEncoder());
        ch.pipeline().addLast("decoder", new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
        ch.pipeline().addLast("sign_in", new ClientLoginHandler());
        ch.pipeline().addLast("move", new ClientMoveActionHandler());
        ch.pipeline().addLast("create_player", new NewPlayerHandler());
    }
}
