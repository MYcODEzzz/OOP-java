package ErrorHandling;

public class LevelDataCorruptedException extends Exception {
    public LevelDataCorruptedException(){

        this("File with level representation is empty");
    }
    public LevelDataCorruptedException(String s){

        super(s);
    }
}
