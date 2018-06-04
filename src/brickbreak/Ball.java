package brickbreak;

public class Ball {
	// constructor
	public Ball() {
		
	}

	// ball position - x and y axis
	private int ballposX = 120;
	private int ballposY = 350;
	private int balldirX = -1;
	private int balldirY = -2;
	
	// getters and setters
	public int getBallposX() {
		return ballposX;
	}

	public void setBallposX(int ballposX) {
		this.ballposX = ballposX;
	}

	public int getBallposY() {
		return ballposY;
	}

	public void setBallposY(int ballposY) {
		this.ballposY = ballposY;
	}

	public int getBalldirX() {
		return balldirX;
	}

	public void setBalldirX(int balldirX) {
		this.balldirX = balldirX;
	}

	public int getBalldirY() {
		return balldirY;
	}

	public void setBalldirY(int balldirY) {
		this.balldirY = balldirY;
	}
	
	// ball movement
	public boolean ballMove(Slider slider) {
		// left and right boundaries
		if (ballposX >= 670 || ballposX <= 10) {
			balldirX *= -1;
		}
		// top and bottom boundaries
		if ((ballposY >= 530 && (ballposX >= slider.getPlayerX() && ballposX <= slider.getPlayerX()+100)) || ballposY <= 10) {
			balldirY *= -1;
		} else if (ballposY > 530) {
			return false;
		}
		ballposX += balldirX;
		ballposY += balldirY;
		return true;
	}
	
}
