package netty;


import actions.actionImpl.LoginAction;
import actions.playerActionImpl.MoveAction;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import util.MoveEnum;
import utils.Connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Client {

    EventLoopGroup workerPool = new NioEventLoopGroup();

    private final String host;
    private final int port;
    private Integer id;



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
            b.handler(new ClientInitializer());
            ChannelFuture f = b.connect(host, port).sync();

            f.channel().writeAndFlush(new LoginAction("dupa2", "dupa2password"));

            id = Connection.CONNECTION_ID;


            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
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
            }


            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            workerPool.shutdownGracefully();
        }

    }
}

