import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class beginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,balance;
        userName = request.getParameter("userName");
        balance = request.getParameter("balance");

        Cookie card1 = new Cookie("userName",userName);
        Cookie card2 = new Cookie("balance",balance);

        response.addCookie(card1);
        response.addCookie(card2);

        request.getRequestDispatcher("/myWeb/index2.html").forward(request,response);
    }
}
