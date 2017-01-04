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
		
		// 사용자가 입력한 정보를 가지고 Member 객체를 만든다.
		Member m = new Member();
		m.setId(id);
		
		// Member 객체의 정보를 설정
		
		// DAO에게 DB 등록을 요청한다.
		MemberDAO dao = MemberDAO.getInstance();
		dao.deleteMember(m);
		
		// View 페이지 설정해서 return
		// Controller가 그 View page로 이동시켜 준다.
		View v = new View();
		v.setViewPageName("index.jsp");
		v.setForward(true);
		return v;
	}

}