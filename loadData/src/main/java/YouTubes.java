import DAO.DaoImpl;
import page.Page;
import searchEngines.YouTube;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class YouTubes {
    private static DaoImpl dao = new DaoImpl("jdbc:postgresql://194.87.219.8:5432/postgres", "search_site_user", "500");
    private static ArrayList<Page> emptyPages = new ArrayList<Page>();

    private static final int MAX_NUMBER_YOUTUBES_ID = 3;

    private static void init() {
        HashMap<String, Integer> emptyRequestName = dao.readEmptyRequestName("is_youtube");
        createEmptyPage(emptyRequestName);
    }

    public static void main(String[] args) throws Exception {
        init();
        YouTube youTube = new YouTube();

        boolean status = false;
        int counterPages = emptyPages.size();
        int counterError = 0;

        for (Page page : emptyPages) {
            ArrayList<String> youTubes = youTube.find(page.getPageName());

            if (youTubes.size() == 0) {
                System.out.println("(" + counterPages-- + ") " + page.getPageName() + ": " + status + ", children empty.");
                counterError++;
                continue;
            }

                status = dao.writeYouTube(
                        page.getId(),
                        youTubes.size() > 3 ? youTubes.subList(0, MAX_NUMBER_YOUTUBES_ID) : youTubes);
                System.out.println("(" + counterPages-- + ") " + page.getPageName() + ": " + status);
        }

    }

    private static void createEmptyPage(HashMap<String, Integer> emptyRequestName) {
        for (Map.Entry<String, Integer> entry : emptyRequestName.entrySet()) {
            emptyPages.add(new Page(entry.getKey(), entry.getValue()));
        }
    }
}
