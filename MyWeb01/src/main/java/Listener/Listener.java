package Listener;

import util.DBUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class Listener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Map<Connection, Boolean> map = new HashMap();
        Boolean flag = true;
        for (int i = 0; i < 20; i++) {
            Connection con = DBUtil.getConnection();
            System.out.println("链接通道建立" + con);
            map.put(con,flag);
        }
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("key1",map);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("链接通道关闭!");
    }
}
