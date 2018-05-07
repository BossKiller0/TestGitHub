package Threds;

import java.io.File;

public class CopyUsingThreads {

	public static void main(String[] args) {

		System.out.println("Copy Files");

		CopyThred c1 = new CopyThred(new File("D:\\src\\PO.pdf"), new File("C:\\Users\\God\\Desktop\\des\\PO.pdf"),
				"File1");
		CopyThred c2 = new CopyThred(new File("D:\\src\\PO1.pdf"), new File("C:\\Users\\God\\Desktop\\des\\PO1.pdf"),
				"File2");
		CopyThred c3 = new CopyThred(new File("D:\\src\\PO2.pdf"), new File("C:\\Users\\God\\Desktop\\des\\PO2.pdf"),
				"File3");

	}

}
