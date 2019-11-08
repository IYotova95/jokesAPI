package com.spartaglobal.jokesAPI.HTTPManager;

import com.spartaglobal.jokesAPI.config.JokesURLConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class JokesHTTPCallManager {

    public CloseableHttpResponse executeGetRequest(String whatCategory,String blacklist1){
       CloseableHttpResponse jokesGetResponse = null;
       CloseableHttpClient httpClient = HttpClients.createDefault();
       HttpGet getJoke = new HttpGet(JokesURLConfig.BASEURL+whatCategory + "?" +JokesURLConfig.BLACKLIST + blacklist1);
        try {
           jokesGetResponse = httpClient.execute(getJoke);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jokesGetResponse;
    }
}
