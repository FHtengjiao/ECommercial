package com.xtjnoob.action;

import com.xtjnoob.entity.ArticleType;
import com.xtjnoob.service.ShopService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: xtjnoob
 * @Date: 2018/12/27 16:08
 * @Version 1.0
 */

@WebServlet(name = "shopServlet", urlPatterns = "/shop.do")
public class ShopServlet extends HttpServlet {

    private ShopService shopService;

    @Override
    public void init() throws ServletException {
//        ServletContext servletContext = this.getServletContext();
//        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
//        shopService = (ShopService) context.getBean("shopService");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        shopService = (ShopService) applicationContext.getBean("shopService");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ArticleType> allArticleTypes = shopService.getAllArticleTypes();
        for (ArticleType articleType : allArticleTypes) {
            System.out.println(articleType);
        }
        request.setAttribute("list", allArticleTypes);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
