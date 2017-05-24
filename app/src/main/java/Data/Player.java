package Data;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by anton on 27.03.2017.
 */

public class Player implements Comparable<Player> {
    private int ID = 0;
    private String name = "";
    private TreeSet<Position> tsPosition = null;
    private int goalDefault = 0;
    private int goalPenalty = 0;
    private int goalHeadSnow = 0;
    private int goalOwn = 0;
    private int nuttmeg = 0;

    public Player()
    {
        super();
        tsPosition = new TreeSet<>();
    }

    public Player(int id, String name, TreeSet<Position> positions)
    {
        super();
        tsPosition = new TreeSet<>();
        setID(id);
        setName(name);
        setTsPositions(positions);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
        return getID() + " | " + getName();
    }

    @Override
    public int compareTo(@NonNull Player o) {
        return this.getID() - o.getID();
    }
}
