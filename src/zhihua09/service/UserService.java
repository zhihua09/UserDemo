package zhihua09.service;

import zhihua09.dao.UserDao;
import zhihua09.domain.User;
import zhihua09.exception.MsgException;

public class UserService {
	/**
	 * ע���û�
	 * @param user
	 * @throws MsgException
	 */
	public void registUser(User user) throws MsgException{
		UserDao dao = new UserDao();
		//����û����Ƿ��Ѵ���
		String username = user.getUsername();
		User userInDB = dao.findUserByUsername(username);
		if(userInDB!=null){//����������ʾ
			throw new MsgException("�û����Ѵ��ڣ��뻻������");
		}else{//���û��������ڣ�����û�
			dao.addUser(user);
		}
	}

	/**
	 * �ж��û����������Ƿ���ȷ
	 * @param username
	 * @param password
	 * @return ����ȷ�򷵻�null
	 */
	public User isUser(String username ,String password){
		UserDao dao = new UserDao();
		return dao.findUserByUsernameAndPSW(username, password);
	}
}
