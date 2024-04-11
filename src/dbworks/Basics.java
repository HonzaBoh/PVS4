package dbworks;

import java.sql.*;

public class Basics {

    private static final String USERNAME = "pvs";
    private static final String PASSWORD = "prg";
    private static final String JDBC_URL = "jdbc:mysql://10.1.12.17:3306/world";
    public static void main(String[] args) {
        Connection connection;//samotne pripojeni
        Statement statement;////to, co budu skladat dohromady (select)
        ResultSet resultSet;//to, co mi to bude vracet
        try{
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            statement = connection.createStatement();

            String query = "SELECT Code, Name, Continent, HeadOfState FROM country";

            resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String code = resultSet.getString("Code");
                String name = resultSet.getString("Name");
                String head = resultSet.getString("HeadOfState");
                String continent = resultSet.getString("Continent");

                System.out.println("Code: " + code + " name: " + name + " continent: " + continent + " Ruled by: " + head);
            }
        } catch (SQLException e) {
            System.err.println("SQL: " + e.getMessage());
        }
    }

}
