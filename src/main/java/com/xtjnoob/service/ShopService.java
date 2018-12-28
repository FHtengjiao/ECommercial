package com.xtjnoob.service;

import com.xtjnoob.entity.Article;
import com.xtjnoob.entity.ArticleType;

import java.util.List;
import java.util.Map;

/**
 * @Author: xtjnoob
 * @Date: 2018/12/27 16:08
 * @Version 1.0
 */
public interface ShopService {

    Map<String, Object> login(String loginName, String password);

    List<ArticleType> getFirstArticleTypes();

    List<Article> getAllArticles();
}
