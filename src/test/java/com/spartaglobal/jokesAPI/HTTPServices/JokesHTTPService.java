package com.spartaglobal.jokesAPI.HTTPServices;

import com.spartaglobal.jokesAPI.config.JokesURLConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class JokesHTTPService {

    private CloseableHttpResponse jokesResponse;
    private String jokesJSONString;

    public void executeGetRequest(String whatCategory,String blacklist1){
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        String programmingJokeURL = JokesURLConfig.BASEURL + whatCategory + "?" + JokesURLConfig.BLACKLIST + blacklist1;
        HttpGet httpGet = new HttpGet(programmingJokeURL);

        try {
            jokesResponse = closeableHttpClient.execute(httpGet);
            jokesJSONString = EntityUtils.toString(jokesResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getJokesJSONString(){
        return jokesJSONString;
    }

    public CloseableHttpResponse getFixerResponse() {
        return jokesResponse;
    }

}
