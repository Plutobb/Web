package frank.Listener;

import frank.util.DBUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Map<Connection,Boolean> map = new HashMap<>();
        boolean flag  = true;
        for (int i = 0; i < 10; i++) {
            Connection con = DBUtil.getConnection();
            map.put(con,flag);
            System.out.println("链接通道建立!");
            ServletContext context = sce.getServletContext();
            context.setAttribute("key1",map);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("链接通道关闭!");
    }
}
