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

    public Player()
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

    public TreeSet<Position> getTsPositions() {
        return tsPosition;
    }

    public void setTsPositions(TreeSet<Position> tsPosition) {
        this.tsPosition = tsPosition;
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

    @Override
    public int compareTo(@NonNull Player o) {
        return this.getName().compareTo(o.getName());
    }
}
