package Data;

import java.text.SimpleDateFormat;
import android.os.AsyncTask;
import android.os.StrictMode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import junit.framework.Test;

import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import NetworkHandler.AddPlayer;
import NetworkHandler.Controller;
import NetworkHandler.DeletePlayer;
import NetworkHandler.PlayerCollectionHandler;
import NetworkHandler.PlayerHandler;
import NetworkHandler.SetPassword;

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
    private Player loggedInUser = null;
    private TreeSet<Player> filteredPlayer = null;
    private TreeSet<Game> filteredGames = null;

    public Database()
    {
        super();
        tsPlayer = new TreeSet<>();
        tsGame = new TreeSet<>();
        tsUserdata = new TreeSet<>();
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

    public int getId()
    {
        id++;
        return id;
    }

    public int getGameId() {
        gameId++;
        return gameId;
    }

    public void addPlayer(Player p, String password)
    {
        Player[] player = new Player[1];
        player[0] = p;
        AddPlayer addPlayer = new AddPlayer();
        addPlayer.execute(player);

        //setPassword(p, password);
    }

    public String removePlayer(Player p) throws ExecutionException, InterruptedException {
        Player[] player = new Player[1];
        player[0] = p;
        DeletePlayer deletePlayer = new DeletePlayer();
        deletePlayer.execute(player);
        return deletePlayer.get();
    }

    public void setPassword(Player player, String password)
    {
        player.setPassword(convertPassMd5(password));
        Player[] p = new Player[1];
        p[0] = player;

        SetPassword setPassword = new SetPassword();
        setPassword.execute(p);
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

    public ArrayList<Player> getPlayers() throws ExecutionException, InterruptedException {
        ArrayList<Player> list = null;
        String[] paras = new String[1];
        paras[0] = "/player/all";
        Controller controller = new Controller();
        controller.execute(paras);

        PlayerCollectionHandler pch = new PlayerCollectionHandler();
        pch.execute(controller.get());
        list = pch.get();

        return list;
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
        //tsUserdata.add(new Userdata("test", "test", "a"));
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

    public Boolean checkUserData(String username, String password) throws Exception {
        Boolean ret = false;
        Gson g = new Gson();

        String[] paras = new String[1];
        paras[0] = "/player/auth?username=" + username + "&password=" + convertPassMd5(password);
        Controller controller = new Controller();
        controller.execute(paras);
        try {
            String response = controller.get();

            if(response.isEmpty())
            {
                throw new Exception("Wrong Login data");
            }
            else
            {
                PlayerHandler ph = new PlayerHandler();
                ph.execute(response);
                loggedInUser = ph.get();

                ret = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public ArrayList<Player> getFilteredPlayer (String name)
    {

        String currPlayerName = null;
        for(Player player : tsPlayer)
        {
            currPlayerName = player.getName();
            if(currPlayerName.contains(name))
            {
                filteredPlayer.add(player);
            }
        }
        return new ArrayList<>(filteredPlayer);
    }

    public static String convertPassMd5(String pass) {
        String password = null;
        MessageDigest mdEnc;
        try {
            mdEnc = MessageDigest.getInstance("MD5");
            mdEnc.update(pass.getBytes(), 0, pass.length());
            pass = new BigInteger(1, mdEnc.digest()).toString(16);
            while (pass.length() < 32) {
                pass = "0" + pass;
            }
            password = pass;
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        return password;
    }

    public Player getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(Player loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public ArrayList<Game> getFilteredGames (int year, int month, int day)
    {
        String retValues;
        int currGameYear = 0;
        int currGameMonth = 0;
        int currGameDay = 0;
        SimpleDateFormat formatyear = new SimpleDateFormat("yyyy");
        SimpleDateFormat formatmonth = new SimpleDateFormat("MM");
        SimpleDateFormat formatday = new SimpleDateFormat("dd");

        filteredGames = new TreeSet<>();

        for(Game game : tsGame)
        {
            Date currDate = game.getDate();
            currGameYear = Integer.parseInt(formatyear.format(currDate));
            currGameMonth = Integer.parseInt(formatmonth.format(currDate));
            currGameDay = Integer.parseInt(formatday.format(currDate));

            if(year == 0 | year == currGameYear)
            {
                if (month == 0 | month == currGameMonth)
                {
                    if(day == 0 | day == currGameDay)
                    {
                        filteredGames.add(game);
                    }
                }

            }

        }
        return new ArrayList<Game>(filteredGames);
    }

    public int checkData(String data) throws Exception
    {
        int retValue = 0;

        if(!data.equals(""))
        {

            retValue = Integer.parseInt(data);
        }

        return retValue;
    }

}
