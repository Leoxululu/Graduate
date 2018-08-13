package com.my.dao;

import java.util.List;

import com.my.domain.MessageBoard;


public interface MesBoardDao {
	List<MessageBoard> getAll();

    MessageBoard find(String id);

    boolean deleteMessage(String id);

    boolean updateMessage(String id);
    
	boolean addMessage(String account, String password, String power);
}
