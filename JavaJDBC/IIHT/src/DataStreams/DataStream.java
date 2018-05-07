package DataStreams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataStream {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		String line = null;
		while (true) {
			System.out.println("1. Read Single Charter");
			System.out.println("2. Read Multiple Charter");
			System.out.println("3. Count Number Of Lines And Words");
			System.out.println("4. Search String In File");
			System.out.println("5. Use Methods of FileReader");
			System.out.println("6. Get all File Names");
			System.out.println("7. Count No of Files And Directory");
			System.out.println("8. Read from File");
			System.out.println("9. Write in to File");
			int choice = Integer.parseInt(sc.nextLine());
			FileReader fin = new FileReader("D:\\testout.txt");
			BufferedReader reader = new BufferedReader(fin);
			switch (choice) {
			case 1:
				try {

					int i = fin.read();
					System.out.println((char) i);

					fin.close();
				} catch (Exception e) {
					System.out.println(e);
					break;
				}
				break;
			case 2:
				try {
					System.out.println("How Many Charter Do You Want To Read?");
					int ch = Integer.parseInt(sc.nextLine());
					if (ch > fin.toString().length()) {
						System.out.println("Invalid Charecter");
						break;
					}
					for (int i = 0; i < ch; i++)
						System.out.print((char) fin.read());
				}

				catch (IOException e) {
					System.out.println(e);
					break;
				}
				break;
			case 3:

				int chCount = 0, coWord = 0, liCount = 0;

				while ((line = reader.readLine()) != null) {
					liCount++;
					if (!(line.equals(""))) {
						String[] wordList = line.split(" ");
						coWord += wordList.length;
						line = line.replaceAll("\\s", "");
						chCount += line.length();
					}
				}

				System.out.println("No Of Characters = " + chCount);
				System.out.println("No Of Words = " + coWord);
				System.out.println("No Of Lines = " + liCount);
				break;
			case 4:
				System.out.println("Enter String To Be Searched");
				String sline = sc.nextLine();
				int lco = 0;
				while ((line = reader.readLine()) != null) {
					lco++;
					if (line.contains(sline)) {
						System.out.println("String Found " + sline + " in Line " + lco);
					}
				}

				break;
			case 5:
				System.out.println("Methods of File Readers are as Follows");
				System.out.println("tostring Method " + fin.toString());
				System.out.println("read method " + fin.ready());
				System.out.println("mark supported " + fin.markSupported());
				if (fin.markSupported()) {
					System.out.println("mark");
					fin.mark(10);
					System.out.println("read again" + fin.read());
					System.out.println("reset ");
					fin.reset();
					System.out.println("read after reset" + fin.read());
				}

				System.out.println("close");
				fin.close();
				break;
			case 6:
				System.out.println("Files and Directory List ");
				File file = new File("d:/");
				File[] files = file.listFiles();
				for (File f : files)
					System.out.println(f.getName());
				break;
			case 7:
				System.out.println("Count of Files and Directory");
				File file1 = new File("d:/");
				File[] files1 = file1.listFiles();
				int dir = 0, fil = 0;
				for (File f : files1)
					if (f.isDirectory()) {
						dir++;
					} else {
						fil++;
					}
				System.out.println("No of Directory is " + dir + " No of Files is " + fil);
				break;
			case 8:
				Scanner n = new Scanner((new FileInputStream("D:\\testout.txt")));
				while (n.hasNextLine())
					System.out.println(n.nextLine());

				break;
			case 9:
				PrintWriter outputStream = new PrintWriter(new FileOutputStream("outwrite.txt"));
				System.out.println("what do you wan to write?");
				Scanner tx = new Scanner(System.in);
				String input = tx.nextLine();
				outputStream.println(input);
				outputStream.close();
				break;

			default:
				System.out.println("Invalid Choice");
				break;

			}

		}
	}

}
