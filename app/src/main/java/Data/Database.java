package Data;

import java.util.TreeSet;

/**
 * Created by anton on 27.03.2017.
 */

public class Database {
    private static Database reference = null;
    TreeSet<Spieler> tsSpieler = null;

    public Database()
    {
        super();
        tsSpieler = new TreeSet<>();
    }

    public Database getInstance()
    {
        if(reference == null)
        {
            reference = new Database();
        }

        return reference;
    }


}
