package yjc.wdb.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import yjc.wdb.View;
import yjc.wdb.db.MemberDAO;
import yjc.wdb.domain.Member;

public class LoginAction implements Action {

	@Override
	public View excute(HttpServletRequest req) throws Exception {
		
		String id = req.getParameter("id");
		String password = req.getParameter("pass");
		HttpSession session = req.getSession();

		// 사용자가 입력한 정보를 가지고 Member 객체를 만든다.
		Member m = new Member();
		m.setId(id);
		m.setPasswd(password);
		// Member 객체의 정보를 설정
		
		// DAO에게 DB 등록을 요청한다.
		MemberDAO dao = MemberDAO.getInstance();
		int check = dao.loginMember(m);
		
		session.setAttribute("id", id);
		session.setAttribute("check", new Integer(check));

		// View 페이지 설정해서 return
		// Controller가 그 View page로 이동시켜 준다.
		View v = new View();
		v.setViewPageName("result.jsp");
		v.setForward(true);
		return v;
	}

}