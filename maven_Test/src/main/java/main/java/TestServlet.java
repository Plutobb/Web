package main.java;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//请求数据编码：请求体产生作用，url中的数据无效
        resp.setCharacterEncoding("UTF-8");//服务端响应的内容设置编码
        //告诉浏览器：1.数据类型（浏览器处理数据的方式）2.编码（浏览器解析数据的编码）
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter pw = resp.getWriter();
        HttpSession session = req.getSession(false);
        /**
         * 敏感资源，需要校验：
         * 1.用户是否登录，没有登录，跳转到登陆页面（响应401状态码）Unauthorized
         * 2.校验用户权限：是否有访问当前资源的权限（响应403状态码）Forbidden
         */
        if(session == null){//没有登录
            resp.setStatus(401);
            pw.println("用户没有登录，不允许访问");
            pw.flush();
            return;
        }
        String username = (String) session.getAttribute("user");
        //正式实现时，可以保存用户很多信息包括权限，我们这里只是模拟，保存用户名
//        if(!user对象.获取权限.校验是否包含当前请求资源){//用户已登录，但没有访问权限
//            resp.setStatus(403);
//            pw.println("用户没有访问权限，禁止访问");
//            pw.flush();
//            return;
//        }

        //测试用，演示http请求头、响应头、状态码
        //演示400、301/302/307重定向、转发
        //模拟方式：请求http://localhost:8080/项目部署名/test?i=
        String i = req.getParameter("i");
        if("1".equals(i)){//重定向
            resp.sendRedirect("index.html");
        }else if("2".equals(i)){//转发
            req.getRequestDispatcher("index.html").forward(req, resp);
        }else {//如果是int，就正常返回，如果不是，返回400
            try {
                Integer.parseInt(i);
                //能够解析为int，正常返回
                pw.println("正确的数值"+i);
            } catch (NumberFormatException e) {
                //非int，返回400
                resp.setStatus(400);
                pw.println("非数值"+i);
            }
        }

        pw.flush();
    }
}
