package com.my.dao;

import java.util.List;

import com.my.domain.User;

public interface UserDao {


    // �õ������ϴ��ļ�����Ϣ����Ҫ��ҳ
    List<User> getAll();

    User find(String id);

    boolean deleteUser(String id);

    boolean updateUser(String id);
    
	boolean addUser(String account, String password, String power);
}