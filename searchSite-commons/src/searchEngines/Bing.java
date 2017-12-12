package searchEngines;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import url.UrlInfo;
import utilities.Utilities;

import java.io.IOException;
import java.util.ArrayList;

public class Bing implements Find {
    private static final String NAME = "Bing";

    @Override
    public ArrayList<UrlInfo> find(String requestName) throws Exception {
        String url = "http://www.bing.com/search?q=" + requestName.replace(" ", "+");

        Document document = null;
        ArrayList<UrlInfo> urlInfos = new ArrayList<>();

        try {
            document = Utilities.getDocument(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements lineResponse = document.select("li.b_algo");
        Elements h2 = lineResponse.select("h2");
        Elements descriptions = lineResponse.select(".b_caption");

        int index = 0;
        for (Element element : h2) {
            System.out.println(descriptions.get(index++).select("p").text());
            System.out.println(element.childNode(0).attributes().get("href"));
            System.out.println(element.text());
        }

        return null;
    }
}
