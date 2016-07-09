package com.uta.monkey.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameFieldPanel extends JPanel {
	 private BufferedImage  img;
	public GameFieldPanel(){
		 try {
			 img=ImageIO.read(GameFieldPanel.class.getClassLoader().getResource("field.jpg"));
		 } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void paintComponent(Graphics g) {
		//logic for setting the background image
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
