package NetworkHandler;

import android.os.AsyncTask;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import Data.Player;

/**
 * Created by anton on 06.06.2017.
 */

public class PlayerCollectionHandler extends AsyncTask<String, Void, ArrayList<Player>> {
    @Override
    protected ArrayList<Player> doInBackground(String... params) {
        ArrayList<Player> playerList = null;

        playerList = new GsonBuilder().create().fromJson(params[0], new TypeToken<ArrayList<Player>>() { }.getType());

        return playerList;
    }
}
