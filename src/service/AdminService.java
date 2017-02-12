package service;

import domain.MemberBean;
import java.util.*;

public interface AdminService {
	/**
	 * CREATE: INSERT 
	 */
	public void regist(MemberBean member);  // 저장할때는 Map! (빠른 검색을 위해)
	/**
	 * READ: SELECT
	 */
	public MemberBean findById(String id);  // 전송은 ArrayList로! 
	public List<MemberBean> findByName(String name);
	public Map<String,MemberBean> mapFindByName(String name);
	public List<MemberBean> memberlist();
	public List<String> keylist();
	public int count();
	/**
	 * UPDATE: UPDATE
	 */
	public void update(MemberBean member);
	/**
	 * DELETE: DELETE
	 */
	public void remove(String id);
	
}