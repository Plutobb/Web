package Servlet;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class userFind extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao dao = new UserDao();

        List<User> rs = dao.find();
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        for (User user : rs){
            pw.print("用户id："+user.getId()+"&nbsp");
            pw.print("用户账号："+user.getName()+"&nbsp");
            pw.print("用户密码："+user.getPassword()+"&nbsp");
            pw.print("<a href='/myWeb/user/delete?&userId="+user.getId()+"'>删除用户</a>");
            pw.print("</br>");
        }
    }
}
