package datasource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionProvider {
    private static DataSource dataSource;

    public static Connection getConnection() throws SQLException{
        return getDSInstance().getConnection();
    }

    private static DataSource getDSInstance(){
        if(dataSource==null){
            try {
                Context context = new InitialContext();
                Context envContex = (Context) context.lookup("java:comp/env");
                dataSource = (DataSource) envContex.lookup("jdbc/world");
                }catch (NamingException e){
                e.printStackTrace();
                System.out.println("Zaszedl wyjatek");
            }
            }
        return dataSource;
    }



}
