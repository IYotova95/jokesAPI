package com.spartaglobal.jokesAPI.parsingJSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JokesDeserialiser {

       public JokesDTO jokesMap;

       public JokesDeserialiser(String jsonString){
           ObjectMapper objectMapper = new ObjectMapper();

           try {
               jokesMap = objectMapper.readValue(jsonString,JokesDTO.class);
           } catch (IOException e) {
               e.printStackTrace();
           }

       }
}
