package com.my.domain;

import java.util.Date;

public class Upfile {

    private String id;
    private String account;
    private String uuidname;  //�ϴ��ļ������ƣ��ļ���uuid��
    private String filename; //�ϴ��ļ�����ʵ����
    private String savepath;     //��ס�ļ���λ��
    private Date uptime;     //�ļ����ϴ�ʱ��
    private String description;  //�ļ�������
    private String username;   //�ϴ���
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUuidname() {
        return uuidname;
    }
    public void setUuidname(String uuidname) {
        this.uuidname = uuidname;
    }
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getSavepath() {
        return savepath;
    }
    public void setSavepath(String savepath) {
        this.savepath = savepath;
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
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

}