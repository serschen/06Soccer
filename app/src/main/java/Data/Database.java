package Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

/**
 * Created by anton on 27.03.2017.
 */

public class Database {
    private static Database reference = null;
    private TreeSet<Player> tsPlayer = null;
    private TreeSet<Game> tsGame = null;
    private int id = 0;
    private Player currentPlayer = null;

    public Database()
    {
        super();
        tsPlayer = new TreeSet<>();
        tsGame = new TreeSet<>();
        defaultPlayers();
        defaultGames();
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
        tsPlayer.add(new Player(getId(), "Peter", null));
        tsPlayer.add(new Player(getId(), "Hans", null));
        tsPlayer.add(new Player(getId(), "OG", null));
    }

    public void defaultGames()
    {
        tsGame.add(new Game(1, new Date(), 1, 5));
        tsGame.add(new Game(2, new Date(), 5, 0));
    }

    public int getId()
    {
        id++;
        return id;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
