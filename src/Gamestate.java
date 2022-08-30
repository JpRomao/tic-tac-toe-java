public class Gamestate {
	public static final int SINGLEPLAYER = 0;
	public static final int MULTIPLAYER = 1;
	public static final int SEERULES = 2;
	public static final int MENU = 3;

	private int selectedGamestate;

	public Gamestate(int selectedGamestate) {
		if (selectedGamestate == SINGLEPLAYER || selectedGamestate == MULTIPLAYER || selectedGamestate == SEERULES
				|| selectedGamestate == MENU) {
			this.selectedGamestate = selectedGamestate;
		} else {
			this.selectedGamestate = MENU;
		}
	}

	public int getGamemode() {
		return selectedGamestate;
	}

	public void setGamemode(int selectedGamestate) {
		this.selectedGamestate = selectedGamestate;
	}
}
