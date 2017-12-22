


import DAO.DaoImpl;
import page.Page;
import searchEngines.Bing;
import searchEngines.Google;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Run {
    private static DaoImpl dao = new DaoImpl("jdbc:postgresql://localhost:5432/search_site", "search_site_user", "500");
    private static ArrayList<Page> emptyPages = new ArrayList<Page>();
    private static Bing bing = new Bing();

    private static void init() {
        HashMap<String, Integer> emptyRequestName = dao.readEmptyRequestName();
        createEmptyPage(emptyRequestName);
    }

    public static void main(String[] args) throws Exception {
//        init();
//        Google google = new Google();
//
//        for (Page page : emptyPages) {
//            dao.writeWhatOftenSearched(page.getId(), google.find(page.getPageName()));
//        }

        for (String requestName : readFile("data/request.txt")) {
            if ( dao.isThere(requestName) == 0) {
                dao.writeRequestName(requestName);
                System.out.println("add: " + requestName);
            }
        }
    }

    private static ArrayList<String> readFile(String file) throws FileNotFoundException {
        ArrayList<String> requestNames = new ArrayList<String>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                requestNames.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return requestNames;
    }

    private static void print(ArrayList<Page> emptyPages) {
        for (Page emptyPage : emptyPages) {
            System.out.println(emptyPage);
        }
    }

    private static void createEmptyPage(HashMap<String, Integer> emptyRequestName) {
        for (Map.Entry<String, Integer> entry : emptyRequestName.entrySet()) {
            emptyPages.add(new Page(entry.getKey(), entry.getValue()));
        }
    }
}
