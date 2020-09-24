import java.util.Scanner;

public class ConsoleWindow {
        public ConsoleWindow() {
            Scanner scanner = new Scanner(System.in);

            Board board = new Board();
            BoardView boardView = new BoardConsoleView(board);

            boardView.present();
            System.out.println("u: up, l: left, d: down, r: right");
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine().toLowerCase();
                switch (command) {
                    case "u":
                    case "up": board.shiftUp(); boardView.present(); break;
                    case "d":
                    case "down": board.shiftDown(); boardView.present(); break;
                    case "l":
                    case "left": board.shiftLeft(); boardView.present(); break;
                    case "r":
                    case "right": board.shiftRight(); boardView.present(); break;
                    case "p":
                    case "present": boardView.present(); break;
                }
            }
        }
    }

