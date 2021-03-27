package frank.servlet;

import frank.dao.UserDao;
import frank.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@WebServlet("/user/login")
public class UserLoginServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");

        boolean isContainsUser = UserDao.login(userName,passWord,req.getServletContext());
        if (isContainsUser){//存在用户的话转到主页
            //存储用户的session信息
            User user = new User(userName,passWord);
            HttpSession session = req.getSession();
            session.setAttribute("user",user);

            Cookie cookie = new Cookie("JSessionID",session.getId());
            resp.addCookie(cookie);
            //进入用界面
            resp.sendRedirect("http://localhost:8080/Blog/jsp/articleList.jsp");
        }else {//不存在提示用户不存在或者密码错误
            resp.setContentType("text/html");
            PrintWriter pw = resp.getWriter();
            pw.print("用户名或密码错误");
            System.out.println("密码错误或者用户不存在!");
        }
        return isContainsUser;
    }
}
