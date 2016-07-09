package com.uta.monkey.game;

import java.util.Random;

public class RandomNumberGeneratorUtil {
	public static int generateRandomNumber(){
		//logic to generate random number
		Random r = new Random();
		return (r.nextInt((17 - 1) + 1) + 1)*30;
	}
}
