package zhihua09.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import zhihua09.domain.User;
import zhihua09.util.JDBCUtil;

public class UserDao {
	/**
	 * 向数据库添加用户
	 * @param user
	 */
	public void addUser(User user){
		String sql ="insert into user values(null,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//获取连接
			conn = JDBCUtil.getConn();
			//获取预编译传输器对象
			ps = conn.prepareStatement(sql);
			//添加参数后，插入记录
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword1());
			ps.setString(3, user.getPhonenumber());
			ps.setString(4, user.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//关闭资源
			JDBCUtil.close(rs, ps, conn);
		}
	}
	
	/**
	 * 根据用户、密码查找用户
	 * @param username
	 * @return
	 */
	public User findUserByUsernameAndPSW(String username,String password){
		String sql="select * from user where username=? and password =?";
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn=JDBCUtil.getConn();
			ps= conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs= ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword1(rs.getString("password"));
				user.setPhonenumber(rs.getString("phonenumber"));
				user.setEmail(rs.getString("email"));
				return user;
			}else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
	}
	
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public User findUserByUsername(String username){
		String sql="select * from user where username=?";
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn=JDBCUtil.getConn();
			ps= conn.prepareStatement(sql);
			ps.setString(1, username);
			rs= ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword1(rs.getString("password"));
				user.setPhonenumber(rs.getString("phonenumber"));
				user.setEmail(rs.getString("email"));
				return user;
			}else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
	}
}
