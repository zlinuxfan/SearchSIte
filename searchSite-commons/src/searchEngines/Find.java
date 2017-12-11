package searchEngines;


import url.UrlInfo;
import java.util.ArrayList;

interface Find {
    ArrayList<UrlInfo> find(String requestName) throws Exception;
}
