package com.xtjnoob.service;

import com.xtjnoob.entity.ArticleType;
import com.xtjnoob.mapper.ArticleTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xtjnoob
 * @Date: 2018/12/27 16:08
 * @Version 1.0
 */

@Service("shopService")
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ArticleTypeDao articleTypeDao;

    @Override
    public List<ArticleType> getAllArticleTypes() {
        return articleTypeDao.getAllArticleTypes();
    }
}
