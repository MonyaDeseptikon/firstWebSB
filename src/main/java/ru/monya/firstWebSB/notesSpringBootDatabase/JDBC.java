package ru.monya.firstWebSB.notesSpringBootDatabase;

import java.sql.*;
import java.util.ArrayList;
//Простой класс для создания БД и таблицы mySQL и проверки того, что есть в БД
public class JDBC {
    private static final String url = "jdbc:mysql://localhost:3306";
    private static final String user = "user";
    private static final String password = "root";

    public static void main(String[] args) throws SQLException {
        Connection con = getConnections(url, user, password);
        Statement statement = con.createStatement();
//        statement.execute("DROP SCHEMA sbdata");
//        statement.execute("CREATE SCHEMA IF NOT EXISTS sbdata");

        statement.execute("CREATE TABLE IF NOT EXISTS sbdata.notes " +
                "(id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "author VARCHAR(90) NULL," +
                "title VARCHAR(90) NULL," +
                "content VARCHAR(2000) NULL)");
        statement.execute("INSERT INTO sbdata.notes (author, title, content) "
                + "VALUES('me', 'myNote', 'my first Note');");


        ResultSet set = statement.executeQuery("SELECT * FROM sbdata.notes");
        System.out.println(getDataFromSchema(set));
////        System.out.println(set.getMetaData());

con.close();
    }

    public static Connection getConnections(String url, String user, String password) throws SQLException {
        Connection con = null;
                   con =DriverManager.getConnection(url, user, password);
               return con;
    }

    public static ArrayList<String> getDataFromSchema (ResultSet set) throws SQLException {
        ArrayList<String> list = new ArrayList<>();

        while (set.next()) {
            list.add(set.getInt(1) + " " + set.getString(2) + " " + set.getString(3)+ " " + set.getString(4));
        }
        return list;
    }
}