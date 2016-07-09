package com.uta.monkey.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Timer;

public class ReplayGameListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//logic when restart button is clicked.
		
		 GameWindow.PLAY_BUTTON.setVisible(false);
		 GameWindow.GAME_SCORE=0;
		 GameWindow.GAME_SCORE_LABEL.setText("Bananas Eaten : "+String.valueOf(GameWindow.GAME_SCORE));
		 MonkeySubject monkeySubject=new MonkeySubject(GameWindow.MONKEY_LABEL);
		 BananaSubject bananaSubject=new BananaSubject(GameWindow.MONKEY_LABEL,GameWindow.BANANA_LABEL);
		 KeyListener listeners[]=GameWindow.GAME_FIELD_PANEL.getKeyListeners();
		 GameWindow.GAME_FIELD_PANEL.removeKeyListener(listeners[0]);
		 GameWindow.GAME_FIELD_PANEL.setFocusable(true);
		 GameWindow.GAME_FIELD_PANEL.requestFocus();
		 ListenMonkeyMovements listenKeyEvents=new ListenMonkeyMovements(monkeySubject,bananaSubject);
		 GameWindow.GAME_FIELD_PANEL.addKeyListener(listenKeyEvents);
		 GameWindow.KEY_EVENTS_DISABLE=false;
		 GameWindow.TIMER=new Timer();
		 GameWindow.BANANA_TASK=new BananaTimerTask(GameWindow.TIMER);
		 GameWindow.TIMER.scheduleAtFixedRate(GameWindow.BANANA_TASK, 0, 1000);
		
	}
		
}
