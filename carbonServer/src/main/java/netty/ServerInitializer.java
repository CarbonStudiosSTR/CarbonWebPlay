package netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import netty.handlers.LoginActionHandler;
import netty.handlers.MoveActionHandler;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {

    private Integer playerId;

    public ServerInitializer() {
        this.playerId = null;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("decoder", new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
        if (playerId == null) {
            ch.pipeline().addLast("login", new LoginActionHandler(this));
        }
        ch.pipeline().addLast("moveHadler", new MoveActionHandler());
        if (playerId != null){
            ch.pipeline().remove("login");
        }
    }

}
