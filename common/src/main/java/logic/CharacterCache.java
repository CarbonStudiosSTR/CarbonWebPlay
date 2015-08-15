package logic;


import entities.Player;

import java.util.concurrent.ConcurrentHashMap;

public class CharacterCache {

    private static CharacterCache instance = new CharacterCache();
    private ConcurrentHashMap<Integer, Player> playersById;


    protected CharacterCache() {
        playersById = new ConcurrentHashMap<Integer, Player>();
    }

    public static CharacterCache getInstance() {
        return instance;
    }

    public Integer addPlayer(Player player) {
        Integer i = 0;
        while (playersById.containsKey(i)) {
            i++;
        }
        playersById.put(i, player);
        return i;
    }

    public void addPlayer(Player player, Integer id){
        playersById.put(id,player);
    }

    public void removePlayer(Integer i) {
        playersById.remove(i);
    }

    public Player getPlayer(Integer i) {
        return playersById.get(i);
    }

    public void listPlayers() {
        for (Player player : playersById.values()) {
            System.out.println(" player login: " + player.getName() + " pos " + player.getPosX() + "," + player.getPosY());
        }

    }

}
