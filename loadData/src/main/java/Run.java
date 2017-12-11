

import searchEngines.Bing;

public class Run {
    public static void main(String[] args) throws Exception {
        String url = "как найти смысл жизни";

        Bing bing = new Bing();

        bing.find(url);
    }
}
