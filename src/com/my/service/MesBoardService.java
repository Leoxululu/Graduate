package com.my.service;

import java.util.List;

import com.my.domain.MessageBoard;


public interface MesBoardService {
public List<MessageBoard> getAll();
		
	

    public MessageBoard find(String id);
    	 
    

    public void delete(String id);
    	
    

    public void update(MessageBoard mBoard);
    
    
    public void addMessage(MessageBoard mBoard);
    	
}
