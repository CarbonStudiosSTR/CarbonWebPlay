package dl.netty;


import actions.Action;
import actions.actionImpl.LoginAction;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import dl.netty.selfActionHandlers.SelfActionHandler;
import dl.utils.Connection;


public class Client {

    private static Client instance = new Client("127.0.0.1", 5555);

    EventLoopGroup workerPool = new NioEventLoopGroup();

    private final String host;
    private final int port;
    private Integer id;
    private Bootstrap b;
    private ChannelFuture f;

    public static Client getInstance() {
        return instance;
    }

    private Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() {
        try {
            b = new Bootstrap();
            b.group(workerPool);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ClientInitializer());
            f = b.connect(host, port).sync();
            f.channel().writeAndFlush(new LoginAction("dupa2", "dupa2password"));
            id = Connection.CONNECTION_ID;

            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerPool.shutdownGracefully();
            System.out.println("koniec");
        }
    }

    public void writeAction(Action action) {
        SelfActionHandler.selfExecute(action);
        f.channel().writeAndFlush(action);
    }
}

