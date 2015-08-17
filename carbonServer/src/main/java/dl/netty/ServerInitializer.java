package dl.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import dl.netty.handlers.LoginActionHandler;
import dl.netty.handlers.PlayerActionHandler;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {

    private Integer playerId;

    public ServerInitializer() {
        this.playerId = null;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("encoder", new ObjectEncoder());
        ch.pipeline().addLast("decoder", new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
        ch.pipeline().addLast("sign_in", new LoginActionHandler(this));
        ch.pipeline().addLast("playerAction", new PlayerActionHandler());
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }
}
