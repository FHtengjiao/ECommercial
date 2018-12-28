package com.xtjnoob.action;

import com.xtjnoob.entity.Article;
import com.xtjnoob.entity.ArticleType;
import com.xtjnoob.service.ShopService;
import com.xtjnoob.util.Constant;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: xtjnoob
 * @Date: 2018/12/28 13:29
 * @Version 1.0
 */
@WebServlet(name = "HomePageServlet", urlPatterns = "/homepage")
public class HomePageServlet extends HttpServlet {

    private HttpServletRequest request;
    private HttpServletResponse response;

    private ShopService shopService;

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = this.getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        shopService = (ShopService) context.getBean("shopService");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.request = request;
        this.response = response;

        String method = request.getParameter("method");

        List<ArticleType> articleTypes = shopService.getFirstArticleTypes();
        request.setAttribute(Constant.FIRST_TYPES, articleTypes);

        switch (method) {
            case "getAll":
                this.getAll();
                break;
        }
    }

    private void getAll() throws ServletException, IOException {
        List<Article> articles = shopService.getAllArticles();
        request.setAttribute(Constant.ARTICLES, articles);
        request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
    }
}
