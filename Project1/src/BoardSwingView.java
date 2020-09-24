import java.awt.*;

public class BoardSwingView extends BoardView {

    private Graphics graphics;
    private int width;
    private int height;

    BoardSwingView(Board board) {
        super(board);
        graphics = null;
    }

    public void setGraphics(Graphics g){
        this.graphics = g;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }


    void present(){
        if (graphics == null) return;

        int cellSize = Math.min(width / board.getWidth(), height / board.getHeight());
        int boardPixelWidth = cellSize * board.getWidth();
        int boardPixelHeight = cellSize * board.getHeight();
        int centeringShiftX = (width - boardPixelWidth) / 2;
        int centeringShiftY = (height - boardPixelHeight) / 2;

        graphics.setFont(new Font ("Arial", Font.PLAIN, 40));

        for (int y = 0; y < board.getHeight(); ++y){
            for (int x = 0; x < board.getWidth(); ++x){
                int number = board.getNumber(x, y);

                int pixelX = centeringShiftX + x * cellSize;
                int pixelY = centeringShiftY + y * cellSize;

                if(number != 0){
                    graphics.setColor(Color.GRAY);
                    graphics.fillRect(pixelX, pixelY, cellSize - 2, cellSize - 2);
                    graphics.setColor(Color.WHITE);
                    graphics.drawString(String.valueOf(number), pixelX + cellSize / 2 - 12, pixelY + cellSize / 2 + 10);
                } else {
                    graphics.setColor(Color.DARK_GRAY);
                    graphics.fillRect(pixelX, pixelY, cellSize - 2, cellSize - 2);
                }

            }
        }
    }
}
