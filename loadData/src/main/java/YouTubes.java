import DAO.DaoImpl;
import page.Page;
import searchEngines.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class YouTubes {
    private static DaoImpl dao = new DaoImpl("jdbc:postgresql://194.87.219.8:5432/postgres", "search_site_user", "500");
    private static ArrayList<Page> emptyPages = new ArrayList<Page>();

    private static void init() {
        HashMap<String, Integer> emptyRequestName = dao.readEmptyRequestName("is_youtube");
        createEmptyPage(emptyRequestName);
    }

    public static void main(String[] args) throws Exception {
        init();

        boolean status = false;
        int counterPages = emptyPages.size();
    }

    private static void createEmptyPage(HashMap<String, Integer> emptyRequestName) {
        for (Map.Entry<String, Integer> entry : emptyRequestName.entrySet()) {
            emptyPages.add(new Page(entry.getKey(), entry.getValue()));
        }
    }
}
