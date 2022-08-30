import java.awt.Color;
import java.awt.Graphics;

public class Menu {
	public static final String RULES = "Rules: Player 1 is X, Player 2 is O. Player 1 goes first. Click on the square you want to place your piece in. The first player to get 3 in a row wins.";

	public void render(Graphics graphics) {
		graphics.setColor(Color.BLACK);

		graphics.fillRect(0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);
	}
}
