package Com;

public class TestEmp {

	public static void main(String[] args) {

		Employee e1 = new Employee(13, "Reddys", 1000000);
		e1.display();

		Employee Staff[] = new Employee[3];
		for (int i = 0; i < Staff.length; i++)
			Staff[i] = new Employee();
		System.out.println("Unsorted Array");
		Staff[0].init(1, "Bhaskar", 5600000);
		Staff[1].init(2, "King", 90000);
		Staff[2].init(3, "Prince", 150000);
		for (int i = 0; i < Staff.length; i++) {
			Staff[i].display();
		}
		// Finding largest salary of employee
		Employee Lar = null;
		int max = 0;
		for (int i = 0; i < Staff.length; i++) {
			if (Staff[i].getSal() > max) {
				max = Staff[i].getSal();
				Lar = Staff[i];
			}
		}
		System.out.println("Largest Salry is  Recived By");
		Lar.display();

		// Sorting according to salary
		Employee Temp;
		for (int i = 0; i < Staff.length; i++) {
			for (int j = 0; j < Staff.length; j++) {
				if (Staff[i].getSal() > Staff[j].getSal()) {
					Temp = Staff[i];
					Staff[i] = Staff[j];
					Staff[j] = Temp;
				}
			}
		}
		// sorted according to salary
		System.out.println("Sorted According to Salary");
		for (int i = 0; i < Staff.length; i++) {
			Staff[i].display();
		}

	}

}
