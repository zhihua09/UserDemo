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
		//��ȡ�û�������û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//����UserService�еķ�������û���������
		UserService service = new UserService();
		User user = service.isUser(username, password);
		if(user==null){//�û��������벻��ȷ
			//��ʾ������Ϣ
			request.setAttribute("msg", "�û������벻��ȷ");
			//����ת������¼ҳ��
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}else{//�û�����������ȷ
			//���û���Ϣ���浽session��
			request.getSession().setAttribute("user", user);
			//�ض�������ҳ
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
