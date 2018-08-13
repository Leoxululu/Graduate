package com.my.dao;

import java.util.List;

import com.my.domain.User;

public interface UserDao {


    // 得到所有上传文件的信息，需要分页
    List<User> getAll();

    User find(String id);

    boolean deleteUser(String id);

    boolean updateUser(String id);
    
	boolean addUser(String account, String password, String power);
}