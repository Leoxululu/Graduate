package com.my.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.my.domain.User;
import com.my.utils.JdbcUtils;


public interface UserService {
	public User login(String account,String password,String power) ;
		 
		        
 
	public List<User> getAll();
		
	

    public User find(String id);
    	 
    

    public void delete(String id);
    	
    

    public void update(User user);
    
    
    public void addUser(User user);
    	
 

}
