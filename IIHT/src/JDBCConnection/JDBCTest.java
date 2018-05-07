package JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest {

	public static void main(String[] args) {

		Statement std = null;
		Connection con = null;
		Scanner sc = new Scanner(System.in);
		String ms;
		int id;
		while (true) {
			try {

				con = new MySQLConnect().Connect();
				con.setAutoCommit(false);
				std = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
						System.out.println("Enter Data " + (i + 1));
						System.out.print("Enter ID");
						id = Integer.parseInt(sc.nextLine());
						System.out.print("Enter Name");
						String name = sc.nextLine();
						System.out.print("Enter Address");
						String add = sc.nextLine();
						System.out.println("insert into student values(" + id + ",'" + name + "','" + add + "')");
						std.addBatch("insert into student values(" + id + ",'" + name + "','" + add + "')");
					}
					std.executeBatch();
					System.out.println("Do You Want To Save The Changes? (Y/N)");
					ms = sc.nextLine();
					if (ms.equals("Y") || ms.equals("y")) {
						con.commit();
					} else if (ms.equals("N") || ms.equals("n")) {
						System.out.println("Canceled");
						con.rollback();
					} else {
						System.out.println("Invalid Choice Restarting !");
						con.rollback();
						continue;
					}

					break;

				case 2:
					System.out.print("Enter ID : ");
					id = Integer.parseInt(sc.nextLine());
					ResultSet b = std.executeQuery("select * from student where id =" + id);
					if (b.next()) {
						System.out.println("Records Found");
						System.out.println("Do You Want To Proceed With The Deletion? (Y/N)");
						ms = sc.nextLine();
						if (ms.equals("Y") || ms.equals("y")) {
							std.executeUpdate("delete from student where id =" + id);
							con.commit();
							System.out.println("Record with ID " + id + " Deleted Sucessfully. ");
						} else if (ms.equals("N") || ms.equals("n")) {
							System.out.println("Canceled");
							con.rollback();
						} else {
							System.out.println("Invalid Choice Restarting !");
							con.rollback();
							continue;
						}

					} else {
						System.out.println("Invalid ID / No Records Were Found !");
					}
					break;

				case 3:
					System.out.println("How Many Records Do You Want To Update?");
					int rc1 = Integer.parseInt(sc.nextLine());
					for (int i = 0; i < rc1; i++) {
						System.out.println("Enter Data " + (i + 1));
						System.out.println("Enter ID :");
						int cid = Integer.parseInt(sc.nextLine());
						System.out.print("Enter New ID");
						id = Integer.parseInt(sc.nextLine());
						System.out.print("Enter New Name");
						String name = sc.nextLine();
						System.out.print("Enter New Address");
						String add = sc.nextLine();
						System.out.println("UPDATE student SET id = " + id + ", name = '" + name + "',address = '" + add
								+ "' where id = " + cid);
						std.addBatch("UPDATE student SET id = " + id + ", name = '" + name + "',address = '" + add
								+ "' where id = " + cid);
					}
					std.executeBatch();
					System.out.println("Do You Want To Save The Changes? (Y/N)");
					ms = sc.nextLine();
					if (ms.equals("Y") || ms.equals("y")) {
						con.commit();
					} else if (ms.equals("N") || ms.equals("n")) {
						System.out.println("Canceled");
						con.rollback();
					} else {
						System.out.println("Invalid Choice Restarting !");
						con.rollback();
						continue;

					}
					break;

				case 4:
					ResultSet rs;
					rs = std.executeQuery("select * from student");
					if (MySQLConnect.rowCount(rs) > 0) {
						rs.beforeFirst();
						while (rs.next()) {
							System.out.println(rs.getRow() + ". " + rs.getInt("id") + " " + rs.getString("name") + " "
									+ rs.getString("Address"));
						}
					}
					break;

				case 5:
					System.out.println("Exiting . . . . ");
					System.exit(0);
				default:
					System.out.println("Error Invalid Chioce");
					break;

				}

			} catch (Exception e) {
				sc.close();
				System.out.println(e);
				System.exit(0);

			}
		}

	}

}
