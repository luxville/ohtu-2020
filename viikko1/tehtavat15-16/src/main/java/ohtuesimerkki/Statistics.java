package ohtuesimerkki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Statistics {

    private Reader reader;
    private List<Player> playerList;

    public Statistics(Reader reader) {
        this.reader = reader;
        this.playerList = reader.getPlayers();
    }

    public Player search(String name) {
        for (Player player : this.playerList) {
            if (player.getName().contains(name)) {
                return player;
            }
        }

        return null;
    }

    public List<Player> team(String teamName) {
        ArrayList<Player> playersOfTeam = new ArrayList<Player>();

        for (Player player : this.playerList) {
            if (player.getTeam().equals(teamName)) {
                playersOfTeam.add(player);
            }
        }
        
        return playersOfTeam;
    }

    public List<Player> topScorers(int howMany) {
        Collections.sort(playerList);
        ArrayList<Player> topScorers = new ArrayList<Player>();
        Iterator<Player> playerIterator = playerList.iterator();

        while (howMany>=0) {
            topScorers.add( playerIterator.next() );            
            howMany--;
        }

        return topScorers;
    }

}
