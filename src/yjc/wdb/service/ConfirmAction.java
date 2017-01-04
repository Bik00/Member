package yjc.wdb.service;

import javax.servlet.http.HttpServletRequest;

import yjc.wdb.View;
import yjc.wdb.db.MemberDAO;
import yjc.wdb.domain.Member;

public class ConfirmAction implements Action {

	@Override
	public View excute(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");


		//id�� ����ڰ� ȸ�������� �ϱ� ���ؼ� �Է��� ���̵�
		String id= req.getParameter("id");
		
		// ����ڰ� �Է��� ������ ������ Member ��ü�� �����.
		Member m = new Member();
		m.setId(id);
		
		// Member ��ü�� ������ ����
		
		// DAO���� DB ����� ��û�Ѵ�.
		MemberDAO dao = MemberDAO.getInstance();
		int x = dao.confirmMember(m);
		req.setAttribute("check", x);

		// View ������ �����ؼ� return
		// Controller�� �� View page�� �̵����� �ش�.
		View v = new View();
		v.setViewPageName("result.jsp");
		v.setForward(true);
		return v;
	}

}