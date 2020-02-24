package pl.javastart.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("cookie");
        if ("create".equals(option)) {
            Cookie cookie = createCokie();
            response.addCookie(cookie);
            request.getRequestDispatcher("cookieinfo.jsp").forward(request, response);
        } else if ("check".equals(option)) {
            request.getRequestDispatcher("cookieinfo.jsp").forward(request, response);
        } else if ("delete".equals(option)) {
            removeCookies(request, response);
            request.getRequestDispatcher("nocookie.jsp").forward(request, response);
        }


    }


    private Cookie createCokie() {
        Random r = new Random();
        String cookieName = "cookie" + r.nextInt(100);
        String cookieValue = "" + r.nextInt(1000);
        Cookie c = new Cookie(cookieName, cookieValue);
        c.setMaxAge(1 * 60 * 60);
        return c;
    }


    private void removeCookies(HttpServletRequest req, HttpServletResponse resp){
        Cookie[] cookies=req.getCookies();
        for(Cookie c:cookies){
            c.setMaxAge(0);
            resp.addCookie(c);
        }
    }
}


