import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Canvas extends JPanel{
    private final BoardSwingView boardView;

    public Canvas(BoardView boardView){
        setBackground(Color.BLACK);
        this.boardView = (BoardSwingView) boardView;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        boardView.setGraphics(g);
        boardView.setWidth(getWidth());
        boardView.setHeight(getHeight());
        boardView.present();
    }
}

public class SwingWindow extends JFrame {
    public SwingWindow() {
        setTitle("2048");
        setSize(900, 600);
        setLocationRelativeTo(null);

        Board board = new Board();
        BoardSwingView boardView = new BoardSwingView(board);
        Canvas canvas = new Canvas(boardView);
        add(canvas);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        board.shiftUp();
                        canvas.repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        board.shiftDown();
                        canvas.repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        board.shiftLeft();
                        canvas.repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        board.shiftRight();
                        canvas.repaint();
                        break;
                }
            }
        });
        setVisible(true);
        }
    }

