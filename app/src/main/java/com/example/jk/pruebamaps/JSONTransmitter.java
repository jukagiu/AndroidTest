package com.example.jk.pruebamaps;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONObject;

/**
 * Created by JK on 13/08/2017.
 */

public class JSONTransmitter extends AsyncTask<JSONObject, JSONObject, Boolean> {
    String url = "http://192.168.43.113/servicioweb/";
    @Override
    protected Boolean doInBackground(JSONObject... data) {
        JSONObject json = data[0];
        HttpClient client = new DefaultHttpClient();
        HttpConnectionParams.setConnectionTimeout(client.getParams(), 100000);
        JSONObject jsonResponse = null;
        HttpPost post = new HttpPost(url);
        try {
            StringEntity se = new StringEntity(json.toString());
            post.addHeader("Content-type", "application/json");
            post.setEntity(se);
            HttpResponse response;
            response = client.execute(post);
            String resFromServer = org.apache.http.util.EntityUtils.toString(response.getEntity());
            jsonResponse=new JSONObject(resFromServer);
            Log.i("Response from server", jsonResponse.getString("msg"));
            return jsonResponse.getBoolean("msg");
        } catch (Exception e) { e.printStackTrace();}
        return false;
    }

}
