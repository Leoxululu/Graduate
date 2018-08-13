package com.my.Daoimp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.my.dao.UpfileDao;
import com.my.domain.Upfile;
import com.my.utils.JdbcUtils;



public class UpfileDaoImpl implements UpfileDao {

	public void add(Upfile upfile) {

        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into upfile(id,account,uuidname,filename,savepath,uptime,description,username) values(?,?,?,?,?,?,?,?)";
            Object[] params = {upfile.getId(),upfile.getAccount(),upfile.getUuidname(),upfile.getFilename(),upfile.getSavepath(),upfile.getUptime(),upfile.getDescription(),upfile.getUsername()};
            runner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // 得到所有上传文件的信息，需要分页
    @Override
    public List<Upfile> getAll() {

        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from upfile order by uptime desc";
            return (List<Upfile>) runner.query(sql, new BeanListHandler(Upfile.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
	public List<Upfile> getPerAll(String account) {
		try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from upfile where account=?";
            return (List<Upfile>) runner.query(sql, account, new BeanListHandler(Upfile.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

	}

    @Override
    public Upfile find(String id) {

        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from upfile where id=?";
            return (Upfile) runner.query(sql, id, new BeanHandler(Upfile.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(String id) {
    	try {
			Object[] params = {id};
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "delete from upfile where id=?";
            runner.update(sql,params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Upfile upfile) {

    }

	


}
