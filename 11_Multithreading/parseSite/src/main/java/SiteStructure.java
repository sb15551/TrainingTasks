import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class SiteStructure {
    private volatile List<SiteStructure> children;
    private volatile int level;
    private String url;
    private volatile SiteStructure parent;

    public SiteStructure(String url) {
        children = new CopyOnWriteArrayList<>();
        level = 0;
        this.url = url;
        parent = null;
    }

    public synchronized void addChild(SiteStructure child) {
        SiteStructure root = getParent();
        if(!root.contains(child.getUrl())) {
            child.setParent(this);
            children.add(child);
        }
    }

    private int calculateLevel() {
        int rst = (parent == null) ? 0 : parent.calculateLevel() + 1;
        return rst;
    }

    private boolean contains(String url) {
        if (this.url.equals(url)) {
            return true;
        }
        for (SiteStructure child : children) {
            if (child.contains(url)) {
                return true;
            }
        }
        return false;
    }

    public List<SiteStructure> getChildren() {
        return children;
    }

    public void setParent(SiteStructure parent) {
        synchronized (this) {
            this.parent = parent;
            this.level = calculateLevel();
        }
    }

    public SiteStructure getParent() {
        return parent == null ? this : parent.getParent();
    }

    public String getUrl() {
        return url;
    }

}