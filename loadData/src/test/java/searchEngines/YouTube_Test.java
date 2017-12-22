package searchEngines;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by zlinuxfan on 22.12.17.
 */
public class YouTube_Test {
    @Test
    public void find() throws Exception {
        YouTube youTube = new YouTube();

        ArrayList<String> strings = youTube.find("налоговый+вычет+жена+в+декрете");
    }

}