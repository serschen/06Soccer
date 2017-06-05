package Data;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by anton on 15.05.2017.
 */

public class Userdata implements Comparable<Userdata>{
    private int id = 0;
    private String name = "";
    private String username = "";
    private ArrayList<String> positions = null;
    private int numWins = 0;
    private int numDefeats = 0;
    private int numDraws = 0;
    private float goalDifference = (float) 0.0;
    private Boolean admin = false;

    public Userdata()
    {
        super();
    }


    //{"id":11,"name":"Test","username":"test","positions":[],"numWins":0,"numDefeats":0,"numDraws":0,"goalDifference":0.0,"admin":true}
    public Userdata(int id, String name, String username, ArrayList<String> positions, int numWins, int numDefeats, int numDraws, float goalDifference, Boolean admin)
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

    public String toString()
    {
        return getId() + " | " + getName();
    }

    public ArrayList<String> getPosition() {
        return positions;
    }

    public void setPositions(ArrayList<String> position) {
        this.positions = position;
    }

    @Override
    public int compareTo(@NonNull Userdata o) {
        return this.getId() - o.getId();
    }
}
