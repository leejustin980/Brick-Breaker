package brickbreak;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements KeyListener, ActionListener{
	private boolean play = false;
	private int score = 0;
	private int bricks = 21;
	private Timer timer;
	private int delay = 5;
	
	// Ball
	Ball ball = new Ball();
	// Slider
	Slider slider = new Slider();

	public Game() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		// create timer with a delay
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		// background
		g.setColor(Color.BLACK);
		g.fillRect(1, 1, 700, 600);
		
		// borders
		g.setColor(Color.PINK);
		g.fillRect(0, 0, 10, 600); // left
		g.fillRect(0, 0, 700, 10); // top
		g.fillRect(690, 0, 10, 600); // right
		
		
		// paddle
		g.setColor(Color.BLUE);
		g.fillRect(slider.getPlayerX(), 550, 100, 8);
		
		// ball
		g.setColor(Color.YELLOW);
		g.fillOval(ball.getBallposX(), ball.getBallposY(), 20, 20);
		
		// blocks to break - set apart by 10 px spaces
		// Row 1
		g.setColor(Color.orange);
		g.fillRect(30, 10, 120, 40);
		g.fillRect(160, 10, 120, 40);
		g.fillRect(290, 10, 120, 40);
		g.fillRect(420, 10, 120, 40);
		g.fillRect(550, 10, 120, 40);
		
		//Row 2
		g.setColor(Color.CYAN);
		g.fillRect(30, 60, 120, 40);
		g.fillRect(160, 60, 120, 40);
		g.fillRect(290, 60, 120, 40);
		g.fillRect(420, 60, 120, 40);
		g.fillRect(550, 60, 120, 40);
		
		//Row 3
		g.setColor(Color.RED);
		g.fillRect(30, 110, 120, 40);
		g.fillRect(160, 110, 120, 40);
		g.fillRect(290, 110, 120, 40);
		g.fillRect(420, 110, 120, 40);
		g.fillRect(550, 110, 120, 40);
		
		//Row 4
		g.setColor(Color.WHITE);
		g.fillRect(30, 160, 120, 40);
		g.fillRect(160, 160, 120, 40);
		g.fillRect(290, 160, 120, 40);
		g.fillRect(420, 160, 120, 40);
		g.fillRect(550, 160, 120, 40);
		
		// update game
		update(g);
		
		g.dispose();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// start timer and repaint for each action
		timer.start();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// move right - max border
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (slider.getPlayerX() >= 580) {
				slider.setPlayerX(590);
			} else {
				moveRight();
			}
		}
		// move left - max border
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (slider.getPlayerX() <= 20) {
				slider.setPlayerX(5);;
			} else {
				moveLeft();
			}
		}
		
	}
	
	// move right
	public void moveRight() {
		play = true;
		slider.setPlayerX(slider.getPlayerX() + 20);
	}
	
	// move left
	public void moveLeft() {
		play = true;
		slider.setPlayerX(slider.getPlayerX() - 20);
	}
	
	public void update(Graphics g) {
		if (ball.ballMove(slider)) {
			repaint();
		}
		// if ball hits row 1 - turn it black
		else if (ball.getBallposY() == 160) {
			g.setColor(Color.BLACK);
			g.fillRect(30, 160, 120, 40);
			g.fillRect(160, 160, 120, 40);
			g.fillRect(290, 160, 120, 40);
			g.fillRect(420, 160, 120, 40);
			g.fillRect(550, 160, 120, 40);
			repaint();
		}
		else if (!ball.ballMove(slider)) {
			g.setColor(Color.RED);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
			g.drawString("GAME OVER", 260, 250);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
