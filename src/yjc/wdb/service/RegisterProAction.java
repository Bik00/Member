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
		
		// 사용자가 입력한 정보를 가지고 Member 객체를 만든다.
		Member m = new Member();
		m.setId(id);
		m.setPasswd(pw);
		m.setPhone(phone);
		// Member 객체의 정보를 설정
		
		// DAO에게 DB 등록을 요청한다.
		MemberDAO dao = MemberDAO.getInstance();
		dao.registerMember(m);
		
		// View 페이지 설정해서 return
		// Controller가 그 View page로 이동시켜 준다.
		View v = new View();
		v.setViewPageName("result.jsp");
		v.setForward(true);
		return v;
	}

}