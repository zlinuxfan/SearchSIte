package searchEngines;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import url.UrlLink;
import utilities.Utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Bing implements Find {
    private static final String NAME = "Bing";

    @Override
    public ArrayList<UrlLink> find(String requestName) throws IOException {
        String url = "http://www.bing.com/search?q=" + requestName.replace(" ", "+");

        ArrayList<UrlLink> urlLinks = new ArrayList<>();
        Document document = Utilities.getDocument(url);
        
        Elements lineResponse = document.select("li.b_algo");
        Elements h2 = lineResponse.select("h2");
        Elements descriptions = lineResponse.select(".b_caption");

        int index = 0;
        for (Element element : h2) {
            URL href;
            try {
                href = new URL(element.childNode(0).attributes().get("href"));

                urlLinks.add(
                        new UrlLink(
                                href,
                                element.text(),
                                descriptions.get(index++).select("p").text()
                        )
                );
            } catch (MalformedURLException e) {
                System.out.println("for " + element.childNode(0).attributes().get("href"));
                e.printStackTrace();
            }
        }

        return urlLinks;
    }
}
