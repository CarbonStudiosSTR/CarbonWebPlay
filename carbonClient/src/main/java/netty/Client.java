package netty;


import actions.Action;
import actions.actionImpl.LoginAction;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import utils.Connection;


public class Client {

    private static Client instance = new Client("127.0.0.1", 5555);

    EventLoopGroup workerPool = new NioEventLoopGroup();

    private final String host;
    private final int port;
    private Integer id;
    private Bootstrap b;
    private ChannelFuture f;

    public static Client getInstance(){
        return instance;
    }

    private Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void writeAction(Action action) {
        f.channel().writeAndFlush(action);
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


           /* BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for (; ; ) {
                String line = in.readLine();
                if (line != null) {
                    if (line.equals("u")) {
                        f.channel().writeAndFlush(new MoveAction(0, MoveEnum.UP_START));
                    } else if (line.equals("d")) {
                        f.channel().writeAndFlush(new MoveAction(Connection.CONNECTION_ID, MoveEnum.DOWN_START));
                    } else if (line.equals("l")) {
                        f.channel().writeAndFlush(new MoveAction(Connection.CONNECTION_ID, MoveEnum.LEFT_START));
                    } else if (line.equals("r")) {
                        f.channel().writeAndFlush(new MoveAction(Connection.CONNECTION_ID, MoveEnum.RIGHT_START));
                    }

                }
                if ("bye".equals(line.toLowerCase())) {
                    f.channel().closeFuture().sync();
                    break;
                }
            }  */


            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerPool.shutdownGracefully();
            System.out.println("koniec");
        }

    }
}

