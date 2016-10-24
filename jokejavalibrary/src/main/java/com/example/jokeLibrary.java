package com.example;

import java.util.Random;

public class jokeLibrary {

    public static String[] jokesArray = {"Did you hear about the guy who got hit in the head with a can of soda? He was lucky it was a soft drink.",
            "I find it ironic that the colors red, white, and blue stand for freedom until they are flashing behind you.",
            "I can't believe I got fired from the calendar factory. All I did was take a day off.",
            "Why was Cinderella thrown off the basketball team? She ran away from the ball.",
            "I'm glad I know sign language, it's pretty handy.",
            "I'm emotionally constipated. I haven't given a shit in days."

    };

    public String tellAHandCraftedJoke(){
        Random generator = new Random();
        int randomIndex = generator.nextInt(jokesArray.length);
        return jokesArray[randomIndex];
    }

}

