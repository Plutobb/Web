package Servlet;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class user_Add extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建数据访问层
        UserDao userDao = new UserDao();

        //创建用户
        String userName,passWord;
        User user = null;
        userName = request.getParameter("userName");
        passWord = request.getParameter("passWord");
        user = new User(null,userName,passWord);

        ServletContext context = request.getServletContext();
        int  result = userDao.add(user,context);
        response.setContentType("Text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        if (result == 0){
            pw.print("用户注册失败!");
        }else {
            pw.print("用户注册成功!");
        }
    }

}
