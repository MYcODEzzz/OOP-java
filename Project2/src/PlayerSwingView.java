import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerSwingView extends PlayerView {

    // TODO: Load all required images

    final static BufferedImage ROBOT_UP = Utils.getImage("images\\RobotU.png");
    final static BufferedImage ROBOT_DOWN = Utils.getImage("images\\RobotD.png");
    final static BufferedImage ROBOT_LEFT = Utils.getImage("images\\RobotL.png");
    final static BufferedImage ROBOT_RIGHT = Utils.getImage("images\\RobotR.png");

    PlayerSwingView(Level level){
        super(level);
    }

    @Override
    public void present(Object means, int width, int height) {

        Graphics g = (Graphics) means;
        BufferedImage imageToDraw;
        switch (player.getDirection()){
            case Player.UP:
                imageToDraw = ROBOT_UP;
                break;
            case Player.LEFT:
                imageToDraw = ROBOT_LEFT;
                break;
            case Player.RIGHT:
                imageToDraw = ROBOT_RIGHT;
                break;
            default:
                imageToDraw = ROBOT_DOWN;
        }
        int cellSize = Math.min(width / level.getWidth(), height / level.getHeight());

        // TODO: Center player in cell because player's image is not rectangular

        int fieldAreaWidth = level.getWidth() * cellSize;
        int fieldAreaHeight = level.getHeight() * cellSize;
        int centerShiftX = (width - fieldAreaWidth) / 2;
        int centerShiftY = (height - fieldAreaHeight) / 2;
        int robotX = player.getX() * cellSize + centerShiftX ;
        int robotY = player.getY() * cellSize + centerShiftY ;

        g.drawImage(imageToDraw, robotX, robotY, cellSize, cellSize, null);
    }
}
