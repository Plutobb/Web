package frank.servlet;

import frank.dao.ArticleDAO;
import frank.model.Article;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//@WebServlet("/articleList")
public class ArticleListServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");//获取前端数据，用户id
        //jdbc操作：查询文章列表（根据用户id查询关联的所有文章）
        List<Article> articles = ArticleDAO.query(Integer.parseInt(id));
        return articles;
    }
}
