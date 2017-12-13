package DAO;

import url.UrlLink;

import java.util.List;


interface Dao {

    public List<String> readEmptyRequestName();

    public boolean writeUrlLink(String requestName, UrlLink urlLink);

    public boolean writeUrlLink(String requestName, List<UrlLink> urlLinks);

    public boolean writeYouTube(String requestName, List youTubes);
}
