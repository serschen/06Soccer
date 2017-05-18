package Data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

/**
 * Created by anton on 27.03.2017.
 */

public class Game implements Comparable<Game>{
    private int id = 0;
    private Date date = null;
    private int goalsShotTeam1 = 0;
    private int goalsShotTeam2 = 0;
    private TreeSet<Player> tsTeamOnePlayer = null;
    private TreeSet<Player> tsTeamTwoPlayer = null;

    public Game()
    {
        Database db = Database.getInstance();
        setId(db.getGameId());
        setDate(new Date());
        setGoalsShotTeam1(0);
        setGoalsShotTeam2(0);
        tsTeamOnePlayer = new TreeSet<>();
        tsTeamTwoPlayer = new TreeSet<>();
    }

    public Game(int id, Date date, int goalsShotTeam1, int goalsShotTeam2) {
        this.id = id;
        this.date = date;
        this.goalsShotTeam1 = goalsShotTeam1;
        this.goalsShotTeam2 = goalsShotTeam2;
        tsTeamOnePlayer = new TreeSet<>();
        tsTeamTwoPlayer = new TreeSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getGoalsShotTeam1() {
        return goalsShotTeam1;
    }

    public void setGoalsShotTeam1(int goalsShotTeam1) {
        this.goalsShotTeam1 = goalsShotTeam1;
    }

    public int getGoalsShotTeam2() {
        return goalsShotTeam2;
    }

    public void setGoalsShotTeam2(int goalsShotTeam2) {
        this.goalsShotTeam2 = goalsShotTeam2;
    }

    public ArrayList<Player> getTsTeamOnePlayer() {
        return new ArrayList<>(tsTeamOnePlayer);
    }

    public void setTsTeamOnePlayer(TreeSet<Player> tsTeamOnePlayer) {
        this.tsTeamOnePlayer = tsTeamOnePlayer;
    }

    public ArrayList<Player> getTsTeamTwoPlayer() {
        return new ArrayList<>(tsTeamTwoPlayer);
    }

    public void setTsTeamTwoPlayer(TreeSet<Player> tsTeamTwoPlayer) {
        this.tsTeamTwoPlayer = tsTeamTwoPlayer;
    }

    public void addPlayerTeamOne(Player p) {
        tsTeamOnePlayer.add(p);
    }

    public void addPlayerTeamTwo(Player p) {
        tsTeamTwoPlayer.add(p);
    }

    public void removePlayerTeamOne(Player p) {
        tsTeamOnePlayer.remove(p);
    }

    public void removePlayerTeamTwo(Player p) {
        tsTeamTwoPlayer.remove(p);
    }

    @Override
    public String toString() {
        return id + " " + date;
    }

    @Override
    public int compareTo(Game o) {
        return this.getId() - o.getId();
    }
}
