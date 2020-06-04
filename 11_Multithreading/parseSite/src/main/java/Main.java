import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static String url = "https://lenta.ru/";

    public static void main(String[] args) throws IOException {
        SiteStructure sitemap = new SiteStructure(url);
        new ForkJoinPool().invoke(new Sitemap(sitemap));

        FileOutputStream stream = new FileOutputStream("11_Multithreading/parseSite/src/main/resources/sitemap.txt");
        String result = createSitemap(sitemap, 0);
        stream.write(result.getBytes());
        stream.flush();
        stream.close();

    }

    public static String createSitemap(SiteStructure site, int depth) {
        String tabs = String.join("", Collections.nCopies(depth, "\t"));
        StringBuilder result = new StringBuilder(tabs + site.getUrl());
        site.getChildren().forEach(child -> {
            result.append("\n").append(createSitemap(child, depth + 1));
        });
        return result.toString();
    }
}
