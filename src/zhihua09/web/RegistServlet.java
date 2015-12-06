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
		//У����֤��
		String valicode1= request.getParameter("valicode");
		String valicode2= (String) request.getSession().getAttribute("valicode");
		if(valicode1==null||valicode2==null||!valicode1.endsWith(valicode2)){//��֤�����
			request.setAttribute("msg", "��֤�벻��ȷ");
			request.getRequestDispatcher("/Regist.jsp").forward(request, response);
			return;
		}
		//��װע����Ϣ
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword1(request.getParameter("password1"));
		user.setPassword2(request.getParameter("password2"));
		user.setPhonenumber(request.getParameter("phonenumber"));
		user.setEmail(request.getParameter("email"));
		try {
			//У��ע����Ϣ
			user.checkInfo();
			//У��ͨ��������UserService�з���ע���û�
			UserService service = new UserService();
			service.registUser(user);
			//��½�û�
			request.getSession().setAttribute("user", user);
			//��ʾע��ɹ���3���ص���ҳ
			response.getWriter().write("<div align=&quot center &quot>ע��ɹ���3���ص���ҳ...</div>");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
			
		} catch (MsgException e) {//У�鲻ͨ��
			//�����쳣��Ϣ
			request.setAttribute("msg", e.getMessage());
			//�����ض�����ע��ҳ��
			request.getRequestDispatcher("/Regist.jsp").forward(request, response);
		}
		
		 

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
