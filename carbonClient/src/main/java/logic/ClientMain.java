package logic;


import netty.Client;
import view.GameView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientMain {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    new GameView().startup();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        es.execute(new Runnable() {
            @Override
            public void run() {
                Client.getInstance().connect();
            }
        });
    }
}
