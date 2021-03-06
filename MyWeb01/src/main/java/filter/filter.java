package filter;

import entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class filter implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null){
            //登录成功就放行
            System.out.println("放行!");
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            //失败就重定向到登录页面
            System.out.println("用户被拦截");
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect("/myWeb/login.html");
        }
    }

    public void destroy() {

    }
}
