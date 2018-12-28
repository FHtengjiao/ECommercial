package com.xtjnoob.mapper;

import com.xtjnoob.entity.Article;

import java.util.List;

/**
 * @Author: xtjnoob
 * @Date: 2018/12/27 15:33
 * @Version 1.0
 */
public interface ArticleDao {
    List<Article> getArticle();
}
