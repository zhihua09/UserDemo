package zhihua09.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhihua09.domain.User;
import zhihua09.service.UserService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取用户输入的用户名、密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//调用UserService中的方法检查用户名、密码
		UserService service = new UserService();
		User user = service.isUser(username, password);
		if(user==null){//用户名、密码不正确
			//提示错误消息
			request.setAttribute("msg", "用户名密码不正确");
			//请求转发至登录页面
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}else{//用户名、密码正确
			//将用户信息保存到session中
			request.getSession().setAttribute("user", user);
			//重定向至主页
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
