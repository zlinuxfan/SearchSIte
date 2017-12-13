package searchEngines;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import url.UrlLink;
import utilities.Utilities;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Bing implements Find {
    private static final String NAME = "Bing";

    @Override
    public ArrayList<UrlLink> find(String requestName) throws Exception {
        String url = "http://www.bing.com/search?q=" + requestName.replace(" ", "+");

        Document document = null;
        ArrayList<UrlLink> urlLinks = new ArrayList<>();

        try {
            document = Utilities.getDocument(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert document != null;
        Elements lineResponse = document.select("li.b_algo");
        Elements h2 = lineResponse.select("h2");
        Elements descriptions = lineResponse.select(".b_caption");

        int index = 0;
        for (Element element : h2) {
            urlLinks.add(
                    new UrlLink(
                            new URL(element.childNode(0).attributes().get("href")),
                            element.text(),
                            descriptions.get(index++).select("p").text()
                    )
            );
        }

        return urlLinks;
    }
}
