package pl.javastart.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthenticationFilter implements Filter {


    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Auth Filter");
        HttpServletRequest httpRequest=(HttpServletRequest) req;
        HttpSession session=httpRequest.getSession(false);
        if(session!=null&&session.getAttribute("username")!=null){
            System.out.println("Sesion + user valid");
            chain.doFilter(req,resp);
        }else{
            System.out.println("No Sesion or no User");
            HttpServletResponse httpResponse=(HttpServletResponse) resp;
            httpResponse.sendRedirect("login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
