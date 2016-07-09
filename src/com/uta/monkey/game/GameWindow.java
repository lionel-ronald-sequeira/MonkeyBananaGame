package com.uta.monkey.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameWindow extends JFrame {
	
	public static int BANANA_TIMER=5;
	public static int GAME_TIMER=30;
	public static int GAME_SCORE=0;
	public static int GAME_HIGHEST_SCORE=10;
	public static Timer TIMER=new Timer();
	public static TimerTask BANANA_TASK=new BananaTimerTask(TIMER);
	public static boolean KEY_EVENTS_DISABLE=false;
	public static JPanel GAME_HEADER_PANEL=new JPanel();
	public static JLabel BANANA_TIMER_LABEL=new JLabel();
	public static JLabel GAME_TIMER_LABEL=new JLabel();
	public static JLabel GAME_SCORE_LABEL=new JLabel();
	public static JLabel GAME_HIGHEST_SCORE_LABEL=new JLabel();
	public static JButton PLAY_BUTTON=new JButton(); 
	public static JPanel GAME_FIELD_PANEL=new GameFieldPanel(); 
	public static ImageIcon BANANA_ICON=new ImageIcon(GameWindow.class.getClassLoader().getResource("banana.jpg"));
	public static JLabel BANANA_LABEL=new JLabel(BANANA_ICON);
	public static ImageIcon MONKEY_ICON=new ImageIcon(GameWindow.class.getClassLoader().getResource("monkey.jpg"));
	public static JLabel MONKEY_LABEL=new JLabel(MONKEY_ICON);
	public static ImageIcon BACKGROUND_ICON=new ImageIcon(GameWindow.class.getClassLoader().getResource("field.jpg"));
	public static JLabel BACKGROUND_LABEL=new JLabel(MONKEY_ICON);
	
	public GameWindow(){
		this.setSize(600,650);
		//initialization of window
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim=tk.getScreenSize();
		int xPos=(dim.width/2)-(this.getWidth()/2);
		int yPos=(dim.height/2)-(this.getHeight()/2);
		this.setLocation(xPos, yPos);
		this.setTitle("Monkey Banana Game");
		this.setLayout(null);
		
		GAME_HEADER_PANEL.setSize(600, 50);
		GAME_HEADER_PANEL.setLocation(0, 0);
		GAME_HEADER_PANEL.setBackground(Color.GRAY);
		GAME_HEADER_PANEL.setLayout(new FlowLayout(0,15,15));
		
		GAME_FIELD_PANEL.setSize(600, 600);
		GAME_FIELD_PANEL.setLocation(0, 50);
		GAME_FIELD_PANEL.setBackground(Color.GREEN);
		GAME_FIELD_PANEL.setLayout(null);
	    
	    BANANA_TIMER_LABEL.setSize(30, 30);
	    BANANA_TIMER_LABEL.setText("Banana Timer : "+String.valueOf(GameWindow.BANANA_TIMER));
	    GAME_HEADER_PANEL.add(BANANA_TIMER_LABEL);
	    
	    GAME_TIMER_LABEL.setSize(30, 30);
	    GAME_TIMER_LABEL.setText("Game Timer : "+String.valueOf(GameWindow.GAME_TIMER));
	    GAME_HEADER_PANEL.add(GAME_TIMER_LABEL);
	    
	    GAME_SCORE_LABEL.setSize(30,30);
	    GAME_SCORE_LABEL.setText("Bananas Eaten : "+String.valueOf(GameWindow.GAME_SCORE));
	    GAME_HEADER_PANEL.add(GAME_SCORE_LABEL);
	    
	    GAME_HIGHEST_SCORE_LABEL.setSize(30,30);
	    GAME_HIGHEST_SCORE_LABEL.setText("Highest Bananas Eaten : "+String.valueOf(GameWindow.GAME_HIGHEST_SCORE));
	    GAME_HEADER_PANEL.add(GAME_HIGHEST_SCORE_LABEL);
	    
	    PLAY_BUTTON.setText("Restart");
	    PLAY_BUTTON.setSize(30, 30);
	    PLAY_BUTTON.setVisible(false);
	    ActionListener replayGame=new ReplayGameListener();
	    PLAY_BUTTON.addActionListener(replayGame);
	    
	    GAME_HEADER_PANEL.add(PLAY_BUTTON);
	   
	    MONKEY_LABEL.setSize(30, 30);
	    MONKEY_LABEL.setLocation(RandomNumberGeneratorUtil.generateRandomNumber(),RandomNumberGeneratorUtil.generateRandomNumber());
	    
	    BANANA_LABEL.setSize(30, 30);
	    BANANA_LABEL.setLocation(RandomNumberGeneratorUtil.generateRandomNumber(),
	    		RandomNumberGeneratorUtil.generateRandomNumber());
	    
	    GAME_FIELD_PANEL.add(MONKEY_LABEL);
	    GAME_FIELD_PANEL.add(BANANA_LABEL);
	    
	    MonkeySubject monkeySubject=new MonkeySubject(MONKEY_LABEL);
	    BananaSubject bananaSubject=new BananaSubject(MONKEY_LABEL,BANANA_LABEL);
	    ListenMonkeyMovements listenKeyEvents=new ListenMonkeyMovements(monkeySubject,bananaSubject);
	    GAME_FIELD_PANEL.addKeyListener(listenKeyEvents);
	    GAME_FIELD_PANEL.setFocusable(true);
	    GAME_FIELD_PANEL.requestFocus();
	    this.add(GAME_HEADER_PANEL);
	    this.add(GAME_FIELD_PANEL);
	    this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		TIMER.scheduleAtFixedRate(BANANA_TASK, 0, 1000);
	}

}
