package zhihua09.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhihua09.domain.User;
import zhihua09.exception.MsgException;
import zhihua09.service.UserService;

public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//校验验证码
		String valicode1= request.getParameter("valicode");
		String valicode2= (String) request.getSession().getAttribute("valicode");
		if(valicode1==null||valicode2==null||!valicode1.endsWith(valicode2)){//验证码错误
			request.setAttribute("msg", "验证码不正确");
			request.getRequestDispatcher("/Regist.jsp").forward(request, response);
			return;
		}
		//封装注册信息
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword1(request.getParameter("password1"));
		user.setPassword2(request.getParameter("password2"));
		user.setPhonenumber(request.getParameter("phonenumber"));
		user.setEmail(request.getParameter("email"));
		try {
			//校验注册信息
			user.checkInfo();
			//校验通过，调用UserService中方法注册用户
			UserService service = new UserService();
			service.registUser(user);
			//登陆用户
			request.getSession().setAttribute("user", user);
			//提示注册成功，3秒后回到主页
			response.getWriter().write("<div align=&quot center &quot>注册成功，3秒后回到主页...</div>");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
			
		} catch (MsgException e) {//校验不通过
			//保存异常信息
			request.setAttribute("msg", e.getMessage());
			//请求重定向至注册页面
			request.getRequestDispatcher("/Regist.jsp").forward(request, response);
		}
		
		 

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
