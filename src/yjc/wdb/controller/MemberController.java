package yjc.wdb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yjc.wdb.View;
import yjc.wdb.service.Action;
import yjc.wdb.service.IndexAction;
import yjc.wdb.service.RegisterProAction;
import yjc.wdb.service.RegisterAction;
import yjc.wdb.service.DeleteAction;
import yjc.wdb.service.ViewAction;
import yjc.wdb.service.ConfirmAction;
import yjc.wdb.service.LoginAction;
import yjc.wdb.service.LogoutAction;
/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*doGet(request, response);*/
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��û ���� �м��Ѵ�.
		// �� ��û�� ó���� Business Logic ��ü�� �����Ѵ�.
		// �� ��ü�� execute �޼ҵ带 ȣ���Ѵ�.
		// execute �޼ҵ尡 ��ȯ�� View ��ü�� �м��Ѵ�.
		// View ��ü�� ������ page�� forward �Ǵ� redirection �Ѵ�.
		
		String uri = request.getRequestURI();
		/*System.out.println("URI:"+uri);*/
		
		String context = request.getContextPath();
/*		System.out.println("Context:"+context);
		System.out.println("����:"+context.length());*/
		
		String command = uri.substring(context.length()+1);
/*		System.out.println("command:"+command);*/
		View view = null;
		
		if(command.equals("index.do")) {
			Action action = new IndexAction();
			try {
				view = action.excute(request);				
			} catch(Exception e) {
				e.printStackTrace();
			}			
		}
		else if(command.equals("register.do")) {
			Action action = new RegisterAction();
			try {
				view = action.excute(request);				
			} catch(Exception e) {
				e.printStackTrace();
			}			
		}
		else if(command.equals("registerPro.do")) {
			//ȸ����� �����Ͻ� ������ ó���ϴ� ��ü �����ؼ�
			//excute
			Action action = new RegisterProAction();
			try {
				view = action.excute(request);				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("confirm.do")) {
			Action action = new ConfirmAction();
			try {
				view = action.excute(request);				
			} catch(Exception e) {
				e.printStackTrace();
			}			
		}
		else if(command.equals("login.do")) {
			Action action = new LoginAction();
			try {
				view = action.excute(request);				
			} catch(Exception e) {
				e.printStackTrace();
			}			
		}
		else if(command.equals("delete.do")) {
			//ȸ�������ϴ� �����Ͻ� ������ ó���ϴ� ��ü �����ؼ�
			//excute
			Action action = new DeleteAction();		
			try {
				view = action.excute(request);				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("view.do")){
			//ȸ�� ��ȸ�ϴ� �����Ͻ� ������ ó���ϴ� ��ü �����ؼ�
			//excute
			Action action = new ViewAction();		
			try {
				view = action.excute(request);				
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("logout.do")){
			//ȸ�� ��ȸ�ϴ� �����Ͻ� ������ ó���ϴ� ��ü �����ؼ�
			//excute
			Action action = new LogoutAction();		
			try {
				view = action.excute(request);				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("update.do")) {
			
		}
		else {
			
		}
		/* ... */
		
		/* view ��ü �м��ؼ� �ش� view page�� forward �Ǵ� redirection */
		if(view != null) {
			String pageName = view.getViewPageName();
			RequestDispatcher rd = request.getRequestDispatcher(pageName);
			if(view.isForward()) {
				rd.forward(request, response);
			} else {
				// result.jsp
				response.sendRedirect(pageName);
			}
		} else {
			//error page ���� �� ������ ������ �ϴ���..
		}
	}
}
