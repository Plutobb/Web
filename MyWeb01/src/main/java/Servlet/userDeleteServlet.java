package Servlet;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class userDeleteServlet extends HttpServlet {

    @lombok.SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();

        String userId = request.getParameter("userId");

        int rs = dao.delete(Integer.parseInt(userId));

        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        if (rs == 0){
            pw.print("<a>用户信息删除失败！</a>");
        }else {
            pw.print("<a>用户信息删除chenggong！</a>");
        }
    }
}
