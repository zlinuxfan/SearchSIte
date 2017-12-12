package url;


import java.net.URL;

public class UrlInfo {
    private URL link;
    private String description;

    public UrlInfo(URL link, String description) {
        this.link = link;
        this.description = description;
    }

    public URL getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }
}
