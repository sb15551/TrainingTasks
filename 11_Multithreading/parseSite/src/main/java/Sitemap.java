import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.RecursiveAction;
import java.util.regex.Pattern;

public class Sitemap extends RecursiveAction {
    private SiteStructure site;

    public Sitemap(SiteStructure site) {
        this.site = site;
    }
    @Override
    protected void compute() {
        try {
            Document doc = Jsoup.connect(site.getUrl()).get();
            Elements links = doc.select("a");
            for (Element link : links) {
                String href = link.absUrl("href");
                if (isValidUrl(href)) {
                    href = href.replaceAll("\\?.+","");
                    System.out.println(href);
                    site.addChild(new SiteStructure(href));
                }
            }
        } catch (IOException  e) {
            e.printStackTrace();
        }

        for (SiteStructure child : site.getChildren()) {
            Sitemap sitemap = new Sitemap(child);
            sitemap.compute();
        }
    }

    private boolean isValidUrl(String url) {
        Pattern patternRoot = Pattern.compile("^" + site.getUrl());

        return patternRoot.matcher(url).lookingAt();
    }
}
