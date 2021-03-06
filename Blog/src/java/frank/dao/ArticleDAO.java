package frank.dao;

import frank.model.Article;
import frank.util.DBUtil;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class ArticleDAO {

    //-----------------------------------------------------------------------------------------------
    //在这里重写方法,加入数据库连接池;
    public static List<Article> query(int id, ServletContext context) {
        List<Article> articles = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Map map = (Map) context.getAttribute("key1");
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()){
                con = (Connection) iterator.next();
                if ((Boolean) map.get(con)){
                    map.put(con,false);
                    break;
                }
            }
            String sql = "select a.id, a.title, a.content, a.user_id, a.create_time" +
                    " from article a join user u ON a.user_id = u.id where u.id=?";

            //2.创建操作命令对象
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            //3.执行sql
            rs = ps.executeQuery();
            //4.处理结果集
            while(rs.next()){
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
                a.setUserId(id);
                a.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                articles.add(a);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询文章列表出错，一般都是自己sql写错了，或方法调用出错", e);
        } finally {//5.释放资源
            DBUtil.close(con, ps, rs);
        }

        return articles;
    }

    public static int insert(Article article,ServletContext context) {
        Connection c = null;
        PreparedStatement ps = null;
        Map map = (Map) context.getAttribute("key1");
        try {
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()){
                c = (Connection) iterator.next();
                if ((Boolean) map.get(c)){
                    map.put(c,false);
                    break;
                }
            }
            String sql = "insert into article(title,content,user_id,create_time)" +
                    " values (?,?,?,now())";

            //2.创建操作命令对象
            ps = c.prepareStatement(sql);
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, 1);//写死用户id
            //3.执行sql
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("插入文章出错，一般都是自己sql写错了，或方法调用出错", e);
        } finally {//5.释放资源
            map.put(c,true);
        }
    }


    public static Article queryById(int id,ServletContext context) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map map = (Map) context.getAttribute("key1");
        try {
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()){
                c = (Connection) iterator.next();
                if ((Boolean) map.get(c)){
                    map.put(c,false);
                    break;
                }
            }
            String sql = "select a.id, a.title, a.content, a.user_id, a.create_time" +
                    " from article a where a.id=?";

            //2.创建操作命令对象
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            //3.执行sql
            rs = ps.executeQuery();
            //4.处理结果集
            while(rs.next()){
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
                a.setUserId(id);
                a.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                return a;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("查询文章详情出错，一般都是自己sql写错了，或方法调用出错", e);
        } finally {//5.释放资源
            map.put(c,true);
        }
    }

    public static int update(Article article,ServletContext context) {
        Connection c = null;
        PreparedStatement ps = null;
        Map map = (Map) context.getAttribute("key1");
        try {
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()){
                c = (Connection) iterator.next();
                if ((Boolean) map.get(c)){
                    map.put(c,false);
                    break;
                }
            }
            String sql = "update article set title=?,content=? where id=?";

            //2.创建操作命令对象
            ps = c.prepareStatement(sql);
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, article.getId());//写死用户id
            //3.执行sql
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("修改文章出错，一般都是自己sql写错了，或方法调用出错", e);
        } finally {//5.释放资源
            map.put(c,true);
        }
    }

    public static int delete(int[] ids,ServletContext context) {
        Connection c = null;
        PreparedStatement ps = null;
        Map map = (Map) context.getAttribute("key1");
        try {
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()){
                c = (Connection) iterator.next();
                if ((Boolean) map.get(c)){
                    map.put(c,false);
                    break;
                }
            }
            StringBuilder sql = new StringBuilder("delete from article where id in (");
            for(int i=0; i<ids.length; i++){//通过传入的int数组动态生成带占位符的sql
                if(i==0){
                    sql.append("?");//开始不加,
                }else{
                    sql.append(",?");
                }
            }
            sql.append(")");

            //2.创建操作命令对象
            ps = c.prepareStatement(sql.toString());
            for(int i=0; i<ids.length; i++){
                ps.setInt(i+1, ids[i]);
            }
            //3.执行sql
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("删除文章出错，一般都是自己sql写错了，或方法调用出错", e);
        } finally {//5.释放资源
            map.put(c,true);
        }
    }




    //-----------------------------------------------------------------------------------------------

    public static List<Article> query(int id) {
        List<Article> articles = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1.获取数据库连接
            c = DBUtil.getConnection();
            //注意事项：
            // sql需要空格的地方一定要保留
            // 占位符设值都是从1开始
            // 结果集表头字段和获取的字段名要一致，类型也要一直
            String sql = "select a.id, a.title, a.content, a.user_id, a.create_time" +
                    " from article a join user u ON a.user_id = u.id where u.id=?";

            //2.创建操作命令对象
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            //3.执行sql
            rs = ps.executeQuery();
            //4.处理结果集
            while(rs.next()){
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
                a.setUserId(id);
                a.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                articles.add(a);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询文章列表出错，一般都是自己sql写错了，或方法调用出错", e);
        } finally {//5.释放资源
            DBUtil.close(c, ps, rs);
        }

        return articles;
    }

    public static int insert(Article article) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            String sql = "insert into article(title,content,user_id,create_time)" +
                    " values (?,?,?,now())";

            //2.创建操作命令对象
            ps = c.prepareStatement(sql);
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, 1);//写死用户id
            //3.执行sql
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("插入文章出错，一般都是自己sql写错了，或方法调用出错", e);
        } finally {//5.释放资源
            DBUtil.close(c, ps);
        }
    }

    public static Article queryById(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select a.id, a.title, a.content, a.user_id, a.create_time" +
                    " from article a where a.id=?";

            //2.创建操作命令对象
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            //3.执行sql
            rs = ps.executeQuery();
            //4.处理结果集
            while(rs.next()){
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
                a.setUserId(id);
                a.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                return a;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("查询文章详情出错，一般都是自己sql写错了，或方法调用出错", e);
        } finally {//5.释放资源
            DBUtil.close(c, ps, rs);
        }
    }

    public static int update(Article article) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            String sql = "update article set title=?,content=? where id=?";

            //2.创建操作命令对象
            ps = c.prepareStatement(sql);
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, article.getId());//写死用户id
            //3.执行sql
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("修改文章出错，一般都是自己sql写错了，或方法调用出错", e);
        } finally {//5.释放资源
            DBUtil.close(c, ps);
        }
    }

    public static int delete(int[] ids) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            StringBuilder sql = new StringBuilder("delete from article where id in (");
            for(int i=0; i<ids.length; i++){//通过传入的int数组动态生成带占位符的sql
                if(i==0){
                    sql.append("?");//开始不加,
                }else{
                    sql.append(",?");
                }
            }
            sql.append(")");

            //2.创建操作命令对象
            ps = c.prepareStatement(sql.toString());
            for(int i=0; i<ids.length; i++){
                ps.setInt(i+1, ids[i]);
            }
            //3.执行sql
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("删除文章出错，一般都是自己sql写错了，或方法调用出错", e);
        } finally {//5.释放资源
            DBUtil.close(c, ps);
        }
    }
}
