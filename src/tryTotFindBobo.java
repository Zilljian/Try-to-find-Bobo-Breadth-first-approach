import java.io.File;
import java.lang.*;
import java.util.LinkedList;

public class tryTotFindBobo {
    static boolean isFound = false;
    static LinkedList<File> traversalQueue = new LinkedList<>();
    static String path;

    public static void main(String[] args) {
        File initialPath = new File("C://");
        traversalQueue.add(initialPath);
        long timerStart, timerEnd;
        timerStart = System.nanoTime();
        findBobo();
        timerEnd = System.nanoTime();
        if (!isFound) {
            System.out.println("File has not been found ¯＼_(ツ)_/¯");
        }
        else printBoboLocation();
        System.out.println(String.format("%,12d",timerEnd-timerStart) + " ns");
    }

    static void findBobo () throws NullPointerException {
        while (!isFound && !traversalQueue.isEmpty()){
            checkDir(traversalQueue.getFirst());
            traversalQueue.remove();
        }
    }

    static void checkDir(File tempDir) throws NullPointerException{
        try {
            for (File file : tempDir.listFiles()) {
                if (file.isDirectory()) {
                    traversalQueue.addLast(file);
                }
                else if (file.isFile() && file.getName().equals("bobo.txt")) {
                    isFound = true;
                    path = file.getPath();
                    return;
                }
            }
        } catch (NullPointerException e) {
        }
    }

    static void printBoboLocation (){
        System.out.println("Bobo is hiding here >> " + path);
    }
}
