package yjc.wdb.service;

import javax.servlet.http.HttpServletRequest;

import yjc.wdb.View;

public interface Action {

	public View excute(HttpServletRequest req) throws Exception ;
	
}