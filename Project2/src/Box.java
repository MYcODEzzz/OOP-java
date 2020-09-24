import java.awt.*;
import java.util.ArrayList;

public class Box {

    private int initialX;
    private int initialY;
    private int x, y;
    private boolean isInstalled;
    ArrayList<Box> otherBoxes;
    ArrayList<Point> walls;

    Box(int x, int y){
        this.x = x;
        this.y = y;
        initialX = x;
        initialY = y;
        isInstalled = false;
    }
    void reset(ArrayList<Point> goals){
        x = initialX;
        y = initialY;
        checkIfInstalled(goals);
    }
    void move(int direction, ArrayList<Point> walls, ArrayList<Box> otherBoxes){
        this.walls = walls;
        this.otherBoxes = otherBoxes;

        int oppositeDirection = -1;

        switch (direction){
            case Player.UP:
                up();
                oppositeDirection = Player.DOWN;
                break;
            case Player.DOWN:
                down();
                oppositeDirection = Player.UP;
                break;
            case Player.LEFT:
                left();
                oppositeDirection = Player.RIGHT;
                break;
            case Player.RIGHT:
                right();
                oppositeDirection = Player.LEFT;
                break;
        }

        // TODO: Check if collides with other boxes
        for(int i = 0; i < otherBoxes.size(); i++){
            Box otherBox = otherBoxes.get(i);
            if(!this.equals(otherBox) && x == otherBox.getX() && y == otherBox.getY()){
                move(oppositeDirection, walls, otherBoxes);
            }
        }

        // TODO: Check if collides with walls
        for(int i = 0; i < walls.size(); i++){
            Point wall = walls.get(i);
            if(x == wall.x && y == wall.y){
                move(oppositeDirection, walls, otherBoxes);
            }
        }
    }

    void checkIfInstalled(ArrayList<Point> goals){
        for(int i = 0; i < goals.size(); i++){
            int x = goals.get(i).x;
            int y = goals.get(i).y;
            if(this.x == x && this.y == y){
                setInstalled(true);
                return;
            }
        }
        setInstalled(false);
    }

    void setInstalled(boolean isInstalled){ this.isInstalled = isInstalled; }

    boolean isInstalled(){ return isInstalled; }

    int getX() { return x; }
    int getY() { return y; }

    private void left(){ x--; }
    private void right(){ x++; }
    private void up(){ y--; }
    private void down(){ y++; }
}



