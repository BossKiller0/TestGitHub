package Com;

import java.util.Comparator;

public class SortByBankBalance implements Comparator<Bank> {

	@Override
	public int compare(Bank b1, Bank b2) {
		if (b1.getBalance() == b2.getBalance())
			return 0;
		else if (b1.getBalance() > b2.getBalance())
			return 1;
		else
			return -1;

	}

}
