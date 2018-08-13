package com.my.dao;

import java.util.List;

import com.my.domain.Upfile;

public interface UpfileDao {

	void add(Upfile upfile);

    // �õ������ϴ��ļ�����Ϣ����Ҫ��ҳ
    List<Upfile> getAll();
    
    List<Upfile> getPerAll(String account);

    Upfile find(String id);

    void delete(String id);

    void update(Upfile upfile);

}