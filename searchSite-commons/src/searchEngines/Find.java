package searchEngines;


import url.UrlLink;
import java.util.ArrayList;

interface Find {
    ArrayList<UrlLink> find(String requestName) throws Exception;
}
