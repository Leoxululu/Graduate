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
     * 删除文件，要删除硬盘上的文件，还要把数据库的记录给删除掉，
     * 而且这两个删除还要做到一个事务里面，如果先删除硬盘上的文件，再删除
     * 数据库的记录，这是不行的，假设先把硬盘上的文件删掉了，接下来，没删数据库记录之前抛异常了，
     * 那么一回滚，文件被删除了是不能回滚的，这个时候出现了文件删掉了而数据库记录没有删掉的情况，
     * 所以这个时候做删除的时候，一定要先删除数据库的记录，再删除硬盘上的文件！！！
     * 这样做的好处：如果数据库的记录删除了，下面抛异常了，这时候放在事务里面，抛异常就会回滚，
     * 那数据库的记录也会回滚，只有数据库的记录删除了，硬盘上的文件也删除了，整个全部删除成功了，
     * 再考虑提交，确保删的干干净净。
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