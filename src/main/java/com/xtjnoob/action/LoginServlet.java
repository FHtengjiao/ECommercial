package com.xtjnoob.action;

import com.xtjnoob.entity.User;
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
import java.util.Map;

@WebServlet(name = "loginServlet", urlPatterns = {"/toLogin", "/login"})
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
        // 跳转登录页
        if ("/toLogin".equals(request.getServletPath())) {
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }

        // 登录操作
        if ("/login".equals(request.getServletPath())) {
            String loginName = request.getParameter("loginName");
            String password = request.getParameter("passWord");
            Map<String,Object> map = shopService.login(loginName, password);
            // code=0,验证通过
            if ((int) map.get("code") == 0) {
                User user = (User) map.get("user");
                request.getSession().setAttribute(Constant.SESSION_USER, user);
                // 做登录后主页显示的数据操作
                response.sendRedirect("/homepage?method=getAll");
                //request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
            } else {
                // code不为零，页面转发至登录页面，并显示错误原因
                String msg = (String)map.get("msg");
                request.setAttribute(Constant.MSG, msg);
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            }
        }
    }
}
