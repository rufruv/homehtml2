package domain;

import java.io.Serializable;

public class AccountBean implements Serializable{      // Object Stream을 쓰기위해!
	private static final long serialVersionUID = 1L;   // JSP에서 사용
	protected String id, accountType, createDate, money, accountNo ;
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getId(){
		return id;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountNo(){
		return accountNo;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountType(){
		return accountType;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getMoney(){
		return money;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreateDate(){
		return createDate;
	}
		
	@Override
	public String toString() {
		return String.format("%d [%s] %s %s %s", 
				accountNo, accountType, id, createDate, money);
	}
	
}