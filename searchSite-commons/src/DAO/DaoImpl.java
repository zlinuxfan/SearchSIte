package DAO;


import url.UrlLink;
import java.util.List;

public class DaoImpl implements Dao{

    @Override
    public List<String> readEmptyRequestName() {
        return null;
    }

    @Override
    public boolean writeUrlLink(String requestName, UrlLink urlLink) {
        return false;
    }

    @Override
    public boolean writeUrlLink(String requestName, List<UrlLink> urlLinks) {
        return false;
    }

    @Override
    public boolean writeYouTube(String requestName, List youTubes) {
        return false;
    }
}
