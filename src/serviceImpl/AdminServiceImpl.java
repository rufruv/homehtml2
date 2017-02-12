package serviceImpl;

import domain.MemberBean;
import java.util.*;
import service.AdminService;

public class AdminServiceImpl implements AdminService{
	private Map<String,MemberBean> map;
	public AdminServiceImpl() {
		map = new HashMap<String,MemberBean>(); 
		}
	@Override
	public void regist(MemberBean member) {
		map.put(member.getId(), member);
	}
	@Override
	public MemberBean findById(String id) {
		/*MemberBean mem = new MemberBean();
		for(MemberBean m:list()){
			if(id.equals(m.getUid())){
				mem = m;
				break;
			}
		}
		return mem;*/
		/*return (map.containsKey(id))?map.get(id):null;*/
		return map.get(id);
	}
	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> listSome = new ArrayList<MemberBean>();
		for(MemberBean m:memberlist()){
			if(name.equals(m.getName())){
				listSome.add(m);
			}
		}
		return listSome;
	}
	@Override
	public List<MemberBean> memberlist() {
		List<MemberBean> list = new ArrayList<MemberBean>();
		for(Map.Entry<String,MemberBean> e:map.entrySet()){
			list.add(e.getValue());
		}
		return list;
	}
	@Override
	public int count() {
		return map.size();
	}
	@Override
	public void update(MemberBean member) {
		for(MemberBean m:memberlist()){
			if(member.getId().equals(m.getId())){
				String a = (member.getName().equals(""))?m.getName():member.getName();
				String b = (member.getPassword().equals(""))?m.getPassword():member.getPassword();
				String c = (member.getProfileImg().equals(""))?m.getProfileImg():member.getProfileImg();
				String d = (member.getPhone().equals(""))?m.getPhone():member.getPhone();
				String e = (member.getEmail().equals(""))?m.getEmail():member.getEmail();
				String f = (member.getRank().equals(""))?m.getRank():member.getRank();
				m.setName(a);
				m.setPassword(b);
				m.setProfileImg(c);
				m.setPhone(d);
				m.setEmail(e);
				m.setRank(f);
				
			}
		}
		
	}
	@Override
	public void remove(String id) {
		map.remove(id);
	}
	@Override
	public Map<String, MemberBean> mapFindByName(String name) {
		Map<String,MemberBean> temp = new HashMap<String,MemberBean>();
		for(Map.Entry<String,MemberBean> e:map.entrySet()){
			if(name.equals(e.getValue().getName())){
				temp.put(e.getKey(), e.getValue());
			}
		}
		return temp;
	}
	
	@Override
	public List<String> keylist() {
		List<String> list = new ArrayList<String>();
		for(Map.Entry<String,MemberBean> e:map.entrySet()){
			list.add(e.getKey());
		}
		return list;
	}
	
}