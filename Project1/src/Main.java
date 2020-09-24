import processing.core.PApplet;

public class Main {
    public static void main(String [] args) {
       boolean useWindow = false;
       boolean useProcessing = false;

       for (String arg : args) {
           if (arg.equals("--window") || arg.equals("-w")){
               useWindow = true;
           } else if (arg.equals("--processing") || arg.equals("-p")){
               useProcessing = true;
           }
       }

       if (useWindow){
           if (useProcessing){
               PApplet.main(ProcessingWindow.class);
           } else {
               new SwingWindow();
           }
       } else {
           new ConsoleWindow();
       }

    }
}