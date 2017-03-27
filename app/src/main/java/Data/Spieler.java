package Data;

import android.support.annotation.NonNull;

import java.util.TreeSet;

/**
 * Created by anton on 27.03.2017.
 */

public class Spieler implements Comparable<Spieler> {
    private int ID = 0;
    private String name = "";
    private TreeSet<Position> tsPosition = null;
    private int goalDefault = 0;
    private int goalPenalty = 0;
    private int goalHead = 0;
    private int goalHeadSnow = 0;
    private int goalOwn = 0;
    private int nutMeg = 0;

    public Spieler()
    {
        super();
        tsPosition = new TreeSet<>();
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

    public int getGoalHead() {
        return goalHead;
    }

    public void setGoalHead(int goalHead) {
        this.goalHead = goalHead;
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

    public int getNutMeg() {
        return nutMeg;
    }

    public void setNutMeg(int nutMeg) {
        this.nutMeg = nutMeg;
    }

    public void calculateGoalDefault()
    {

    }

    public TreeSet<Position> getTsPosition() {
        return tsPosition;
    }

    public void setTsPosition(TreeSet<Position> tsPosition) {
        this.tsPosition = tsPosition;
    }

    @Override
    public int compareTo(@NonNull Spieler o) {
        return this.getName().compareTo(o.getName());
    }
}
