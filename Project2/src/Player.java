import java.awt.*;
import java.util.ArrayList;

public class Player {

    final static int UP = 0;
    final static int DOWN = 1;
    final static int LEFT = 2;
    final static int RIGHT = 3;

    private int initialX;
    private int initialY;
    private int x, y;
    private int direction;
    ArrayList<Point> walls;

    Player(int x, int y){
        this.x = x;
        this.y = y;
        initialX = x;
        initialY = y;
        direction = DOWN;
    }
    void reset(){
        x = initialX;
        y = initialY;
        direction = DOWN;
    }
    void StartMoving(ArrayList<Point> walls){
        this. walls = walls;
    }

    // collision checks
    void moveUp(){
        int newY = y - 1;
        direction = UP;
        for(int i = 0; i < walls.size(); i++){
            Point wall = walls.get(i);
            if(newY == wall.y && x == wall.x){
                return;
            }
        }
        y = newY;
    }
    //collision checks
    //move new method checkCollision()
    void moveDown(){
        int newY = y + 1;
        direction = DOWN;
        for(int i = 0; i < walls.size(); i++){
            Point wall = walls.get(i);
            if(newY == wall.y && x == wall.x){
                return;
            }
        }
        y = newY;
    }

    // collision checks
    void moveLeft(){
        int newX = x - 1;
        direction = LEFT;
        for(int i = 0; i < walls.size(); i++){
            Point wall = walls.get(i);
            if(newX == wall.x && y == wall.y){
                return;
            }
        }
        x = newX;
    }

    // collision checks
    void moveRight(){
        int newX = x + 1;
        direction = RIGHT;
        for(int i = 0; i < walls.size(); i++){
            Point wall = walls.get(i);
            if(newX == wall.x && y == wall.y){
                return;
            }
        }
        x = newX;
    }

    void moveTo(Point point, int direction){
        x = point.x;
        y = point.y;
        this.direction = direction;
    }

    int getDirection(){ return direction; }
    int getX() { return x; }
    int getY() { return y; }
}