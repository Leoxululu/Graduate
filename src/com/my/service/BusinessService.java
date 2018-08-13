package com.my.service;

import java.util.List;

import com.my.domain.Upfile;
import com.my.domain.User;

public interface BusinessService {
	//对file的处理
	void addUpfile(Upfile upfile);
	void deleteUpfile(String id);
    List getAllUpfile();
    List getPerUpfile(String account);
    Upfile findUpfile(String id);
    //对User的处理
     public List getAllUser();
     public boolean addUser(String id);
     public boolean deletUser(String id);
     public boolean updateUser(String  id);
     public User findUser(String id);
    

}