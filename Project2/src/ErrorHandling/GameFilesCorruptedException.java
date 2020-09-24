package ErrorHandling;

public class GameFilesCorruptedException extends Exception {
    public GameFilesCorruptedException(String s){

        super(s);
    }
}
