package com.my.Daoimp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.my.dao.UserDao;
import com.my.domain.User;
import com.my.utils.JdbcUtils;

public class UserDaoImpl implements UserDao{

    // 得到所有上传文件的信息，需要分页
    public List<User> getAll() {

        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from user ";
            return (List<User>) runner.query(sql, new BeanListHandler(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public User find(String id) {

        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from user where id=?";
            return (User) runner.query(sql, id, new BeanHandler(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

	@Override
	public boolean deleteUser(String id) {
		try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "delete * from user where id=?";
            runner.update(sql);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public boolean updateUser(String id) {
		try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "update * from user where id=?";
            runner.update(sql);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public boolean addUser(String account, String password, String power) {
		try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql =  "insert into user values(account,password,power)"; 
            runner.update(sql);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

}
