import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BoxSwingView extends BoxView {

    final static BufferedImage BOX_INSTALLED = Utils.getImage("images\\BoxRed.png");
    final static BufferedImage BOX_UNINSTALLED = Utils.getImage("images\\BoxBlue.png");

    BoxSwingView(Level level){
        super(level);
    }
    public void present(Object means, int width, int height){

        // TODO: Implement logic to draw box
        Graphics g = (Graphics) means;
        ArrayList<Box> boxes = level.getBoxes();

        for(int i = 0; i < boxes.size(); i++){
            Box box = boxes.get(i);
            BufferedImage imageToDraw;
            if(box.isInstalled()){
                imageToDraw = BOX_INSTALLED;
            }
            else {
                imageToDraw = BOX_UNINSTALLED;
            }
            int boxSize = Math.min(width / level.getWidth(), height / level.getHeight());

            int fieldAreaWidth = boxSize * level.getWidth();
            int fieldAreaHeight = boxSize * level.getHeight();

            int shiftToCenterX = (width - fieldAreaWidth) / 2;
            int shiftToCenterY = (height - fieldAreaHeight) / 2;

            int boxX = box.getX() * boxSize + shiftToCenterX;
            int boxY = box.getY() * boxSize + shiftToCenterY;

            g.drawImage(imageToDraw, boxX, boxY, boxSize, boxSize, null);
        }

    }
}
