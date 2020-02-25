package Servlets;
import data.City;
import jdbc.db.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/SqlServlet")
public class SqlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("get");
        if ("show".equals(param)) {
            try {
                List<City> cityList = getCities();
                request.setAttribute("cityList", cityList);
                request.getRequestDispatcher("citylist.jsp").forward(request, response);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                response.sendError(500); // nie udało się pobrać danych
            }
        } else {
            response.sendError(403);
        }
    }

    private List<City> getCities() throws SQLException, ClassNotFoundException {

        List<City> cityList = null;
        final String sqlQuery = "SELECT District, Population FROM city";
        try (Connection conn = DbUtil.getInstance().getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery);) {
            String cityDistrict = null;
            int cityPopulation = 0;
            cityList = new ArrayList<>();
            while (resultSet.next()) {
                cityDistrict = resultSet.getString("District");
                cityPopulation = resultSet.getInt("Population");
                City city = new City(cityDistrict, cityPopulation);
                cityList.add(city);
            }
        }

        return cityList;
    }

    public void destroy(){
        DbUtil.getInstance().close();
    }
}
