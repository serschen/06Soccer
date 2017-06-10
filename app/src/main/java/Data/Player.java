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
    private ArrayList<Position> positions = null;
    private Integer numWins = 0;
    private Integer numDefeats = 0;
    private Integer numDraws = 0;
    private String password = null;
    private Float goalDifference = (float) 0.0;
    private Boolean admin = false;
    private Stats stats = new Stats();

    public Player()
    {
        super();
        positions = new ArrayList<>();
    }

    public Player(int id, String name, ArrayList<Position> positions)
    {
        super();
        positions = new ArrayList<>();
        setId(id);
        setName(name);
        setPositions(positions);
    }

    public Player(int id, String name, String username, ArrayList<Position> positions, int numWins, int numDefeats, int numDraws, float goalDifference, Boolean admin)
    {
        super();

        setId(id);
        setName(name);
        setUsername(username);
        setPositions(positions);
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

    public void setPositions(ArrayList<Position> positions) {
        this.positions = positions;
    }

    public String getPositionString() {
        TreeSet<Position> tsPosition = new TreeSet<>(positions);
        String positions = null;

        for (Position pos : tsPosition)
        {
            positions = positions + "," + pos.toString();
        }
        return positions;
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public void addPosition(Position position)
    {
        if(!positions.contains(position))
        {
            positions.add(position);
        }
    }

    public void removePosition(Position position)
    {
        if(positions.contains(position))
        {
            positions.remove(position);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Float getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(Float goalDifference) {
        this.goalDifference = goalDifference;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public int getGoalDefault() {
        return stats.getGoalDefault();
    }

    public void setGoalDefault(int goalDefault) {
        stats.setGoalDefault(goalDefault);
    }

    public int getGoalPenalty() {
        return stats.getGoalPenalty();
    }

    public void setGoalPenalty(int goalPenalty) {
        stats.setGoalPenalty(goalPenalty);
    }

    public int getGoalHeadSnow() {
        return stats.getGoalHeadSnow();
    }

    public void setGoalHeadSnow(int goalHeadSnow) {
        stats.setGoalHeadSnow(goalHeadSnow);
    }

    public int getGoalOwn() {
        return stats.getGoalOwn();
    }

    public void setGoalOwn(int goalOwn) {
        stats.setGoalOwn(goalOwn);
    }

    public int getNuttmeg() {
        return stats.getNuttmeg();
    }

    public void setNuttmeg(int nuttmeg) {
        stats.setNuttmeg(nuttmeg);
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
