package page;

import url.UrlLink;
import url.YouTube;

import java.util.ArrayList;

public class Page {
    private String pageName;
    private ArrayList<UrlLink> urlLinks = new ArrayList<>();
    private ArrayList<YouTube> youTubes = new ArrayList<>();
    private ArrayList<String> whatOftenSearched = new ArrayList<>();
    private boolean isFill = false;
    private int id;

    public Page(String pageName, int id) {
        this.pageName = pageName;
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Page{" + "pageName='")
                .append(pageName)
                .append('\'')
                .append("whatOftenSearched=");

        for (String s : whatOftenSearched) {
            stringBuilder
                    .append(s)
                    .append(", ");
        }

        stringBuilder
                .append(", isFill=")
                .append(isFill)
                .append(", id=")
                .append(id)
                .append('}');

        return stringBuilder.toString();
    }

    public void setWhatOftenSearched(ArrayList<String> whatOftenSearched) {
        this.whatOftenSearched = whatOftenSearched;
    }

    public String getPageName() {
        return pageName;
    }

    public int getId() {
        return id;
    }
}
