


import DAO.DaoImpl;
import searchEngines.Bing;

import java.util.List;

public class Run {
     private static DaoImpl dao = new DaoImpl();

    public static void main(String[] args) throws Exception {
        List<String> emptyRequestName = dao.readEmptyRequestName();

        while (emptyRequestName != null) {
            dao.writeUrlLink(emptyRequestName.get)
        }

    }
}
