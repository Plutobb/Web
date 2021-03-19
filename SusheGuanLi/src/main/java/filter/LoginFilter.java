package filter;

import model.Response;
import util.JSONUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/main")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        //获取session信息,没有返回null;
        HttpSession session = req.getSession(false);
        if(session == null){
            //获取当前路径;
            String uri = req.getServletPath();
            if ("/public/page/main.html".equals(uri)){//首页没有登录就重定向;
                String scheme = req.getScheme();//http
                String host = req.getServerName();//获取服务器域名;
                int port = req.getServerPort();//获取端口;
                String contextPath = req.getContextPath();//项目部署名;
                String basePath = scheme+"://"+host+":"+port+contextPath;
                res.sendRedirect(basePath+"/public/index.html");
                return;
            }else if (!"/user/login".equals(uri) && !uri.startsWith("/public/")
                    && !uri.startsWith("/static/")){
                req.setCharacterEncoding("UTF-8");
                res.setCharacterEncoding("UTF-8");
                res.setContentType("application/json");
                Response r = new Response();
                r.setCode("301");
                r.setMessage("未授权");
                PrintWriter pw = res.getWriter();
                pw.println(JSONUtil.write(r));
                pw.flush();
                return;
            }
        }
        chain.doFilter(req,res);
    }

    @Override
    public void destroy() {

    }
}
