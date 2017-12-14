


import DAO.DaoImpl;
import searchEngines.Bing;

import java.util.HashMap;
import java.util.List;

public class Run {
    private static DaoImpl dao = new DaoImpl("localhost", "searh_site_user", "serch_site_500");
    private static Bing bing = new Bing();

    public static void main(String[] args) {
        HashMap<String, Integer> emptyRequestName = dao.readEmptyRequestName();

        int counter = 0;
        String requestName;
        while (emptyRequestName != null) {
//            requestName = emptyRequestName.get(counter);

//            try {
//                dao.writeUrlLink(requestName, bing.find(requestName));
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("Request name: " + requestName + " is not processed.");
//            }
        }

    }
}
