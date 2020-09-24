import java.awt.*;
import java.awt.image.BufferedImage;


public class LevelSwingView extends LevelView {

    private final static BufferedImage WALL = Utils.getImage("images\\Wall.png");
    private final static BufferedImage FLOOR = Utils.getImage("images\\Ground.png");
    private final static BufferedImage STORAGE = Utils.getImage("images\\Goal.png");

    LevelSwingView(Level level){
        super(level);
    }


    public void present(Object means, int width, int height){
        Graphics g = (Graphics) means;

        int cellSize = Math.min(width / level.getWidth(), height / level.getHeight());

        int screenAreaWidth     = level.getWidth() * cellSize;
        int screenAreaHeight    = level.getHeight() * cellSize;
        int centerShiftX        = (width - screenAreaWidth) / 2;
        int centerShiftY        = (height - screenAreaHeight) / 2;


        char[][] statics = level.getDrawData();

        for(int y = 0; y < level.getHeight(); y++){
            for(int x = 0; x < level.getWidth(); x++){

                int screenX = centerShiftX + x * cellSize;
                int screenY = centerShiftY + y * cellSize;

                char element = statics[y][x];

                switch (element){

                    case Level.WALL_CHAR:
                        g.drawImage(FLOOR, screenX, screenY, cellSize, cellSize, null);
                        g.drawImage(WALL, screenX, screenY, cellSize, cellSize,null);
                        break;

                    case Level.STORAGE_CHAR:
                    case Level.BOX_IN_STORAGE_CHAR:
                    case Level.PLAYER_IN_STORAGE_CHAR:
                        g.drawImage(FLOOR, screenX, screenY, cellSize, cellSize,null);
                        // TODO: center storage image
                        g.drawImage(STORAGE, screenX, screenY, cellSize, cellSize, null);
                        break;

                    case Level.FLOOR_CHAR:
                        g.drawImage(FLOOR, screenX, screenY, null);
                        break;
                }
            }
        }
    }
}
