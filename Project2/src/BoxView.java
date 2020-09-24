import java.util.ArrayList;

abstract class BoxView implements  View {
    Level level;
    ArrayList<Box> boxes;
    BoxView(Level level){
        this.level = level;
        boxes = level.getBoxes();
    }
}