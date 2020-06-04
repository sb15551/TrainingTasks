import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

public class Main {

    private static String srcFolder = "11_Multithreading/ImageResizer/src/main/resources/sortedmap/src";
    private static String dstFolder = "11_Multithreading/ImageResizer/src/main/resources/sortedmap/dst";
    private static int newWidth = 300;
    private static int cores = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        long start = System.currentTimeMillis();
        int len = files.length / cores;
        int srcPos = len;

        for (int i = 0; i < cores; i++) {
            if (i == cores -1) {
                len += files.length - (len * cores);
            }
            File[] filesTemp = new File[len];
            System.arraycopy(files, i * srcPos, filesTemp, 0 , len);
            ImageResizer resizer = new ImageResizer(filesTemp, newWidth, dstFolder, start);
            new Thread(resizer).start();
        }
    }
}
