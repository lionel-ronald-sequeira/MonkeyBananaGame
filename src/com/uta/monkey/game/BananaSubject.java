package com.uta.monkey.game;


import javax.swing.JLabel;

public class BananaSubject {
	
	private JLabel monkeyLabel=null;
	private JLabel bananaLabel=null;
	
	BananaSubject(JLabel monkeyLabel,JLabel bananaLabel){
		this.monkeyLabel=monkeyLabel;
		this.bananaLabel=bananaLabel;
	}
	
	public   void generateBanana() {
		if (Math.abs(bananaLabel.getX() - monkeyLabel.getX()) < 5
				&& Math.abs(bananaLabel.getY() - monkeyLabel.getY()) < 5) {
			bananaLabel.setLocation(RandomNumberGeneratorUtil.generateRandomNumber(),
					RandomNumberGeneratorUtil.generateRandomNumber());
			GameWindow.BANANA_TIMER = 5;
			GameWindow.GAME_SCORE_LABEL.setText("Bananas Eaten: "+String.valueOf(GameWindow.GAME_SCORE=GameWindow.GAME_SCORE+1));
		}
	}
}
