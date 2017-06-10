package NetworkHandler;

import android.os.AsyncTask;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import Data.Player;

/**
 * Created by anton on 10.06.2017.
 */

public class UpdatePlayer extends AsyncTask<Player, Void, String>{
    String url = Network.getURL() + "/SoccerREST/g3/player/"; //{pid}


    @Override
    protected String doInBackground(Player... params) {
        StringBuilder ret = new StringBuilder();
        Gson gson = new Gson();
        url += params[0].getId();
        System.out.println(url);
        HttpClient client = new DefaultHttpClient();
        HttpPut httpPut = new HttpPut(url);
        httpPut.setHeader("Content-type", "application/json");
        String json = gson.toJson(params[0]);
        System.out.println(json);

        try {
            httpPut.setEntity(new StringEntity(json, "UTF8"));
            HttpResponse r = client.execute(httpPut);

            if(r.getStatusLine().getStatusCode() == 200)
            {
                ret.append(params[0].getName() + " updated");
            }
            else
            {
                ret.append(r.getStatusLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret.toString();
    }
}
