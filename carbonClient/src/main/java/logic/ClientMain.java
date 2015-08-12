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

        System.out.println(es.toString());

                                                       /*
        new Client("127.0.0.1", 5555).connect();
        try {
            new GameView().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }                                                */

    }


}
