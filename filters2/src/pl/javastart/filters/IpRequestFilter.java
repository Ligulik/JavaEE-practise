package pl.javastart.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class IpRequestFilter implements Filter {

    private String ipPattern;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String requestIp=req.getRemoteAddr();
        System.out.println("Ip filter"+requestIp);
        if(requestIp.matches(ipPattern)){
            System.out.println("Ip ok!");
            chain.doFilter(req,resp);
        }else{
            System.out.println("IP nie jest ok");
            HttpServletResponse httpResponse=(HttpServletResponse) resp;
            httpResponse.sendError(403);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        ipPattern=config.getInitParameter("ipPattern");
    }

}
