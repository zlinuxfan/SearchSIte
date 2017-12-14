package DAO;


import url.UrlLink;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

public class DaoImpl implements Dao {
    private String host;
    private String user;
    private String password;

    private static final String TABLE_MAIN = "main";
    private static final String TABLE_MAIN_FIELD_REQUEST_NAME = "request_name";
    private static final String TABLE_MAIN_FIELD_ID = "id";

    public DaoImpl(String host, String user, String password) {
        this.host = host;
        this.user = user;
        this.password = password;
    }

    @Override
    public HashMap<String, Integer> readEmptyRequestName() {
        return selectIn(
          String.format("SELECT %s, %s FROM %s WHERE is_filled IS FALSE;",
                  TABLE_MAIN_FIELD_ID,
                  TABLE_MAIN_FIELD_REQUEST_NAME,
                  TABLE_MAIN)
        );
    }

    private HashMap<String, Integer> selectIn(String query) {
        HashMap<String, Integer> emptyRequestName = new HashMap<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet result;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(host, user, password);
            statement = connection.createStatement();
            result = statement.executeQuery(query);

            if (result.isBeforeFirst()) {
                while (result.next()) {
                    emptyRequestName.put(
                            result.getString(TABLE_MAIN_FIELD_REQUEST_NAME),
                            result.getInt(TABLE_MAIN_FIELD_ID)
                    );
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }   finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return emptyRequestName.isEmpty() ? null : emptyRequestName;
    }

    public boolean writeRequestName(String requestName) {
        return insertInto(
                String.format("INSERT INTO %s (%s) VALUES ('\\\\x%s');",
                    TABLE_MAIN,
                    TABLE_MAIN_FIELD_REQUEST_NAME,
                    requestName)
                );
    }

    private boolean insertInto(String query) {
        Connection connection = null;
        PreparedStatement statement = null;
        int numberOfInsert = 0;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(host, user, password);
            statement = connection.prepareStatement(query);
            numberOfInsert = statement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return numberOfInsert > 0;
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
