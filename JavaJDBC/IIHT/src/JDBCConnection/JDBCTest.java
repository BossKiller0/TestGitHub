package JDBCConnection;

import java.sql.*;
import java.util.Scanner;

public class JDBCTest {

	public static void main(String[] args) {

		Statement std = null;
		Connection con = null;
		Scanner sc = new Scanner(System.in);
		try {

			con = new MySQLConnect().Connect();
			con.setAutoCommit(false);
			std = con.createStatement();
			std.execute(
					"CREATE TABLE IF NOT EXISTS Student (Id INT(11) NOT NULL AUTO_INCREMENT,Name VARCHAR(45) DEFAULT NULL,Address VARCHAR(200) DEFAULT NULL,PRIMARY KEY (ID))");
			System.out.println("Student Table Created");

			System.out.println("1. Insert");
			System.out.println("2. Delete");
			System.out.println("3. Modify");
			System.out.println("4. Display");
			System.out.println("5. Exit");

			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				System.out.println("How Many Records Do You Want To Insert?");
				int rc = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < rc; i++) {
					System.out.print("\"\"");
					System.out.println("Enter Data");
					System.out.print("Enter ID");
					int id = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Name");
					String name = sc.nextLine();
					System.out.print("Enter Address");
					String add = sc.nextLine();
					System.out.println("insert into student values(" + id + ",'" + name + "','" + add + "')");
					std.addBatch("insert into student values(" + id + ",'" + name + "','" + add + "')");
				}
				std.executeBatch();
				System.out.println("Do You Want To Save The Changes? (Y/N)");
				String ms = sc.nextLine();
				if (ms.equals("Y") || ms.equals("y")) {
					con.commit();
				} else if (ms.equals("N") || ms.equals("n")) {
					System.out.println("h");
					con.rollback();
				} else {
					System.out.println("Invalid Choice  Quitting !");
					System.exit(0);
				}

				break;

			default:
				System.out.println("Error Invalid Chioce");
				break;

			}

		} catch (Exception e) {
			sc.close();
			System.out.println(e);

		}

	}

}
