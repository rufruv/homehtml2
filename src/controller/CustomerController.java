package controller;

/*import constants.Bank;*/
import domain.MemberBean;
import domain.AccountBean;
import service.AccountService;
import serviceImpl.AccountServiceImpl;
import javax.swing.*;

public class CustomerController {
	
	public void start(){
		String tempSsn = "";
		MemberBean mem = null;  // 터만 잡고 공간은 없다 ( initialize 아님)     
		AccountBean account = null;
		AccountService service = new AccountServiceImpl();
		
		while(true){
			switch(JOptionPane.showInputDialog("0.종료 1.회원등록 2.통장개설 3.입금 4.출금 5.조회 6.해지")){
			case "0": return;
			case "1": 
				mem = new MemberBean(); 
				mem.setId(JOptionPane.showInputDialog("아이디"));
				mem.setName(JOptionPane.showInputDialog("이름"));
				while(true){
					tempSsn = JOptionPane.showInputDialog("주민번호(앞자리7자리까지만)?");
					char ch = tempSsn.charAt(7);
					if(ch == 0 || ch == 7 || ch == 8 || ch == 9 ){
						System.out.println("다시 입력하셔요");
						JOptionPane.showMessageDialog(null, "다시 입력하세요");
					}else{
						break ;
					}
				}
				mem.setSsn(tempSsn);
				JOptionPane.showMessageDialog(null, mem.getName()+"님 회원등록이 되었습니다.");
				break;
			case "2": 
				String uid = "";
				int money = 0 ;
				String accountType = "저축예금";
				account = service.createAccount(uid, accountType, money);
				/* [한빛뱅크] 
				 * 계좌번호 : 123456
				 * 예금종류 : 저축예금 송상훈 
				 * 가입일 : 2016년 12월 14일
				 * 잔액 : ￦ 0
				 */
				while(true){
					uid = JOptionPane.showInputDialog("아이디?");
					if(mem.getId().equals(uid)){
						break;
					}else{
						JOptionPane.showMessageDialog(null, "아이디를 다시 입력하시오");
					}
				}
				
				JOptionPane.showMessageDialog(null, account.toString());
				break;
			case "3":
				JOptionPane.showMessageDialog(null, 
						service.deposit(Integer.parseInt(JOptionPane.showInputDialog("얼마를 입금하시겠습니까?"))));
				break;
			case "4": 
				JOptionPane.showMessageDialog(null, 
						service.withdraw(Integer.parseInt(JOptionPane.showInputDialog("얼마를 출금하시겠습니까?"))));
				break;
			case "5": break;
			case "6": break;
			}
		}
	}
}