package util;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import domain.MemberBean;
import enums.ButtDao;
import service.MemberService;
import serviceImpl.MemberServiceImpl;

public class DAOTest {
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		MemberBean member;
		String[] arr;
		ButtDao[] buttons = { ButtDao.EXIT, ButtDao.MEMBER_ADD, ButtDao.FIND_BY_ID, ButtDao.LOGIN, ButtDao.UPDATE,
				ButtDao.DELETE };
		while (true) {
			ButtDao select = (ButtDao) JOptionPane.showInputDialog(null, // frame
					"MEMBER PAGE", // frame title
					"SELECT MENU", // order
					JOptionPane.QUESTION_MESSAGE, // type
					null, // icon
					buttons, // Array of choices
					buttons[1] // default
			);
			switch (select) {
			case EXIT:
				return;
			case MEMBER_ADD:
				member = new MemberBean();
				arr = JOptionPane.showInputDialog("id, name, ssn, password, profileImg, phone, email,rank").split(",");
				member.setId(arr[0]);
				member.setName(arr[1]);
				member.setSsn(arr[2]);
				member.setPassword(arr[3]);
				member.setProfileImg(arr[4]);
				member.setPhone(arr[5]);
				member.setEmail(arr[6]);
				member.setRank(arr[7]);
				try {
					service.join(member);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
			case FIND_BY_ID:
				member = new MemberBean();
				try {
					member = service.findById(JOptionPane.showInputDialog("ID?"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(member.getId().equals("")){
					JOptionPane.showMessageDialog(null, "해당 회원 없음");
				}else{
					JOptionPane.showMessageDialog(null, member);
				}
				break;
			case LOGIN:
				member = new MemberBean();
				arr = JOptionPane.showInputDialog("ID,PASSWORD").split(",");
				member.setId(arr[0]);
				member.setPassword(arr[1]);
				try {
					if(service.login(member)){
						JOptionPane.showMessageDialog(null, "로그인 완료!");
					}else{
						JOptionPane.showMessageDialog(null, "ID 또는 PW를 다시 입력해주세요");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case UPDATE:
				member=new MemberBean();
				member.setName(JOptionPane.showInputDialog("변경할 이름을 입력하세요."));
				member.setPassword(JOptionPane.showInputDialog("변경할 비밀번호를 입력하세요."));
				member.setPhone(JOptionPane.showInputDialog("변경할 휴대폰 번호를 입력하세요."));
				member.setEmail(JOptionPane.showInputDialog("변경할 email를 입력하세요."));
				member.setProfileImg(JOptionPane.showInputDialog("변경할 progileImg를 입력하세요."));
				try {
					service.change(member);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case DELETE:
				member = new MemberBean();
				member.setId(JOptionPane.showInputDialog("회원탈퇴:ID를 입력하세요"));
				try {
					service.remove(member);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}
}