package com.my.serviceimp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.my.domain.MessageBoard;
import com.my.domain.User;
import com.my.service.MesBoardService;
import com.my.utils.JdbcUtils;

public class MesBoardServiceImpl implements MesBoardService{

	@Override
	public List<MessageBoard> getAll() {
		 try {
	            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
	            String sql = "select * from message";
	            return (List<MessageBoard>) runner.query(sql, new BeanListHandler(MessageBoard.class));
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}

	@Override
	public MessageBoard find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MessageBoard mBoard) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addMessage(MessageBoard mBoard) {
		try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into message(name,account,uptime,title,description) values(?,?,?,?,?)";
            Object[] params = {mBoard.getName(),mBoard.getAccount(),mBoard.getUptime(),mBoard.getTitle(),mBoard.getDescription()};
            runner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
	}

}
