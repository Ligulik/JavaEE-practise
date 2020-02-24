import java.sql.*;

public class JdbcMain {

    public static void main(String[] arg) throws ClassNotFoundException, SQLException {

        // pobranie i zainstalowanie sterownikow:
        final String driver="com.mysql.cj.jdbc.Driver";
       Class.forName(driver);



       // Obiekt ktory reaalizuje połączenie z bazą dancyh:
        final String dbPath="jdbc:mysql://localhost:3306/hello_database?serverTimezone=UTC&useSSL=false";
        Connection conn= DriverManager.getConnection(dbPath,"root","liguli98");


        // Zapytania wykonujemy na obiekcie statement z obiketu connection:

        Statement statement=conn.createStatement();

        final String sqlQuery="SELECT firstname, lastname FROM person";

        final String sqlAdd="INSERT INTO person VALUES('222222','mariusz','paciaciaciak')";

        int wynik=0;
        wynik=statement.executeUpdate(sqlAdd);
        
        // Statement zwraca obiekt result set. - kaze mu wykonac zapytanie:
        ResultSet resultSet=statement.executeQuery(sqlQuery);


        // czyszcze dane:
        String firstName=null;
        String lastName=null;
        while(resultSet.next()){
           firstName=resultSet.getString("firstname");
            lastName=resultSet.getString("lastname");
            System.out.println(firstName+ " : "+lastName);
        }

        if(conn != null) {
            conn.close();
        }
    }

}
