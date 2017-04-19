package Data;

import android.support.annotation.NonNull;

import java.util.Date;

/**
 * Created by anton on 27.03.2017.
 */

public class Game implements Comparable<Game>{
    private int id = 0;
    private Date date = null;
    private int goalsShotTeam1 = 0;
    private int goalsShotTeam2 = 0;

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
        goalsShotTeam2 = goalsShotTeam2;
    }

    @Override
    public int compareTo(@NonNull Game o) {
        return this.getDate().compareTo(o.getDate());
    }
}
