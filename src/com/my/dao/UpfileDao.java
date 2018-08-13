package com.my.dao;

import java.util.List;

import com.my.domain.Upfile;

public interface UpfileDao {

	void add(Upfile upfile);

    // 得到所有上传文件的信息，需要分页
    List<Upfile> getAll();
    
    List<Upfile> getPerAll(String account);

    Upfile find(String id);

    void delete(String id);

    void update(Upfile upfile);

}