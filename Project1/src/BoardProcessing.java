import processing.core.PApplet;
import processing.core.PFont;

public class BoardProcessing extends BoardView {
    private PApplet graphics;

    BoardProcessing(Board board){
        super(board);
        graphics = null;
    }

    public void setGraphics(PApplet graphics) {
        this.graphics = graphics;
    }

    void present(){
        if(graphics == null) return;

        int width = graphics.width;
        int height = graphics.height;

        int cellSize = Math.min(width/board.getWidth(), height/board.getHeight());
        int boardPixelWidth = cellSize * board.getWidth();
        int boardPixelHeight = cellSize * board.getHeight();
        int centeringShiftX = (width - boardPixelWidth) / 2;
        int centeringShiftY = (height - boardPixelHeight) / 2;

        PFont font = graphics.createFont("Arial",40);
        graphics.textFont(font);

        for(int y = 0; y < board.getHeight(); y++){
            for(int x = 0; x < board.getWidth(); x++){
                int number = board.getNumber(x, y);

                int pixelX = centeringShiftX + x * cellSize;
                int pixelY = centeringShiftY + y * cellSize;

                if(number != 0){
                    graphics.fill(128);
                    graphics.rect(pixelX, pixelY, cellSize - 2, cellSize -2);
                    graphics.fill(255);
                    graphics.textSize(40);
                    graphics.textAlign(graphics.CENTER, graphics.CENTER);
                    graphics.text(number, pixelX + cellSize / 2f, pixelY + cellSize /2f);
                } else {
                    graphics.fill(64);
                    graphics.rect(pixelX,pixelY, cellSize - 2, cellSize - 2);
                }
            }
        }
    }
}


