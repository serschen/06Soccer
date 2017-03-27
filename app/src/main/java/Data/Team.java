package Data;

import android.support.annotation.NonNull;

import java.util.TreeSet;

/**
 * Created by anton on 27.03.2017.
 */

public class Team implements Comparable<Team> {
    private int id = 0;
    private TreeSet<Spieler> tsSpieler = null;


    public Team()
    {
        super();
        tsSpieler = new TreeSet<>();
    }

    public Team(int id)
    {
        setId(id);
        tsSpieler = new TreeSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TreeSet<Spieler> getTsSpieler() {
        return tsSpieler;
    }

    public void setTsSpieler(TreeSet<Spieler> tsSpieler) {
        this.tsSpieler = tsSpieler;
    }

    public void addSpieler(Spieler s)
    {
        tsSpieler.add(s);
    }

    public void removeSpieler(Spieler s)
    {
        tsSpieler.remove(s);
    }

    @Override
    public int compareTo(@NonNull Team o) {
        return this.getId() - o.getId();
    }
}
