package zhihua09.domain;

import zhihua09.exception.MsgException;

public class User {
	private int id ;
	private String username;
	private String password1;
	private String password2;
	private String phonenumber=null;
	private String email=null;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void checkInfo() throws MsgException {
		if(username==null||username=="")
			throw new MsgException("用户名不能为空");
		if(password1==null||password1.equals(""))
			throw new MsgException("密码不能为空");
		if(password2==null||password2.equals(""))
			throw new MsgException("密码不能为空");
		if(!password1.equals(password2))
			throw new MsgException("两次密码不一致");
		if(email==null||email.equals(""))
			throw new MsgException("邮箱不能为空");
		if(!email.matches("^\\w+@\\w+(\\.\\w+)+$"))
			throw new MsgException("邮箱格式不正确");
	}

}
