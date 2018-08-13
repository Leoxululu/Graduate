package com.my.domain;

import java.util.Date;

public class MessageBoard {
	private int id;  
	private String account;
    private String name;  
    private Date uptime;  
    private String title;  
    private String description;  
    public int getId() {  
        return id;  
    }  
    public void setId(int id) {  
        this.id=id;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name=name;  
    }  
   
    public String getTitle() {  
        return title;  
    }  
    public void setTitle(String title) {  
        this.title=title;  
    }  
   
	public Date getUptime() {
		return uptime;
	}
	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}  
}
