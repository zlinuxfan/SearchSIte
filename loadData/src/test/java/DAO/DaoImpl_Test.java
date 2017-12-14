package DAO;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DaoImpl_Test {
    private DaoImpl dao;

    @Before
    public void init() {
        dao = new DaoImpl("jdbc:postgresql://localhost:5432/search_site", "search_site_user", "500");
    }

    @Test
    public void writeRequestName() {
        assertTrue(dao.writeRequestName("как выгодно вложить деньги"));
    }

    @Test
    public void readEmptyRequestName() {
        HashMap<String, Integer> emptyRequestName = dao.readEmptyRequestName();

        for (Map.Entry<String, Integer> entry : emptyRequestName.entrySet()) {
            System.out.println(hexToString(entry.getKey().replace("\\x", "")) + ": " + entry.getValue());
        }

    }

    @Test
    public void main() {

    }

    public static String hexToString(String hex) {
        byte[] bytes;
        String answer = null;
        try {
            bytes = Hex.decodeHex(hex.toCharArray());
            answer = new String(bytes, "UTF-8");
        } catch (DecoderException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return answer;
    }
}