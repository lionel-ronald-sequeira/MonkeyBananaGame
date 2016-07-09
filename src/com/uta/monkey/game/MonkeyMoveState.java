package com.uta.monkey.game;

public class MonkeyMoveState extends MonkeyState {
	@Override
	public MonkeyState keyRelease(MonkeySubject monkey) {
		
		return new MonkeyStopState();
	}
}
