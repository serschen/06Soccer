package Data;

/**
 * Created by anton on 07.06.2017.
 */

public class Stats {
    private int goalDefault = 0;
    private int goalPenalty = 0;
    private int goalHeadSnow = 0;
    private int goalOwn = 0;
    private int nuttmeg = 0;

    public Stats()
    {

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
}
