package Data;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by anton on 27.03.2017.
 */

public class Player implements Comparable<Player> {

    private Integer id = 0;
    private String name = "";
    private String username = "";
    //@SerializedName("positions")
    private TreeSet<Position> tsPosition = null;
    private ArrayList<Position> positions = null;
    private Integer numWins = 0;
    private Integer numDefeats = 0;
    private Integer numDraws = 0;
    private Float goalDifference = (float) 0.0;
    private Boolean admin = false;
    private int goalDefault = 0;
    private int goalPenalty = 0;
    private int goalHeadSnow = 0;
    private int goalOwn = 0;
    private int nuttmeg = 0;
    private String password = null;

    public Player()
    {
        super();
        tsPosition = new TreeSet<>();
    }

    public Player(int id, String name, TreeSet<Position> positions)
    {
        super();
        tsPosition = new TreeSet<>();
        setId(id);
        setName(name);
        setTsPositions(positions);
    }

    public Player(int id, String name, String username, TreeSet<Position> positions, int numWins, int numDefeats, int numDraws, float goalDifference, Boolean admin)
    {
        super();

        setId(id);
        setName(name);
        setUsername(username);
        setTsPositions(positions);
        setNumWins(numWins);
        setNumDefeats(numDefeats);
        setNumDraws(numDraws);
        setGoalDifference(goalDifference);
        setAdmin(admin);
    }

    public Player(ArrayList<Position> positions, String name, String username, Boolean admin)
    {
        this.positions = positions;
        setName(name);
        setUsername(username);
        setAdmin(admin);
    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeSet<Position> getTsPositions() {
        return tsPosition;
    }

    public void setTsPositions(TreeSet<Position> tsPosition) {
        this.tsPosition = tsPosition;
    }

    public String getPositionString() {
        String positions = null;

        for (Position pos : tsPosition)
        {
            positions = positions + "," + pos.toString();
        }
        return positions;
    }

    public ArrayList<Position> getPositions() {
        return new ArrayList<>(tsPosition);
    }

    public void addPosition(Position position)
    {
        if(tsPosition.contains(position) == false)
        {
            tsPosition.add(position);
        }
    }

    public void removePosition(Position position)
    {
        if(tsPosition.contains(position) == true)
        {
            tsPosition.remove(position);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TreeSet<Position> getTsPosition() {
        return tsPosition;
    }

    public void setTsPosition(TreeSet<Position> tsPosition) {
        this.tsPosition = tsPosition;
    }

    public int getNumWins() {
        return numWins;
    }

    public void setNumWins(int numWins) {
        this.numWins = numWins;
    }

    public int getNumDefeats() {
        return numDefeats;
    }

    public void setNumDefeats(int numDefeats) {
        this.numDefeats = numDefeats;
    }

    public int getNumDraws() {
        return numDraws;
    }

    public void setNumDraws(int numDraws) {
        this.numDraws = numDraws;
    }

    public float getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(float goalDifference) {
        this.goalDifference = goalDifference;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public int getGoalDefault() {
        return goalDefault;
    }

    public void setGoalDefault(int goalDefault) {
        this.goalDefault = goalDefault;
    }

    public int getGoalPenalty() {
        return goalPenalty;
    }

    public void setGoalPenalty(int goalPenalty) {
        this.goalPenalty = goalPenalty;
    }

    public int getGoalHeadSnow() {
        return goalHeadSnow;
    }

    public void setGoalHeadSnow(int goalHeadSnow) {
        this.goalHeadSnow = goalHeadSnow;
    }

    public int getGoalOwn() {
        return goalOwn;
    }

    public void setGoalOwn(int goalOwn) {
        this.goalOwn = goalOwn;
    }

    public int getNuttmeg() {
        return nuttmeg;
    }

    public void setNuttmeg(int nuttmeg) {
        this.nuttmeg = nuttmeg;
    }

    public String toString()
    {
        return getId() + " | " + getName();
    }

    @Override
    public int compareTo(@NonNull Player o) {
        return this.getId() - o.getId();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
