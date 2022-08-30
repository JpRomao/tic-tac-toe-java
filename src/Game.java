import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Game extends Canvas implements Runnable, KeyListener, MouseListener {
    public static final String TITLE = "Tic Tac Toe";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 400;
    public static final int SCALE = 1;
    public static final int IMAGESCALE = 120;

    public static final int FPS = 60;

    private boolean pressed = false;

    private int mouseX;
    private int mouseY;

    private static Player currentPlayer;

    private static Gameboard board;

    private static Gamestate gamestate;

    public Game() {
        this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        this.addKeyListener(this);
        this.addMouseListener(this);
    }

    public static void main(String[] args) throws Exception {
        gamestate = new Gamestate(Gamestate.MENU);

        Game game = new Game();

        JFrame frame = new JFrame(TITLE);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.pack();
        frame.setVisible(true);

        new Thread(game).start();
    }

    public void update() {

    }

    public void render() {
        try {
            BufferStrategy bs = this.getBufferStrategy();

            if (bs == null) {
                this.createBufferStrategy(3);

                return;
            }

            Graphics graphics = bs.getDrawGraphics();

            if (gamestate.getGamemode() == Gamestate.MENU) {
                Menu menu = new Menu();

                menu.render(graphics);
            } else if (gamestate.getGamemode() == Gamestate.SINGLEPLAYER
                    || gamestate.getGamemode() == Gamestate.MULTIPLAYER) {
                board.renderBoard(graphics, currentPlayer);
            }

            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);

            graphics.dispose();
            bs.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            update();
            render();

            try {
                Thread.sleep(1000 / FPS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
