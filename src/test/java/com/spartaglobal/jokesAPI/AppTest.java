package com.spartaglobal.jokesAPI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.spartaglobal.jokesAPI.HTTPServices.JokesHTTPService;
import com.spartaglobal.jokesAPI.parsingJSON.JokesDeserialiser;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest 
{
    private static JokesDeserialiser jokes;
    private static JokesHTTPService jokesHTTPService = new JokesHTTPService();

    @BeforeClass
    public static void setup(){
      jokesHTTPService.executeGetRequest("Programming","religious");
      jokes = new JokesDeserialiser(jokesHTTPService.getJokesJSONString());
    }

    @Test
    public void theJokeTest(){
       // System.out.println(jokesHTTPService.getJokesJSONString());
       // System.out.println(jokes.jokesMap.getCategory());
    }

    @Test
    public void testCategory(){
        Assert.assertEquals("Programming",jokes.jokesMap.getCategory());
    }

    @Test
    public void testIfReligious(){
        Assert.assertFalse(jokes.jokesMap.isReligious());
    }

}
