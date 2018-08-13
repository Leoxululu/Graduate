package com.my.serviceimp;

import java.util.List;

import com.factory.DaoFactory;
import com.my.dao.UpfileDao;
import com.my.dao.UserDao;
import com.my.domain.Upfile;
import com.my.domain.User;
import com.my.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {

    private UpfileDao upfiledao = DaoFactory.getInstance().createDao(UpfileDao.class);
    
    private UserDao userdao=DaoFactory.getInstance().createDao(UserDao.class);

    public void addUpfile(Upfile upfile) {
        upfiledao.add(upfile);
    }

    @Override
    public List getAllUpfile() {
       return upfiledao.getAll();
    }
    @Override
	public List getPerUpfile(String account) {
		return upfiledao.getPerAll(account);
	}
    @Override
    public Upfile findUpfile(String id) {
       return upfiledao.find(id);
   }

    /*
     * ɾ���ļ���Ҫɾ��Ӳ���ϵ��ļ�����Ҫ�����ݿ�ļ�¼��ɾ������
     * ����������ɾ����Ҫ����һ���������棬�����ɾ��Ӳ���ϵ��ļ�����ɾ��
     * ���ݿ�ļ�¼�����ǲ��еģ������Ȱ�Ӳ���ϵ��ļ�ɾ���ˣ���������ûɾ���ݿ��¼֮ǰ���쳣�ˣ�
     * ��ôһ�ع����ļ���ɾ�����ǲ��ܻع��ģ����ʱ��������ļ�ɾ���˶����ݿ��¼û��ɾ���������
     * �������ʱ����ɾ����ʱ��һ��Ҫ��ɾ�����ݿ�ļ�¼����ɾ��Ӳ���ϵ��ļ�������
     * �������ĺô���������ݿ�ļ�¼ɾ���ˣ��������쳣�ˣ���ʱ������������棬���쳣�ͻ�ع���
     * �����ݿ�ļ�¼Ҳ��ع���ֻ�����ݿ�ļ�¼ɾ���ˣ�Ӳ���ϵ��ļ�Ҳɾ���ˣ�����ȫ��ɾ���ɹ��ˣ�
     * �ٿ����ύ��ȷ��ɾ�ĸɸɾ�����
     */
    public void deleteUpfile(String id) {
        upfiledao.delete(id);
    }

	
	public List getAllUser() {
		// TODO Auto-generated method stub
		return userdao.getAll();
	}
	

	@Override
	public User findUser(String id) {
		// TODO Auto-generated method stub
		return userdao.find(id);
	}

	public boolean updateUser(String id){
		return userdao.updateUser(id);
		
	}

	@Override
	public boolean deletUser(String id) {
		// TODO Auto-generated method stub
		return userdao.deleteUser(id);
	}

	@Override
	public boolean addUser(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	
}