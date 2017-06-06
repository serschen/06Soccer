package NetworkHandler;

import android.os.AsyncTask;

import com.google.gson.Gson;

import Data.Player;

/**
 * Created by anton on 05.06.2017.
 */

public class PlayerHandler extends AsyncTask<String, Void, Player> {


    @Override
    protected Player doInBackground(String... params) {
        Player player = null;

        player = new Gson().fromJson(params[0], Player.class);

        return player;
    }
}