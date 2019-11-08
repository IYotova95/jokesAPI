package com.spartaglobal.jokesAPI.parsingJSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.jokesAPI.HTTPManager.JokesHTTPCallManager;
import com.spartaglobal.jokesAPI.HTTPManager.JokesHTTPResponseManager;

import java.io.IOException;

public class JokesService {

     //  public JokesDTO jokesMap;
       private JokesHTTPCallManager jokesHTTPCallManager;
       private JokesHTTPResponseManager jokesHTTPResponseManager;
       private ObjectMapper objectMapper;

    public JokesService() {
        jokesHTTPCallManager = new JokesHTTPCallManager();
        jokesHTTPResponseManager = new JokesHTTPResponseManager();
        objectMapper = new ObjectMapper();
    }

    public void executeJokeCall(String category, String blacklist1){
        jokesHTTPResponseManager.setFullResponse(jokesHTTPCallManager.executeGetRequest(category,blacklist1));
    }

    public JokesDTO getParsedJASONResponse(){
           JokesDTO parsedResponse = null;
           try {
               parsedResponse = objectMapper.readValue(jokesHTTPResponseManager.getJokeBody(),JokesDTO.class);
           } catch (IOException e) {
               e.printStackTrace();
           }
        return parsedResponse;
       }
}
