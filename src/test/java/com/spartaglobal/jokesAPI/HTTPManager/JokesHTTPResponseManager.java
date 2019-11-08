package com.spartaglobal.jokesAPI.HTTPManager;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class JokesHTTPResponseManager {

    private CloseableHttpResponse jokesResponse;

    public void setFullResponse(CloseableHttpResponse response){
        jokesResponse = response;
    }

    public String getJokeBody(){
        String jokeBody = null;
        try {
            jokeBody = EntityUtils.toString(jokesResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jokeBody;
    }

}
