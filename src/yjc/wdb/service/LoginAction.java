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

		// ����ڰ� �Է��� ������ ������ Member ��ü�� �����.
		Member m = new Member();
		m.setId(id);
		m.setPasswd(password);
		// Member ��ü�� ������ ����
		
		// DAO���� DB ����� ��û�Ѵ�.
		MemberDAO dao = MemberDAO.getInstance();
		int check = dao.loginMember(m);
		
		session.setAttribute("id", id);
		session.setAttribute("check", new Integer(check));

		// View ������ �����ؼ� return
		// Controller�� �� View page�� �̵����� �ش�.
		View v = new View();
		v.setViewPageName("result.jsp");
		v.setForward(true);
		return v;
	}

}