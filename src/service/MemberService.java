package service;

import domain.MemberBean;

public interface MemberService {
	public void join(MemberBean member) throws Exception;
	public MemberBean findById(String id) throws Exception;
	public boolean login(MemberBean member) throws Exception;
	public void change(MemberBean member) throws Exception;
	public void remove(MemberBean member) throws Exception;
}