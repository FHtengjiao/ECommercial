package com.xtjnoob.action;

import com.xtjnoob.entity.User;
import com.xtjnoob.service.ShopService;
import com.xtjnoob.util.Constant;
import org.aspectj.weaver.ast.Var;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class LoginServlet extends HttpServlet {

    private ShopService shopService;

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = this.getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        shopService = (ShopService) context.getBean("shopService");
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/toLogin".equals(request.getContextPath())) {
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }

        if ("/login".equals(request.getContextPath())) {
            String loginName = request.getParameter("loginName");
            String password = request.getParameter("passWord");
            Map<String,Object> map = shopService.login(loginName, password);
            if ((int) map.get("code") == 0) {
                User user = (User) map.get("user");
                request.getSession().setAttribute(Constant.SESSION_USER, user);
                request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
            } else {
                String msg = (String)map.get("msg");
                request.setAttribute(Constant.MSG, msg);
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            }
        }
    }
}
