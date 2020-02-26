package Servlets;

import datasource.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet( "/ControlerServlet")
public class ControlerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String district=request.getParameter("district");
        String country=request.getParameter("country");
        String populationString =request.getParameter("population");
        int population = 0;
        if(populationString!=null&&!populationString.isEmpty()){
            population=Integer.parseInt(populationString);
        }

        String option=request.getParameter("option");
        String message=null;
        if("add".equals(option)){
            try {
                DbUtil.insert(district, country, population);
                message = "pomyśłnie dodano miasto" + district;
            }catch (SQLException e){
                message="nie udało sie dodać miasta" +district;
                e.printStackTrace();
            }
        }else if("delete".equals(option)){
            try{
                DbUtil.delete(district);
                message="pomyślnie usunięto miasto"+district;
            }catch (SQLException ex){
                message="nie udało się usunąć miasta";
                ex.printStackTrace();
            }
        }

        request.setAttribute("message",message);
        request.getRequestDispatcher("message.jsp").forward(request,response);
    }

}
