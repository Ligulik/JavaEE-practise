package datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {

    public static void insert(String district, String country, int population) throws SQLException{
        try(Connection connection=ConnectionProvider.getConnection();
            Statement statement=connection.createStatement();) {
            String querry = String.format("INSERT INTO city(District, CountryCode, Population) VALUES('%s','%s','%d')",district, country,population);
            String querry2=String.format("INSERT INTO country(Code) VALUES('%s')",country);
            statement.executeUpdate(querry2);
            statement.executeUpdate(querry);
        }
    }

    public static void delete(String district) throws SQLException{
        String selectQuerry=String.format("SELECT ID FROM city WHERE District='%s'",district);
        try(Connection connection=ConnectionProvider.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(selectQuerry);){
            if(resultSet.next()){
                String deleteQuerry=String.format("DELETE FROM city WHERE ID=%d",resultSet.getInt(1));
                statement.executeUpdate(deleteQuerry);
            }
        }
    }
}
