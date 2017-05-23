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
    private TreeSet<Userdata> tsUserdata = null;
    private int id = 0;
    private int gameId = 0;
    private Player currentPlayer = null;
    private Game currentGame = null;
    private Userdata loggedInUser = null;

    public Database()
    {
        super();
        tsPlayer = new TreeSet<>();
        tsGame = new TreeSet<>();
        tsUserdata = new TreeSet<>();
        defaultPlayers();
        defaultGames();
        defaultUsers();
    }

    public static Database getInstance()
    {
        if(reference == null)
        {
            reference = new Database();
        }

        return reference;
    }

    public int getId()
    {
        id++;
        return id;
    }

    public int getGameId() {
        gameId++;
        return gameId;
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

    public void addPlayerTeamOne(Player newPlayer) {
        currentGame.addPlayerTeamOne(newPlayer);
    }

    public void addPlayerTeamTwo(Player newPlayer) {
        currentGame.addPlayerTeamTwo(newPlayer);
    }

    public void removePlayerTeamOne(Player oldPlayer) {
        currentGame.removePlayerTeamOne(oldPlayer);
    }

    public void removePlayerTeamTwo(Player oldPlayer) {
        currentGame.removePlayerTeamTwo(oldPlayer);
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
        tsPlayer.add(new Player(getId(), "Lukas", null));
        tsPlayer.add(new Player(getId(), "Rudolf", null));
    }

    public void defaultGames()
    {
        tsGame.add(new Game(getGameId(), new Date(), 1, 5));
        tsGame.add(new Game(getGameId(), new Date(), 5, 0));
        tsGame.add(new Game(getGameId(), new Date(), 5, 8));
        tsGame.add(new Game(getGameId(), new Date(), 2, 3));
    }

    public void defaultUsers()
    {
        tsUserdata.add(new Userdata("test", "test", "a"));
    }

    public TreeSet<Userdata> getTsUserdata() {
        return tsUserdata;
    }

    public ArrayList<Userdata> getUserdata()
    {
        return new ArrayList<>(tsUserdata);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public void setTsUserdata(TreeSet<Userdata> tsUserdata) {
        this.tsUserdata = tsUserdata;
    }

    public Boolean checkUserData(String username, String password)
    {
        Boolean ret = false;

        for(Userdata user:tsUserdata)
        {
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
            {
                loggedInUser = user;
                ret = true;
            }
        }

        //return ret;
        return true;
    }
}
