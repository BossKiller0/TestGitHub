package Com;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;



public class Bank implements Comparable<Bank>{

	private int Ac_Number;
	private String Name;
	private int Balance;
	private int Locker;
	private ArrayList<String> listWithdraw = new ArrayList<String>();
	private ArrayList<String> listDeposite = new ArrayList<String>();
	public static ArrayList<String> stlistDeposite = new ArrayList<String>();
	public static ArrayList<String> stlistWithdraw = new ArrayList<String>();
	public static int Cuscount, Totbalance, Lockers = 0;
	public static final int MaxLockers = 100;

	public Bank(int ac_Number, String name, int balance, int locker) {
		this.Ac_Number = ac_Number;
		this.Name = name;
		this.Balance = balance;
		this.Locker = locker;
		Bank.Lockers = Bank.Lockers + locker;
		Bank.Cuscount++;
		Bank.Totbalance += balance;
	}

	public Bank() {
		this.Ac_Number = 0;
		this.Name = null;
		this.Balance = 0;
		this.Locker = 0;
		Bank.Cuscount++;
	}

	public void init(int ac_Number, String name, int balance, int locker) {
		this.Ac_Number = ac_Number;
		this.Name = name;
		Bank.Totbalance = Bank.Totbalance - this.Balance;
		this.Balance = balance;
		Bank.Totbalance += balance;
		Bank.Lockers = Bank.Lockers - this.Locker;
		this.Locker = locker;
		Bank.Lockers = Bank.Lockers + locker;
	}

	public void deposite(int dep) {
		this.Balance = this.Balance + dep;
		Bank.Totbalance += dep;
		Date date = new Date();
		this.listDeposite.add("Deposite On " + date.toString() + " Rs " + dep);
		Bank.stlistDeposite.add("Deposited By " + this.getName() + " Account Number" + this.getAc_Number()
				+ " Deposited On " + date.toString() + " Rs " + dep);
		this.details();
	}

	public void withdraw(int win) {
		this.Balance = this.Balance - win;
		Bank.Totbalance += win;
		Date date = new Date();
		this.listWithdraw.add("WithDraw On " + date.toString() + " Rs " + win);
		Bank.stlistWithdraw.add("Withdraw By " + this.getName() + " sAccount Number" + this.getAc_Number()
				+ " Withdraw On " + date.toString() + " Rs " + win);
		this.details();

	}

	public static void bankDetails() {

		System.out.println("No of Customers : " + Bank.Cuscount);
		System.out.println("Total Balance : " + Bank.Totbalance);
		System.out.println("No of Lockers in Use : " + Bank.Lockers);

	}

	public static void allDepositeTras() {

		Iterator<String> it = stlistDeposite.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

	public static void allWithdrawTras() {

		Iterator<String> it = stlistWithdraw.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

	public ArrayList<String> getListWithdraw() {
		return listWithdraw;
	}

	public void setListWithdraw(ArrayList<String> listWithdraw) {
		this.listWithdraw = listWithdraw;
	}

	public ArrayList<String> getListDeposite() {
		return listDeposite;
	}

	public void setListDeposite(ArrayList<String> listDeposite) {
		this.listDeposite = listDeposite;
	}

	public void details() {
		System.out.println("Account No " + this.Ac_Number + " Account Holder " + this.Name + "  Balance " + this.Balance
				+ "  No Of Lockers " + this.Locker);
	}

	public int getAc_Number() {
		return Ac_Number;
	}

	public void setAc_Number(int ac_Number) {
		Ac_Number = ac_Number;
	}

	public int getBalance() {
		return Balance;
	}

	public void setBalance(int balance) {
		Balance = balance;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getLocker() {
		return Locker;
	}

	public void setLocker(int locker) {
		Locker = locker;
	}

	@Override
	public int compareTo(Bank o) {
		if (this.getAc_Number() == o.getAc_Number())
			return 0;
		else if (this.getAc_Number() > o.getAc_Number())
			return 1;
		else
			return -1;
	}

}
