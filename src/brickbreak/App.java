package brickbreak;

import javax.swing.JFrame;

public class App {
	
	public static void main(String[] args) {
		// create a JFrame
		JFrame frame  = new JFrame();
		Game game = new Game();
		// size of frame
		frame.setBounds(10, 10, 700, 600);
		// title
		frame.setTitle("Brick Breaker");
		
		// start the game
		frame.add(game);
		
		// basic functions
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
