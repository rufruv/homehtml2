package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import constants.Database;
import dao.MemberDao;
import domain.MemberBean;
import enums.Vendor;
import factory.DatabaseFactory;

public class MemberDaoImpl implements MemberDao {
	/*private static MemberDaoImpl instance = new MemberDaoImpl();*/
	public static MemberDaoImpl getInstance() {return new MemberDaoImpl();}

	@Override
	public void insert(MemberBean member) throws SQLException {
		DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
		               .getConnection()
		               .createStatement()
		               .executeUpdate(String.format("INSERT INTO Member(id, name, ssn, password, profileImg, phone, email, rank) "
				                                  + "VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", 
				                                    member.getId(),member.getName(),member.getSsn(),member.getPassword(),member.getProfileImg(),member.getPhone(),member.getEmail(),member.getRank()));
	}

	@Override
	public MemberBean selectById(String id) throws SQLException {
		MemberBean member = new MemberBean();
		ResultSet set = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
				       .getConnection()
				       .createStatement()
				       .executeQuery(String.format("SELECT * FROM member WHERE id='%s'", id));
		if (set.next()) {
			member.setId(set.getString("id"));
			member.setName(set.getString("name"));
			member.setSsn(set.getString("ssn"));
			member.setPassword(set.getString("password"));
			member.setProfileImg(set.getString("profileImg"));
			member.setPhone(set.getString("phone"));
			member.setEmail(set.getString("email"));
			member.setRank(set.getString("rank"));
		}
		return member;
	}

	@Override
	public boolean login(MemberBean member) throws SQLException {
		boolean loginCheck = false;
		MemberBean temp=selectById(member.getId());
		/*String sql = String.format("SELECT id,password FROM member WHERE id='%s'and password='%s'", member.getId(),member.getPassword());
		ResultSet set = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
				       .getConnection()
				       .createStatement()
				       .executeQuery(sql);*/
		if(member.getPassword().equals(temp.getPassword())){
			loginCheck = true;
		}
		return loginCheck;
	}

	@Override
	public void update(MemberBean member) throws SQLException {
		/*DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
                       .getConnection()
                       .createStatement()
                       .executeUpdate(String.format("UPDATE Member SET name='%s', password='%s', profileImg='%s', phone='%s', email='%s' WHERE id='%s'", 
								     "member.getName(),member.getPassword(),member.getProfileImg(),member.getPhone(),member.getEmail()"));*/
		MemberBean temp = selectById(member.getId());
		DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME,Database.PASSWORD)
					   .getConnection()
					   .createStatement()
					   .executeUpdate(String.format("UPDATE Member SET name='%s',password='%s',profileImg='%s',phone='%s',email='%s' WHERE id='%s'",
							         (member.getName().equals("")?temp.getName():member.getName()),
							         (member.getPassword().equals("")?temp.getPassword():member.getPassword()),
							         (member.getProfileImg().equals("")?temp.getProfileImg():member.getProfileImg()),
							         (member.getPhone().equals("")?temp.getPhone():member.getPhone()),
							         (member.getEmail().equals("")?temp.getEmail():member.getEmail()),
							          member.getId()));	
	
	}

	@Override
	public void delete(MemberBean member) throws SQLException {
		DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
					   .getConnection()
					   .createStatement()
					   .executeUpdate(String.format("DELETE * FROM member WHERE id='%s'", member.getId()));

	}

}