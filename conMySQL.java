import java.sql.*;

public class conMySQL {
    static final String url = "jdbc:mysql://IP_SV:3306/DATABASE"; // Change IP_SV and DATABASE
    static final String user = "USERNAME"; // Change USERNAME
    static final String password = "PASSWORD"; // Change PASSWORD
    public static String[] result;

    public static String[] getResult() {
        return result;
    }

    public static void selectQuery(String query) {
        if (!query.toUpperCase().contains("SELECT") || query.toUpperCase().contains("DELETE") || query.toUpperCase().contains("UPDATE") || query.toUpperCase().contains("INSERT") || query.toUpperCase().contains("TRUNCATE") || query.toUpperCase().contains("ALTER")){
            System.out.println("You should only execute SELECT queries.");
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexion = DriverManager.getConnection(url, user, password);
            Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            resultSet.last();
            int numberOfRows = resultSet.getRow();
            resultSet.beforeFirst();

            result = new String[numberOfRows * numberOfColumns];

            int index = 0;
            while (resultSet.next()) {
                for (int i = 0; i < numberOfColumns; i++) {
                    result[index++] = resultSet.getString(i + 1);
                }
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void insertQuery(String query) {
        if (!query.toUpperCase().contains("INSERT") || query.toUpperCase().contains("DELETE") || query.toUpperCase().contains("UPDATE") || query.toUpperCase().contains("TRUNCATE") || query.toUpperCase().contains("ALTER")) {
            System.out.println("You should only execute INSERT queries.");
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexion = DriverManager.getConnection(url, user, password);
            Statement statement = conexion.createStatement();

            statement.executeUpdate(query);
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteQuery(String query) {
        if (!query.toUpperCase().contains("DELETE") || query.toUpperCase().contains("UPDATE") || query.toUpperCase().contains("INSERT") || query.toUpperCase().contains("TRUNCATE") || query.toUpperCase().contains("ALTER")) {
            System.out.println("You should only execute DELETE queries.");
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexion = DriverManager.getConnection(url, user, password);
            Statement statement = conexion.createStatement();

            statement.executeUpdate(query);
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateQuery(String query) {
        if (!query.toUpperCase().contains("UPDATE") || query.toUpperCase().contains("DELETE") || query.toUpperCase().contains("INSERT") || query.toUpperCase().contains("TRUNCATE") || query.toUpperCase().contains("ALTER")){
            System.out.println("You should only execute UPDATE queries.");
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexion = DriverManager.getConnection(url, user, password);
            Statement statement = conexion.createStatement();

            statement.executeUpdate(query);
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
