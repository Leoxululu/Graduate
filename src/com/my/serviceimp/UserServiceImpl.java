package com.my.serviceimp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.my.domain.User;
import com.my.service.UserService;
import com.my.utils.JdbcUtils;

public class UserServiceImpl implements UserService{

	public List<User> getAll(){
		 try {
	            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
	            String sql = "select * from user";
	            return (List<User>) runner.query(sql, new BeanListHandler(User.class));
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}
	public User find(String id){
		 try {
             QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
             String sql = "select * from user where id=?";
             return (User) runner.query(sql, id, new BeanHandler(User.class));
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
	}
	public void delete(String id){
		try {
			Object[] params = {id};
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "delete from user where id=?";
            runner.update(sql,params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	 }

	public void update(User user){
	    	
	}
	public User login(String account, String password, String power) {

        QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());//获取连接

        //String sql="select * from user WHERE username=? and password=?";

        String sql="select * from user where account = ? and password = ? and power= ?";
        User user=null;
		try {
			user = (User) qr.query(sql, new BeanHandler(User.class),account,password,power);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return user;
	}
	@Override
	public void addUser(User user) {
		try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into user(account,password,username,academy,major,birthday,power) values(?,?,?,?,?,?,?)";
            Object[] params = {user.getAccount(),user.getPassword(),user.getUsername(),user.getAcademy(),user.getMajor(),user.getBirthday(),user.getPower()};
            runner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
	}
}
