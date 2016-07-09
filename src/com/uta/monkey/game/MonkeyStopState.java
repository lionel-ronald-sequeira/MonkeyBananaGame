package com.uta.monkey.game;
/*
 * @author lionel
 *	This class conatains methods which represent events that cause the subject 
 *	to move from stop state to move state.
 */

public class MonkeyStopState extends MonkeyState{

	@Override
	public MonkeyState keyLeft(MonkeySubject monkey) {
		int x = monkey.getMonkey().getX();
		monkey.getMonkey().setLocation(x - 30 <= -10 ? x : x - 30, monkey.getMonkey().getY());
		return new MonkeyMoveState();
	}

	@Override
	public MonkeyState keyRight(MonkeySubject monkey) {
		int x =monkey.getMonkey().getX();
		monkey.getMonkey().setLocation(x + 30 >= 600 ? x : x + 30, monkey.getMonkey().getY());
		return new MonkeyMoveState();
	}

	@Override
	public MonkeyState keyUp(MonkeySubject monkey) {
		int x = monkey.getMonkey().getY();
		monkey.getMonkey().setLocation(monkey.getMonkey().getX(), x - 30 <= -10 ? x : x - 30);
		return new MonkeyMoveState();
	}

	@Override
	public MonkeyState keyDown(MonkeySubject monkey) {
		int x = monkey.getMonkey().getY();
		monkey.getMonkey().setLocation(monkey.getMonkey().getX(), x + 30 >= 570 ? x : x + 30);
		return new MonkeyMoveState();
	}
}
