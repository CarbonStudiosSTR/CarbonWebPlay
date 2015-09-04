package dl.logic;

import dl.logic.gameLoop.ServerGameLoop;
import dl.logic.gameLoop.ServerUpdater;
import dl.netty.Server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Server.getInstance().run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        es.execute(new Runnable() {
            @Override
            public void run() {
                ServerGameLoop gameLoop = new ServerGameLoop(new ServerUpdater());
                while (true) {
                    gameLoop.handle(System.nanoTime());
                }
            }
        });
    }


}
