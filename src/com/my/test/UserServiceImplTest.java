package com.my.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Before;
import org.junit.Test;

import com.my.domain.User;
import com.my.utils.JdbcUtils;

public class UserServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetAll() {
		 try {
	            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
	            String sql = "select * from user";
	           List<User> user= (List<User>) runner.query(sql, new BeanListHandler(User.class));
	           assertNotNull(user);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
		
	}

	@Test
	public void testFind() {
		try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            
            String sql = "select * from user where id=1";
            User user=(User) runner.query(sql, new BeanHandler(User.class));
            assertNotNull(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

	@Test
	public void testDelete() {
		try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "delete from user where id=1";
            assertNotNull(runner.update(sql));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	

	@Test
	public void testLogin() {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());//获取连接

        //String sql="select * from user WHERE username=? and password=?";

        String sql="select * from user where account = 1 and password = 1 and power= 1";
        User user=null;
		try {
			user = (User) qr.query(sql, new BeanHandler(User.class));
			assertNotNull(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	@Test
	public void testAddUser() {
		try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into user(account,password,username,academy,major,birthday,power) values(5,5,5,5,5,5,3)";
            assertNotNull(runner.update(sql));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

}
