package zhihua09.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValiCode extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//֪ͨ�������ֹ����
		response.addDateHeader("Expires", -1);
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");
		//����һ����֤��ͼƬ
		int height = 25;
		int width = 80;
		int x=8;
		int y=21;
		BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//��ȡͼƬ�ϵĻ���
		Graphics2D g =(Graphics2D) img.getGraphics();
		//���ñ���ɫ
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		//���߿�
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width-1, height-1);
		//������
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<4;i++){
			g.setColor(new Color(randNum(0,255),randNum(0,255),randNum(0,255)));
			g.setFont(new Font("����",Font.BOLD,26));
			String s=""+rand.nextInt(10);
			sb.append(s);
			g.drawString(s,i*18+x, y);
		}
		//�����ŵ�
		g.setColor(Color.BLACK);
		for(int i=0;i<200;i++){
			int px=rand.nextInt(80);
			int py=rand.nextInt(25);
			g.drawLine(px, py, px, py);
		}
		request.getSession().setAttribute("valicode", sb.toString());
		//��ͼƬ����������
		ImageIO.write(img, "jpg", response.getOutputStream());
		
	}
	private Random rand = new Random();
	
	private int randNum(int begin,int end){
		return rand.nextInt(end-begin+1)+begin;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
