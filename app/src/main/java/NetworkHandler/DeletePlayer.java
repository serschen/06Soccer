package NetworkHandler;

import android.os.AsyncTask;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
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

public class DeletePlayer extends AsyncTask<Player, Void, String> {
    private String url = Network.getURL() + "/SoccerREST/g3/player/";

    @Override
    protected String doInBackground(Player... params) {
        String ret = null;
        Gson gson = new Gson();
        int id = params[0].getId();

        HttpClient client = new DefaultHttpClient();
        HttpDelete httpDelete = new HttpDelete(url + id);

        try {
            HttpResponse response = client.execute(httpDelete);
            int status = response.getStatusLine().getStatusCode();

            if(status == 500)
            {
                ret = "Something went wrong";
            }
            else if(status == 200)
            {
                ret = "Deleted";
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
