package com.spartaglobal.jokesAPI;

import com.spartaglobal.jokesAPI.parsingJSON.JokesService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest 
{
    private static JokesService jokesService;

    @BeforeClass
    public static void setup(){
        jokesService = new JokesService();
        jokesService.executeJokeCall("Programming","religious");

    }



    @Test
    public void testCategory(){
        Assert.assertEquals("Programming",jokesService.getParsedJASONResponse().getCategory());
    }

    @Test
    public void testIfReligious(){
        Assert.assertFalse(jokesService.getParsedJASONResponse().isReligious());
    }

}
