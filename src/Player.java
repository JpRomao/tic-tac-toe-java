import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	public static final int PLAYER_1 = 1;
	public static final int PLAYER_2 = 2;

	private int currentPlayer;
	private int playerScore;

	private BufferedImage oSprite;
	private BufferedImage xSprite;

	public Player(int player) {
		if (player == PLAYER_1 || player == PLAYER_2) {
			currentPlayer = player;
		} else {
			currentPlayer = PLAYER_1;
		}

		playerScore = 0;

		try {
			oSprite = ImageIO.read(getClass().getResource("/o.png"));
			xSprite = ImageIO.read(getClass().getResource("/x.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public BufferedImage getSprite() {
		if (currentPlayer == PLAYER_1) {
			return xSprite;
		} else {
			return oSprite;
		}
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
}
