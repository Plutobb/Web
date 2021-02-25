package Servlet;

import dao.UserDao;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class userLogin extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password;
        UserDao dao = new UserDao();
        //从request中提取用户的账号和密码
        request.setCharacterEncoding("utf-8");
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        boolean login = dao.login(userName,password);
        response.setContentType("text/html;charSet=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        if (login){
            response.sendRedirect("/myWeb/index2.html");
        }else {
            pw.print("<a>登录失败！</a>");
        }

    }
}
