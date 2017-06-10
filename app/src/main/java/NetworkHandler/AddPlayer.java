package NetworkHandler;

import android.os.AsyncTask;

import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import Data.Player;

/**
 * Created by anton on 06.06.2017.
 */

public class AddPlayer extends AsyncTask<Player, Void, String> {
    private String url = Network.getURL() + "/SoccerREST/g3/player";

    @Override
    protected String doInBackground(Player... params) {
        String ret = null;
        Gson gson = new Gson();
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-type", "application/json");
        String json = gson.toJson(params[0]);

        try {
            httpPost.setEntity(new StringEntity(json, "UTF8"));
            HttpResponse r = client.execute(httpPost);
            System.out.println(r.getStatusLine());
            System.out.println(url);
            System.out.println(json);

            if(r.getStatusLine().getStatusCode() == 200)
            {
                ret = params[0].getName() + " added";
            }
            else
            {
                ret = r.getStatusLine().toString();
            }
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
