package ru.skillbox.module09_4.task01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;

public class ParseLentaRu {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://lenta.ru/").get();

            Elements elements = doc.select("img.g-picture");

            for (Element element : elements) {
                getImages(element.absUrl("src"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getImages(String src) throws IOException {

        int indexname = src.lastIndexOf("/");
        String name = src.substring(indexname, src.length());

        System.out.println(name);

        URL url = new URL(src);
        InputStream in = url.openStream();

        OutputStream out = new BufferedOutputStream(new FileOutputStream("module09/src/main/resources/img" + name));

        for (int b; (b = in.read()) != -1;) {
            out.write(b);
        }
        out.flush();
        out.close();
        in.close();
    }
}
