package com.xtjnoob.mapper;

import com.xtjnoob.entity.ArticleType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xtjnoob
 * @Date: 2018/12/27 15:33
 * @Version 1.0
 */

@Repository("articleTypeDao")
public interface ArticleTypeDao {

    @Select("SELECT * FROM `article_type` WHERE length(code) = 4")
    List<ArticleType> searchFirstArticleTypes();
}
