package Data;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by anton on 27.03.2017.
 */

public class Database {
    private static Database reference = null;
    private TreeSet<Player> tsPlayer = null;
    private TreeSet<Game> tsGame = null;

    public Database()
    {
        super();
        tsPlayer = new TreeSet<>();
        tsGame = new TreeSet<>();
        defaultPlayers();
    }

    public static Database getInstance()
    {
        if(reference == null)
        {
            reference = new Database();
        }

        return reference;
    }

    public void addPlayer(Player p)
    {
        tsPlayer.add(p);
    }

    public void removePlayer(Player p)
    {
        tsPlayer.remove(p);
    }

    public void addGame(Game g)
    {
        tsGame.add(g);
    }

    public void removeGame(Game g)
    {
        tsGame.remove(g);
    }

    public ArrayList<Player> getPlayers()
    {
        return new ArrayList<>(tsPlayer);
    }

    public ArrayList<Game> getGames()
    {
        return new ArrayList<>(tsGame);
    }

    public void defaultPlayers()
    {
        tsPlayer.add(new Player(1, "Peter", null));
        tsPlayer.add(new Player(2, "Hans", null));
        tsPlayer.add(new Player(3, "OG", null));
    }
}
