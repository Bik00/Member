package yjc.wdb.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import yjc.wdb.View;

public class LogoutAction implements Action {

	@Override
	public View excute(HttpServletRequest req) throws Exception {
		
		HttpSession session = req.getSession();
		session.removeAttribute("id");
		session.invalidate();

		// View 페이지 설정해서 return
		// Controller가 그 View page로 이동시켜 준다.
		View v = new View();
		v.setViewPageName("index.jsp");
		v.setForward(true);
		return v;
	}
}