package searchEngines;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import url.UrlLink;
import utilities.Utilities;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;


public class YouTube {


    public ArrayList<String> find(String requestName) throws Exception {
        String url = "https://www.youtube.com/results?search_query=" + requestName.replace(" ", "+");
        Document doc = Utilities.getDocument(url); //connectUrl(url);  //getDocument(url);
        ArrayList<String> key = new ArrayList<>();
        ArrayList<URL> urls = new ArrayList<>();

//        System.out.println(doc.html());

        Elements contents = doc.select("#img-preload");

//        System.out.println(contents);

        for (Element section : contents) {
            Elements img = section.select("img");
            for (Element element : img) {
                urls.add(new URL(element.absUrl("src")));
            }
        }

        String[] split = urls.get(0).getPath().split("/");
        System.out.println(split[2]);

        return key;
    }
}
