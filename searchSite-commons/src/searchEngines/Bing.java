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

        try {
            document = Utilities.getDocument(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements lineResponse = document.select("li.b_algo");

        for (Element element : lineResponse) {
            System.out.println(element.html());
        }

        return null;
    }
}
