package listeners;

import jdbc.db.DbUtil;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class DbInitListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Contekst zainicjalizowany - powstała pula połączeń");
        try{
            DbUtil.getInstance().getConnection();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        DbUtil.getInstance().close();
        System.out.println("Usunięcie puli połączeń");
    }
}
