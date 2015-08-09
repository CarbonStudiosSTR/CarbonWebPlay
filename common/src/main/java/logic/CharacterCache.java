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

    public void removePlayer(Integer i) {
        playersById.remove(i);
    }

    public Player getPlayer(Integer i) {
        return playersById.get(i);
    }

    public void listPlayers() {
        for (int i = 0; i < playersById.size(); i++)
            System.out.println("id = " + i + " player login: " + playersById.get(i).getName() + " pos " + playersById.get(i).getPosX() + "," + playersById.get(i).getPosY());
    }

}
