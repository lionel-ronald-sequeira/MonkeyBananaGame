package com.uta.monkey.game;

import javax.swing.JLabel;

public class MonkeySubject {
	
	private MonkeyState monkeyState=null;
	private JLabel monkeyImg=null;
	
	public MonkeyState getState() {
		return monkeyState;
	}

	public void setState(MonkeyState monkeyState) {
		this.monkeyState = monkeyState;
	}

	public JLabel getMonkey() {
		return monkeyImg;
	}

	public void setMonkey(JLabel monkeyImg) {
		this.monkeyImg = monkeyImg;
	}

	MonkeySubject(JLabel monkeyImg){
		this.monkeyImg=monkeyImg;
		this.monkeyImg.setLocation(30, 30);
	    this.monkeyImg.setLocation(0, 0);
	    this.monkeyState=new MonkeyStopState();
	}
	
	public  void keyLeft(MonkeySubject monkey){
		monkeyState=monkeyState.keyLeft(monkey);
		
	}
	
	public  void keyRight(MonkeySubject monkey){
		monkeyState=monkeyState.keyRight(monkey);
		
	}
	
	public  void keyUp(MonkeySubject monkey){
		monkeyState=monkeyState.keyUp(monkey);
		
	}
	
	public void keyDown(MonkeySubject monkey){
		monkeyState=monkeyState.keyDown(monkey);
		
	}
	
	public void keyRelease(MonkeySubject monkey){
		monkeyState=monkeyState.keyRelease(monkey);
	}

}
