package yjc.wdb.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import yjc.wdb.View;
import yjc.wdb.db.MemberDAO;
import yjc.wdb.domain.Member;

public class DeleteAction implements Action {

	@Override
	public View excute(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		
		// ����ڰ� �Է��� ������ ������ Member ��ü�� �����.
		Member m = new Member();
		m.setId(id);
		
		// Member ��ü�� ������ ����
		
		// DAO���� DB ����� ��û�Ѵ�.
		MemberDAO dao = MemberDAO.getInstance();
		dao.deleteMember(m);
		
		// View ������ �����ؼ� return
		// Controller�� �� View page�� �̵����� �ش�.
		View v = new View();
		v.setViewPageName("index.jsp");
		v.setForward(true);
		return v;
	}

}