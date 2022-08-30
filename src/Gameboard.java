import java.awt.Color;
import java.awt.Graphics;

public class Gameboard {
	private static int[][] board = new int[3][3];

	public Gameboard() {

	}

	public int[][] getBoard() {
		return board;
	}

	public void renderBoard(Graphics graphics, Player currentPlayer) {
		for (int xx = 0; xx < board.length; xx++) {
			for (int yy = 0; yy < board.length; yy++) {
				graphics.setColor(Color.BLACK);

				graphics.drawRect(xx * Game.IMAGESCALE, yy * Game.IMAGESCALE, Game.IMAGESCALE, Game.IMAGESCALE);

				if (board[xx][yy] == currentPlayer.getCurrentPlayer()) {
					graphics.drawImage(currentPlayer.getSprite(), xx * Game.IMAGESCALE, yy * Game.IMAGESCALE, null);
				}
			}
		}
	}

	public static void resetBoard() {
		for (int xx = 0; xx < board.length; xx++) {
			for (int yy = 0; yy < board.length; yy++) {
				board[xx][yy] = 0;
			}
		}
	}
}
