package yjc.wdb.service;

import javax.servlet.http.HttpServletRequest;
import yjc.wdb.View;

public class IndexAction implements Action {

	@Override
	public View excute(HttpServletRequest req) throws Exception {

		// View ������ �����ؼ� return
		// Controller�� �� View page�� �̵����� �ش�.
		View v = new View();
		v.setViewPageName("index.jsp");
		v.setForward(true);
		return v;
	}
}