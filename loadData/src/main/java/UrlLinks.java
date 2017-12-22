import DAO.DaoImpl;
import page.Page;
import searchEngines.Bing;
import url.UrlLink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UrlLinks {
    private static DaoImpl dao = new DaoImpl("jdbc:postgresql://localhost:5432/search_site", "search_site_user", "500");
    private static ArrayList<Page> emptyPages = new ArrayList<Page>();


    private static void init() {
        HashMap<String, Integer> emptyRequestName = dao.readEmptyRequestName("is_url_links");
        createEmptyPage(emptyRequestName);
    }

    public static void main(String[] args) throws Exception {
        init();
        Bing bing = new Bing();
        boolean status;
        int counter = emptyPages.size() - 1;

        for (Page page: emptyPages) {
            status = dao.writeUrlLink(page.getId(), bing.find(page.getPageName()))  ;
            System.out.println("(" + counter-- + ") " + page.getPageName() + ": " + status);
            break;
        }
    }

    private static void createEmptyPage(HashMap<String, Integer> emptyRequestName) {
        for (Map.Entry<String, Integer> entry : emptyRequestName.entrySet()) {
            emptyPages.add(new Page(entry.getKey(), entry.getValue()));
        }
    }
}
