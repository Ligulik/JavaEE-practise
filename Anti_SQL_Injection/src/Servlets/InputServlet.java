// I create a PreparedStatement to provide SQLinjection, beacuse searching parameters are string not a sql querry.

package Servlets;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class InputServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DataSource ds=null;
        try{
            ds=getDataSource();
        }catch (NamingException e){
            e.printStackTrace();
        }


        final String sqlQuerry="SELECT username, password FROM user WHERE username=? AND password=?";
        try(Connection connection=ds.getConnection();
            PreparedStatement statement=connection.prepareStatement(sqlQuerry);){
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            statement.setString(1,username);
            statement.setString(2,password);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                String userFound=resultSet.getString("username");
                request.getSession().setAttribute("username",userFound);
                if("Admin".equals(userFound)){
                    request.getSession().setAttribute("priviliges","all");
                }else{
                    request.getSession().setAttribute("priviliges","view");
                }
            }else {
                request.getSession().setAttribute("username","nieznajomy");
                request.getSession().setAttribute("priviliges","none");
            }
            request.getRequestDispatcher("result.jsp").forward(request,response);
        }catch(SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }



    }

    private DataSource getDataSource() throws NamingException {
        Context initialContext = new InitialContext();
        Context envContext = (Context) initialContext.lookup("java:comp/env");
        return (DataSource) envContext.lookup("jdbc/users");
    }
}
