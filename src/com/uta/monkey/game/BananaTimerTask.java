package com.uta.monkey.game;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BananaTimerTask extends TimerTask {
	private Timer timer=null;
	private JFrame gameWindow=null; 
	
	
	BananaTimerTask(Timer timer){
		this.timer=timer;
		this.gameWindow=gameWindow;
	}
	
	@Override
	public void run() {
		if(GameWindow.GAME_TIMER==0){
			GameWindow.BANANA_TIMER=5;
			GameWindow.GAME_TIMER=30;
			GameWindow.KEY_EVENTS_DISABLE=true;
			GameWindow.PLAY_BUTTON.setVisible(true);
			if(GameWindow.GAME_SCORE >= GameWindow.GAME_HIGHEST_SCORE){
				GameWindow.GAME_HIGHEST_SCORE=GameWindow.GAME_SCORE;
				GameWindow.GAME_HIGHEST_SCORE_LABEL.setText("Highest Score : "+String.valueOf(GameWindow.GAME_HIGHEST_SCORE));
				JOptionPane.showMessageDialog(gameWindow, "Congratulations you won.");
			}else{
				JOptionPane.showMessageDialog(gameWindow, "Sorry you loose.");
			}
			GameWindow.TIMER.cancel();
		}
		if (GameWindow.BANANA_TIMER == 0) {
			GameWindow.BANANA_LABEL.setLocation(RandomNumberGeneratorUtil.generateRandomNumber(),
					RandomNumberGeneratorUtil.generateRandomNumber());
			GameWindow.BANANA_TIMER = 5;
		}
		GameWindow.GAME_TIMER_LABEL.setText("Game Timer: "+String.valueOf(GameWindow.GAME_TIMER--));
		GameWindow.BANANA_TIMER_LABEL.setText("Banana Timer: "+String.valueOf(GameWindow.BANANA_TIMER--));
		
	}
}
