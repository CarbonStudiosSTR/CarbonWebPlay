package netty;


import Actions.ActionImpl.MoveAction;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ObjectEncoder;


public class Client {

    EventLoopGroup workerPool = new NioEventLoopGroup();

    private final String host;
    private final int port;

    public static void main(String[] args) {
        new Client("127.0.0.1", 5555).connect();
    }

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() {


        try {
            Bootstrap b = new Bootstrap();
            b.group(workerPool);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    //ch.pipeline().addLast(new TimeClientHandler());
                    //ch.pipeline().addLast("encoder", new ObjectEncoder());
                    //ch.pipeline().addLast("stringencoder", new StringEncoder());
                    ch.pipeline().addLast("encoder", new ObjectEncoder());


                }
            });

            ChannelFuture f = b.connect(host, port).sync();
            //LoginAction la = new LoginAction("dupa");
            //f.channel().writeAndFlush(new LoginAction("dupa"));

            f.channel().writeAndFlush(new MoveAction());

            //System.out.println("wysylam LoginAction "+la.getLogin()+" z "+f.channel().localAddress().toString()+" do "+f.channel().remoteAddress().toString());

            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerPool.shutdownGracefully();
        }

    }
}

