import DAO.DaoImpl;
import page.Page;
import searchEngines.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChildrenRequestType {
    private static DaoImpl dao = new DaoImpl("jdbc:postgresql://localhost:5432/search_site", "search_site_user", "500");
    private static ArrayList<Page> emptyPages = new ArrayList<Page>();

    private static void init() {
        HashMap<String, Integer> emptyRequestName = dao.readEmptyRequestName("is_what_often_searched");
        createEmptyPage(emptyRequestName);
    }

    public static void main(String[] args) throws Exception {
        init();
        Google google = new Google();
        boolean status = false;
        int counterPages = emptyPages.size();

        for (Page page : emptyPages) {
            ArrayList<String> oftenSearched = google.find(page.getPageName());

            if (oftenSearched.size() == 0) {
                System.out.println("(" + counterPages-- + ") " + page.getPageName() + ": " + status + ", children empty.");
                continue;
            }

            for (String requestName : oftenSearched) {
                int requestNameId = dao.isThere(requestName);
                if (requestNameId != 0) {
                    status = dao.writeWhatOftenSearched(page.getId(), requestNameId);
                } else {
                    dao.writeRequestName(requestName);
                    status = dao.writeWhatOftenSearched(page.getId(), dao.isThere(requestName));
                }
            }

            System.out.println("(" + counterPages-- + ") " + page.getPageName() + ": " + status);
        }
    }

    private static void createEmptyPage(HashMap<String, Integer> emptyRequestName) {
        for (Map.Entry<String, Integer> entry : emptyRequestName.entrySet()) {
            emptyPages.add(new Page(entry.getKey(), entry.getValue()));
        }
    }
}
