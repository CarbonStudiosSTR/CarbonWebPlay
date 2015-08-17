package dl.logic;


import dl.netty.Client;
import dl.view.GameView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientMain {

   public static void main(String[] args) {
      ExecutorService es = Executors.newFixedThreadPool(2);

      es.execute(() -> new GameView().startup(args));
      es.execute(() -> Client.getInstance().connect());
   }
}
