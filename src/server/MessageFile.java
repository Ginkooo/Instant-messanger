package server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MessageFile {

	public static void store(String message) {

		try (PrintWriter foutput = new PrintWriter(Data.msgFileName)) {
			foutput.println(message);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static String read() {

		ArrayList<String> messages

		try (BufferedReader finput = new BufferedReader(new FileReader(Data.msgFileName))) {
			
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return message;

	}

}
