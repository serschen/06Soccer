package Data;

import android.support.annotation.NonNull;

/**
 * Created by anton on 30.03.2017.
 */

public class Statistics implements Comparable<Statistics>{
    private Player player = null;
    private Game game = null;
    private char team = '0';
    private int goulPenalty = 0;
    private int goalHead = 0;
    private int goalHeadSnow = 0;
    private int goalOwn = 0;
    private int nutMeg = 0;

    public Statistics()
    {
        super();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public char getTeam() {
        return team;
    }

    public void setTeam(char team) {
        this.team = team;
    }

    public int getGoulPenalty() {
        return goulPenalty;
    }

    public void setGoulPenalty(int goulPenalty) {
        this.goulPenalty = goulPenalty;
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

    @Override
    public int compareTo(@NonNull Statistics o) {
        return this.getPlayer().compareTo(o.getPlayer());
    }
}
