package com.uta.monkey.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ListenMonkeyMovements implements KeyListener {
	
	private MonkeySubject monkey=null;
	private BananaSubject banana=null;
	
	ListenMonkeyMovements(MonkeySubject monkey,BananaSubject banana){
		this.monkey=monkey;
		this.banana=banana;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (!GameWindow.KEY_EVENTS_DISABLE) {
			if (e.getKeyCode() == 37) {
				// left arrow
				monkey.keyLeft(monkey);
				
			} else if (e.getKeyCode() == 38) {
				// up arrow
				monkey.keyUp(monkey);

			} else if (e.getKeyCode() == 39) {
				// right arrow
				monkey.keyRight(monkey);

			} else if (e.getKeyCode() == 40) {
				// down arrow
				monkey.keyDown(monkey);
			}
			monkey.keyRelease(monkey);
			banana.generateBanana();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
