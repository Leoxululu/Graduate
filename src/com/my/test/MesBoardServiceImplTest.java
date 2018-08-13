package com.my.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Before;
import org.junit.Test;

import com.my.domain.MessageBoard;
import com.my.utils.JdbcUtils;

public class MesBoardServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetAll() {
		 try {
	            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
	            String sql = "select * from message";
	            List<MessageBoard> list= (List<MessageBoard>) runner.query(sql, new BeanListHandler(MessageBoard.class));
	            assertNotNull(list);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}


	@Test
	public void testAddMessage() {
		try {
			
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into message(name,account,uptime,title,description) values(1,1,1,1,1)";
            runner.update(sql);
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

}
