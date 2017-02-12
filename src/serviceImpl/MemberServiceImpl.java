package serviceImpl;

import dao.MemberDao;
import daoImpl.MemberDaoImpl;
import domain.MemberBean;
import service.MemberService;

public class MemberServiceImpl implements MemberService {
	private static MemberServiceImpl instance = new MemberServiceImpl();
	public static MemberServiceImpl getInstance() {return instance;}
	MemberDao dao = MemberDaoImpl.getInstance();

	@Override
	public void join(MemberBean member) throws Exception {
		MemberDaoImpl.getInstance().insert(member);
	}

	@Override
	public MemberBean findById(String id) throws Exception {
		return MemberDaoImpl.getInstance().selectById(id);
	}

	@Override
	public boolean login(MemberBean member) throws Exception {
		return MemberDaoImpl.getInstance().login(member);
	}

	@Override
	public void change(MemberBean member) throws Exception{
		MemberDaoImpl.getInstance().update(member);
	}

	@Override
	public void remove(MemberBean member) throws Exception{
		MemberDaoImpl.getInstance().delete(member);
	}

}