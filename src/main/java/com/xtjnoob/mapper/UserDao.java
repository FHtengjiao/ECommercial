package com.xtjnoob.mapper;

import com.xtjnoob.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: xtjnoob
 * @Date: 2018/12/27 15:26
 * @Version 1.0
 */
public interface UserDao {

    @Select("SELECT * FROM `user` WHERE login_name = #{loginName}")
    User getUserByLoginName(String loginName);
}
