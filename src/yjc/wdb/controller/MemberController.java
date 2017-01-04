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
		// 요청 정보 분석한다.
		// 그 요청을 처리할 Business Logic 객체를 생성한다.
		// 그 객체에 execute 메소드를 호출한다.
		// execute 메소드가 반환한 View 객체를 분석한다.
		// View 객체에 설정된 page로 forward 또는 redirection 한다.
		
		String uri = request.getRequestURI();
		/*System.out.println("URI:"+uri);*/
		
		String context = request.getContextPath();
/*		System.out.println("Context:"+context);
		System.out.println("길이:"+context.length());*/
		
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
			//회원등록 비지니스 로직을 처리하는 객체 생성해서
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
			//회원삭제하는 비지니스 로직을 처리하는 객체 생성해서
			//excute
			Action action = new DeleteAction();		
			try {
				view = action.excute(request);				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("view.do")){
			//회원 조회하는 비지니스 로직을 처리하는 객체 생성해서
			//excute
			Action action = new ViewAction();		
			try {
				view = action.excute(request);				
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("logout.do")){
			//회원 조회하는 비지니스 로직을 처리하는 객체 생성해서
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
		
		/* view 객체 분석해서 해당 view page로 forward 또는 redirection */
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
			//error page 만들어서 그 쪽으로 포워딩 하던지..
		}
	}
}
