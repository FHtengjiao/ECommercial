package com.xtjnoob.service;

import com.xtjnoob.entity.Article;
import com.xtjnoob.entity.ArticleType;
import com.xtjnoob.entity.User;
import com.xtjnoob.mapper.ArticleDao;
import com.xtjnoob.mapper.ArticleTypeDao;
import com.xtjnoob.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xtjnoob
 * @Date: 2018/12/27 16:08
 * @Version 1.0
 */

@Service("shopService")
public class ShopServiceImpl implements ShopService {

    @Resource
    private UserDao userDao;

    @Resource
    private ArticleDao articleDao;

    @Autowired
    private ArticleTypeDao articleTypeDao;

    @Override
    public Map<String, Object> login(String loginName, String password) {

        Map<String, Object> map = new HashMap<>();

        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)) {
            //账号密码为空了
            map.put("code", 1);
            map.put("msg", "账号密码空了！");
        } else {
            User user = userDao.getUserByLoginName(loginName);
            if (user == null) {
                // 没有该账号
                map.put("code", 2);
                map.put("msg", "没有该账号！");
            } else {
                if (!user.getPassword().equals(password)) {
                    // 密码错误
                    map.put("code", 3);
                    map.put("msg", "密码错误！");
                } else {
                    // 登录认证成功，返回用户
                    map.put("code", 0);
                    map.put("user", user);
                }
            }
        }

        return map;
    }

    @Override
    public List<ArticleType> getFirstArticleTypes() {
        return articleTypeDao.searchFirstArticleTypes();
    }

    @Override
    public List<Article> getAllArticles() {
        return articleDao.getArticle();
    }
}
