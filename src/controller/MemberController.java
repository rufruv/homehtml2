package controller;

import domain.MemberBean;
import service.MemberService;
import serviceImpl.MemberServiceImpl;

public class MemberController {
	MemberService service;

	public MemberController() {
		service = new MemberServiceImpl();
	}
}