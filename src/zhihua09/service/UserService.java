package zhihua09.service;

import zhihua09.dao.UserDao;
import zhihua09.domain.User;
import zhihua09.exception.MsgException;

public class UserService {
	/**
	 * 注册用户
	 * @param user
	 * @throws MsgException
	 */
	public void registUser(User user) throws MsgException{
		UserDao dao = new UserDao();
		//检查用户名是否已存在
		String username = user.getUsername();
		User userInDB = dao.findUserByUsername(username);
		if(userInDB!=null){//若存在则提示
			throw new MsgException("用户名已存在，请换个试试");
		}else{//若用户名不存在，添加用户
			dao.addUser(user);
		}
	}

	/**
	 * 判断用户名、密码是否正确
	 * @param username
	 * @param password
	 * @return 不正确则返回null
	 */
	public User isUser(String username ,String password){
		UserDao dao = new UserDao();
		return dao.findUserByUsernameAndPSW(username, password);
	}
}
