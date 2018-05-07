package Com;

import java.util.Comparator;

public class SortBankByName implements Comparator<Bank> {

	@Override
	public int compare(Bank b1, Bank b2) {
		return b1.getName().compareTo(b2.getName());

	}

}
