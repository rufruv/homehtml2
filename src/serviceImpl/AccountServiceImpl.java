package serviceImpl;

import util.RandomGenerator;
import java.util.Calendar;
import constants.Account;
import domain.AccountBean;
import service.AccountService;

public class AccountServiceImpl implements AccountService{
	AccountBean[] list;  // 사용하고 나서도 유지되는것 (association:연관관계)
	
	public AccountServiceImpl() {
		list = new AccountBean[10000];
	}
	
	@Override
	public AccountBean createAccount(String uid, String accountType, int money) { //createAccountBean 메소드를 호출했을때 
		AccountBean account = new AccountBean(); // ex>.통장신청서-> 사용후에 버리는것 (dependency:의존관계)
		account.setAccountNo(String.valueOf(RandomGenerator.getRandomNum(100000, 999999)));
		account.setCreateDate(Calendar.getInstance().get(Calendar.YEAR)+"년"
				            + Calendar.getInstance().get(Calendar.MONTH)+1+"월"
				            + Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"일") ;
		account.setId(uid);
		account.setAccountType(accountType);
		account.setMoney(String.valueOf(money));
		list[0] = account;
		return account;
	}
	
	@Override
	public boolean checkMoney(int money) {
		return money>=0;
	}

	@Override
	public String deposit(int money) {
		String result = Account.DEPOSIT_FAIL;
		if(checkMoney(money)){
			list[0].setMoney(
					String.valueOf(Integer.parseInt(list[0].getMoney())+money));
			return Account.DEPOSIT_SUCCESS;
		}
		return result ;
	}

	@Override
	public String withdraw(int money) {
		String result = Account.WITHDRAW_FAIL;
		if(checkMoney(Integer.parseInt(list[0].getMoney())-money)){
			list[0].setMoney(
					String.valueOf(Integer.parseInt(list[0].getMoney())-money));
			result=Account.WITHDRAW_SUCCESS;
		}
		return result;
	}

	@Override
	public AccountBean findByAccountNo(String accountNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountBean findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AccountBean[] list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void drop(String accountNo) {
		// TODO Auto-generated method stub
		
	}
}