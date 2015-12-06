package zhihua09.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	private JDBCUtil(){}
	
	/**
	 * 获取数据库连接
	 * @return Connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConn() throws ClassNotFoundException, SQLException{
		//注册数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
	}
	
	/**
	 * 关闭资源
	 * @param rs
	 * @param stat
	 * @param conn
	 */
	public static void close(ResultSet rs,Statement stat,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs= null;
			}
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				stat = null;
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn=null;
			}
		}
	}
}
