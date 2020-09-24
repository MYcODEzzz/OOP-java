import processing.core.PApplet;

public class ProcessingWindow extends PApplet {

    private final Board board;
    private final BoardProcessing boardView;

    public ProcessingWindow(){
        board = new Board();
        boardView = new BoardProcessing(board);
        boardView.setGraphics(this);
    }

    public void settings(){
        size(900,600);

    }

    public void setup(){
        surface.setTitle("2048");
        background(0);
        noStroke();
    }

    public void draw() {
        boardView.present();
    }

    public void keyPressed(){
        switch (keyCode) {
                case UP: board.shiftUp(); break;
                case DOWN: board.shiftDown(); break;
                case LEFT: board.shiftLeft(); break;
                case RIGHT: board.shiftRight(); break;
        }
    }

}
