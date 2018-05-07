package Com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class TestBank {

	public static void main(String[] args) {

		ArrayList<Bank> Customers = new ArrayList<Bank>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		String s1 = new String("HELLO");
        String s2 = new String("HELLO");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
		// Bank Customer[];
		// for (int i = 0; i < Customer.length; i++)
		// Customer[i] = new Bank();
		//
		// // Initilizing Bank objects
		//
		// Customer[0].init(034, "King", 10000, 1);
		// Customer[1].init(674, "Prince", 160000, 2);
		// Customer[2].init(584, "Emperer", 200000, 10);
		//
		// Customer[0].deposite(500);
		// Customer[1].withdraw(500);
		// Customer[1].withdraw(500);
		// ArrayList<String> io = Customer[1].getListWithdraw();
		// ArrayList<String> ii = Customer[0].getListDeposite();
		// Iterator<String> itr = io.iterator();
		// Iterator<String> it2 = ii.iterator();
		// while (itr.hasNext()) {
		// System.out.println(itr.next());
		// }
		// while (it2.hasNext()) {
		// System.out.println(it2.next());
		// }

		// System.out.print("How Many Customers Do you want to Create? ");
		// int nocus = Integer.parseInt(sc.nextLine());
		// Customer = new Bank[nocus];
		// for (int i = 0, j = i + 1; i < Customer.length; i++, j++) {
		// Customer[i] = new Bank();
		// System.out.println("Enter Customer " + j + " Details");
		// System.out.print("Enter Account No : ");
		// int ac = Integer.parseInt(sc.nextLine());
		// System.out.print("Enter Account Name : ");
		// String nm = sc.nextLine();
		// System.out.print("Enter Balance : ");
		// int bal = Integer.parseInt(sc.nextLine());
		// System.out.print("Enter No Of Lockers : ");
		// int loc = Integer.parseInt(sc.nextLine());
		// Customer[i].init(ac, nm, bal, loc);
		//
		// }

		// System.out.println(" 1. Bank Login");
		// System.out.println(" 2. Customer Login");
		// int choice = Integer.parseInt(sc.nextLine());
		// switch (choice) {
		//
		// case 1:
		// System.out.println("1. Display Bank Details");
		// System.out.println("2. Display List of Customers");
		// System.out.println("3. Display All Deposite Transactions");
		// System.out.println("4. Display All Withdraw Transactions");
		// int ichoice = Integer.parseInt(sc.nextLine());
		//
		// switch (ichoice) {
		//
		// case 1:
		// Bank.bankDetails();
		// break;
		// case 2:
		// for (int i = 0; i < Customer.length; i++) {
		// Customer[i].details();
		// }
		// break;
		// case 3:
		// System.out.println("All Deposite Details");
		// Bank.allDepositeTras();
		// break;
		// case 4:
		// System.out.println("All Withdraw Details");
		// Bank.allWithdrawTras();
		// break;
		// default:
		// System.out.println("Invalid Input");
		// System.exit(0);
		// }
		//
		// case 2:
		// for (int i = 0, j = i + 1; i < Customer.length; i++, j++) {
		// System.out.print(j + " ");
		// Customer[i].details();
		// }
		//
		// System.out.println("Select Customer");
		// int selcus = Integer.parseInt(sc.nextLine());
		// Bank SelCustomer = Customer[selcus - 1];
		//
		// System.out.print("Selected Customer :");
		// SelCustomer.details();
		// System.out.println("What do you want to Do?");
		// System.out.println(" 1. Deposite ");
		// System.out.println(" 2. Withdraw ");
		// System.out.println(" 3. Check Balance");
		// System.out.println(" 4. List of Deposites ");
		// System.out.println(" 5. List of Withdraws ");
		//
		// int cchoice = Integer.parseInt(sc.nextLine());
		//
		// switch (cchoice) {
		// case 1:
		// System.out.print("Enter Amount To Be Deposited");
		// int cdep = Integer.parseInt(sc.nextLine());
		// SelCustomer.deposite(cdep);
		// break;
		// case 2:
		// System.out.println("Enter Amount to Be WithDraw");
		// int cwin = Integer.parseInt(sc.nextLine());
		// if (SelCustomer.getBalance() >= cwin) {
		// SelCustomer.withdraw(cwin);
		// } else {
		// System.out.println("You Do Not Have Sufficient Balance");
		// }
		//
		// }
		//
		// }

		while (true) {

			System.out.println("1. Add New Customer");
			System.out.println("2. Customer Transactions");
			System.out.println("3. Bank Details");
			System.out.println("4. Sorting");
			System.out.println("5. Exit");

			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {

			case 1:
				System.out.println("How Many Customers Do You Want to Add?");
				int No = Integer.parseInt(sc.nextLine());
				for (int i = 0, j = i + 1; i < No; i++, j++) {

					System.out.println("Enter Customer " + j + " Details");
					int ac = rand.nextInt(1000);
					System.out.println("Auto Generated Account No : " + ac);
					System.out.print("Enter Account Name : ");
					String nm = sc.nextLine();
					System.out.print("Enter Balance : ");
					int bal = Integer.parseInt(sc.nextLine());
					System.out.print("Enter No Of Lockers : ");
					int loc = Integer.parseInt(sc.nextLine());
					if ((Bank.Lockers + loc) > Bank.MaxLockers) {
						System.out.println("Lockers Cannot Be Assignet Out Of Limit");
						loc = 0;
					}
					Customers.add(new Bank(ac, nm, bal, loc));

					System.out.println("Customer " + nm + " Added Sucessfully ");
				}
				break;
			case 2:
				int sz = Customers.size();
				if (sz == 0) {
					System.out.println("No Customers Found !");
					break;
				}
				System.out.println("Select Customer From The List");
				for (int i = 0; i < sz; i++) {
					System.out.print((i + 1) + ". ");
					Customers.get(i).details();
				}
				int sel = (Integer.parseInt(sc.nextLine()) - 1);
				System.out.println("What Do you Want to Do?");
				System.out.println(" 1. Deposite ");
				System.out.println(" 2. Withdraw ");
				System.out.println(" 3. Check Balance");
				System.out.println(" 4. List of Deposites ");
				System.out.println(" 5. List of Withdraws ");
				int ichoice = Integer.parseInt(sc.nextLine());
				switch (ichoice) {
				case 1:
					try {
						System.out.println("How Much Do You Want To Deposite ?");
						int dp = Integer.parseInt(sc.nextLine());
						System.out.println("Customer Details");
						Customers.get(sel).deposite(dp);
						System.out.println("Deposite Sucessfull" + " Mr/Ms " + Customers.get(sel).getName()
								+ " Your New Balance is " + Customers.get(sel).getBalance());
						break;
					} catch (NumberFormatException e) {

						System.out.println(e);
						break;
					}

				case 2:
					try {
						System.out.println("How Much do You Want to WithDraw ?");
						int win = Integer.parseInt(sc.nextLine());
						if (Customers.get(sel).getBalance() < win) {
							System.out.println("Windraw Failed Insufficent Balance");
							break;
						}
						Customers.get(sel).withdraw(win);
						System.out.println("Withdraw Sucessfull" + " Mr/Ms " + Customers.get(sel).getName()
								+ " Your New Balance is " + Customers.get(sel).getBalance());
						break;
					} catch (NumberFormatException e) {

						System.out.println(e);
						break;
					}
				case 3:
					try {
						Date dt = new Date();
						System.out.println("Your Balance as on" + dt.toString() + Customers.get(sel).getBalance());
						break;
					} catch (Exception e) {
						System.out.println(e);
						break;
					}
				case 4:
					try {
						System.out.println("All of Your Deposites are as Follows");
						Iterator<String> it = Customers.get(sel).getListDeposite().iterator();
						while (it.hasNext()) {
							System.out.println(it.next());
						}
						break;
					} catch (Exception e) {
						System.out.println(e);
						break;
					}
				case 5:
					try {
						System.out.println("All of Your WithDraw are as Follows");
						Iterator<String> it = Customers.get(sel).getListDeposite().iterator();
						while (it.hasNext()) {
							System.out.println(it.next());
						}
						break;
					} catch (Exception e) {
						System.out.println(e);
						break;
					}

				default:
					System.out.println("Invalid Option");
					break;

				}
				break;

			case 3:
				System.out.println("1. List All Customers");
				System.out.println("2. Total Balance in Bank");
				System.out.println("3. No of Lockers in Use");
				System.out.println("4. All Deposite details");
				System.out.println("5. All WithDraw Details");

				int bchoice = Integer.parseInt(sc.nextLine());
				int si = Customers.size();
				switch (bchoice) {

				case 1:

					try {
						System.out.println("List of All Customers");
						for (int i = 0; i < si; i++) {
							System.out.print((i + 1) + ". ");
							Customers.get(i).details();
						}
						break;
					} catch (Exception e) {
						System.out.println(e);
						break;
					}
				case 2:
					System.out.println("Total Balance = " + Bank.Totbalance);
					break;
				case 3:
					System.out.println("No of Lockers in Use are = " + Bank.Lockers);
					break;
				case 4:
					System.out.println("All Deposites to Bank ");
					Bank.allDepositeTras();
					break;
				case 5:
					System.out.println("All WithDraw From Bank ");
					Bank.allWithdrawTras();
					break;
				default:
					System.out.println("Invalid Option");
					break;

				}
				break;
			case 4:
				System.out.println("What Do You Want to Use Comparable or Comparator");
				System.out.println("1. Comparable");
				System.out.println("2. Comparator");

				bchoice = Integer.parseInt(sc.nextLine());

				switch (bchoice) {

				case 1:
					System.out.println("Sorting using by Comparabler");
					System.out.println("Defaullt Sort By Account Number");
					Collections.sort(Customers);
					for (Bank bk : Customers) {
						System.out.println("Account No " + bk.getAc_Number() + " Account Holder " + bk.getName()
								+ "  Balance " + bk.getBalance() + "  No Of Lockers " + bk.getLocker());
					}
					break;
				case 2:
					System.out.println("Sorting Using Comparator");
					System.out.println("What Do You Want To Sort By");
					System.out.println("1. Account Number");
					System.out.println("2. Name");
					System.out.println("3. Balance");

					bchoice = Integer.parseInt(sc.nextLine());
					switch (bchoice) {
					case 1:
						Collections.sort(Customers, new SortBankByAccNumber());
						for (Bank bk : Customers) {
							System.out.println("Account No " + bk.getAc_Number() + " Account Holder " + bk.getName()
									+ "  Balance " + bk.getBalance() + "  No Of Lockers " + bk.getLocker());
						}
						break;
					case 2:
						Collections.sort(Customers, new SortBankByName());
						for (Bank bk : Customers) {
							System.out.println("Account No " + bk.getAc_Number() + " Account Holder " + bk.getName()
									+ "  Balance " + bk.getBalance() + "  No Of Lockers " + bk.getLocker());
						}
						break;
					case 3:
						Collections.sort(Customers, new SortByBankBalance());
						for (Bank bk : Customers) {
							System.out.println("Account No " + bk.getAc_Number() + " Account Holder " + bk.getName()
									+ "  Balance " + bk.getBalance() + "  No Of Lockers " + bk.getLocker());
						}
						break;
					default:
						System.out.println("Invaid Choice");
					}

					break;
				default:
					System.out.println("Invalid Choice");
					break;
				}

				break;
			case 5:
				System.out.println("Exiting.....");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Option");
				break;

			}
			System.out.println("Do You Want To Exit? (Y/N)");
			String Q = sc.nextLine();
			
			if (Q == "Y" || Q == "y")
				System.exit(0);

		}

	}

}
