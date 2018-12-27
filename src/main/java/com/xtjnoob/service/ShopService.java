package com.xtjnoob.service;

import com.xtjnoob.entity.ArticleType;

import java.util.List;
import java.util.Map;

/**
 * @Author: xtjnoob
 * @Date: 2018/12/27 16:08
 * @Version 1.0
 */
public interface ShopService {

    List<ArticleType> getAllArticleTypes();

    Map<String, Object> login(String loginName, String password);

}
