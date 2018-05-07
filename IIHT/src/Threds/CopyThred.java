package Threds;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CopyThred implements Runnable {

	Thread t;
	File src;
	File des;

	public CopyThred(File src, File des, String nm) {
		this.t = new Thread(this, nm);
		this.src = src;
		this.des = des;
		this.t.start();

	}

	public void run() {

		try {
			long start = System.nanoTime();
			copyFile(this.src, this.des);
			System.out.println(t.getName() + " Completed");
			System.out.println("Time taken by  Copy = " + (System.nanoTime() - start));
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	private static void copyFile(File source, File dest) throws IOException {
		Files.copy(source.toPath(), dest.toPath());
	}

}
