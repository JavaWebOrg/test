package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CountFileHandler {
	public static void writeFile(String filename, long count) {
		try {
			PrintWriter out = new PrintWriter(new FileWriter(filename));
			out.println(count);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static long readFile(String filename) {
		long count = 0;
		try {
			File f = new File(filename);
			if (!f.exists()) {
				writeFile(filename, 0);
			}
			BufferedReader in = new BufferedReader(new FileReader(f));
			count = Long.parseLong(in.readLine());
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}
}

