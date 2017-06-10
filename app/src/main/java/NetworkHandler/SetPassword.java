package NetworkHandler;

import android.os.AsyncTask;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import Data.Player;

/**
 * Created by anton on 06.06.2017.
 */

public class SetPassword extends AsyncTask<Player, Void, String> {
    private String url = Network.getURL() + "/SoccerREST/g3/player/password/"; //{pid}?password={password}

    @Override
    protected String doInBackground(Player... params) {
        String ret = null;
        HttpClient client = new DefaultHttpClient();
        url += params[0].getId() + "?password=" + params[0].getPassword();
        HttpPut httpPut = new HttpPut(url);
        System.out.println(url);

        try {
            HttpResponse r = client.execute(httpPut);
            ret = r.getStatusLine().toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }
}
