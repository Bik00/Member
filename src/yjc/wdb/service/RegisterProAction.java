package yjc.wdb.service;

import javax.servlet.http.HttpServletRequest;
import yjc.wdb.View;
import yjc.wdb.db.MemberDAO;
import yjc.wdb.domain.Member;

public class RegisterProAction implements Action {

	@Override
	public View excute(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String phone = req.getParameter("phone");
		
		// ����ڰ� �Է��� ������ ������ Member ��ü�� �����.
		Member m = new Member();
		m.setId(id);
		m.setPasswd(pw);
		m.setPhone(phone);
		// Member ��ü�� ������ ����
		
		// DAO���� DB ����� ��û�Ѵ�.
		MemberDAO dao = MemberDAO.getInstance();
		dao.registerMember(m);
		
		// View ������ �����ؼ� return
		// Controller�� �� View page�� �̵����� �ش�.
		View v = new View();
		v.setViewPageName("result.jsp");
		v.setForward(true);
		return v;
	}

}