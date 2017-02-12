package dao;

import java.sql.SQLException;

import domain.MemberBean;

public interface MemberDao {
	public void insert(MemberBean member) throws SQLException;
	public MemberBean selectById(String id) throws SQLException;
	public boolean login(MemberBean member) throws SQLException;
	public void update(MemberBean member) throws SQLException;
	public void delete(MemberBean member)  throws SQLException;
}