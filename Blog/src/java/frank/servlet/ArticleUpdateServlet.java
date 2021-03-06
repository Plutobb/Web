package frank.servlet;

import frank.model.Article;
import frank.util.JSONUtil;
import frank.dao.ArticleDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Article article = JSONUtil.deserialize(req.getInputStream(), Article.class);
        int num = ArticleDAO.update(article,req.getServletContext());
        if(num != 1)
            throw new RuntimeException("修改文章数量异常");
        return null;
    }
}
