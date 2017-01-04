package yjc.wdb.service;

import javax.servlet.http.HttpServletRequest;

import yjc.wdb.View;

public class ViewAction implements Action {

	@Override
	public View excute(HttpServletRequest req) throws Exception {

		// View 페이지 설정해서 return
		// Controller가 그 View page로 이동시켜 준다.
		View v = new View();
		v.setViewPageName("view.jsp");
		v.setForward(true);
		return v;
	}

}