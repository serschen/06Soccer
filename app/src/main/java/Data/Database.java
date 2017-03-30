package Data;

import java.util.TreeSet;

/**
 * Created by anton on 27.03.2017.
 */

public class Database {
    private static Database reference = null;
    TreeSet<Player> tsPlayer = null;
    TreeSet<Game> tsGame = null;

    public Database()
    {
        super();
        tsPlayer = new TreeSet<>();
    }

    public Database getInstance()
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
}
