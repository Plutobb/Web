import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class endServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=null,balance = null,choice;
        Cookie[] set = request.getCookies();
        for (Cookie cookie : set){
            if ("userName".equals(cookie.getName())){
                userName = cookie.getValue();
            }else if ("balance".equals(cookie.getName())){
                balance = cookie.getValue();
            }
        }

        System.out.println(userName);
        System.out.println(balance);

        System.out.println(balance + "1" );

        Cookie card = new Cookie("balance","20");
        response.addCookie(card);

    }
}
