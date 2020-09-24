package ErrorHandling;

public class LevelFileNotFoundException extends GameFilesCorruptedException {
    public LevelFileNotFoundException(String s) {
        super(s);
    }
}
