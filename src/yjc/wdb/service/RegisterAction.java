package yjc.wdb.service;

import javax.servlet.http.HttpServletRequest;
import yjc.wdb.View;

public class RegisterAction implements Action {

	@Override
	public View excute(HttpServletRequest req) throws Exception {
		
		// View ������ �����ؼ� return
		// Controller�� �� View page�� �̵����� �ش�.
		View v = new View();
		v.setViewPageName("register.jsp");
		v.setForward(true);
		return v;
	}

}