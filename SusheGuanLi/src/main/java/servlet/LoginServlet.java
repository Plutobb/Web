package servlet;

import Dao.UserDao;
import model.User;
import util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/login")
public class LoginServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = JSONUtil.read(req.getInputStream(),User.class);
        User queryUser = UserDao.query(user);
        if (queryUser == null){
            System.out.println("账号或密码错误!");
        }
        HttpSession session = req.getSession();
        session.setAttribute("user",queryUser);
        return null;
    }
}
