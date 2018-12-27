package com.xtjnoob.service;

import com.xtjnoob.entity.ArticleType;
import com.xtjnoob.entity.User;
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

    @Autowired
    private ArticleTypeDao articleTypeDao;

    @Override
    public List<ArticleType> getAllArticleTypes() {
        return articleTypeDao.getAllArticleTypes();
    }

    @Override
    public Map<String, Object> login(String loginName, String password) {

        Map<String, Object> map = new HashMap<>();

        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)) {
            //账号密码为空了
        } else {
            User user = userDao.getUserByLoginName(loginName);
        }

        return map;
    }
}
