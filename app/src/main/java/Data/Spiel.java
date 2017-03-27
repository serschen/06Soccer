package Data;

import android.support.annotation.NonNull;

import java.util.Date;

/**
 * Created by anton on 27.03.2017.
 */

public class Spiel implements Comparable<Spiel>{
    private int id = 0;
    private Date date = null;
    private Team team1 = null;
    private Team team2 = null;
    private int goalsShotTeam1 = 0;
    private int goalsShotTeam2 = 0;

    public Spiel()
    {
        super();
    }

    public Spiel(int id)
    {
        setId(id);
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

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    @Override
    public int compareTo(@NonNull Spiel o) {
        return this.getDate().compareTo(o.getDate());
    }
}
