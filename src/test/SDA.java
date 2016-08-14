package test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SDA {

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter("temp.txt");
		pw.println("line");
		pw.close();
		pw.println("line");
		pw.close();

	}

}
