package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;
import java.util.Random;

public class User {
	
	private Socket socket;
	private BufferedReader input;
	private PrintWriter output;
	private boolean active = true;
	private long lastActiveTime;
	private int id;
	
	public User(Socket socket) throws IOException {
		Random random = new Random();
		this.id = random.nextInt(1000);
		this.socket = socket;
		this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.output = new PrintWriter(socket.getOutputStream());
		this.lastActiveTime = Calendar.getInstance().getTimeInMillis();
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean isActive() {
		return this.active;
	}
	
	public long getLastActiveTime() {
		return lastActiveTime;
	}
	
	public BufferedReader getInput() {
		return input;
	}
	
	public int getId() {
		return id;
	}
	
	public PrintWriter getOutput() {
		return output;
	}
	
	public void close() throws IOException {
		socket.close();
		input.close();
		output.close();
	}
	
	public void keepAlive() {
		this.lastActiveTime = Calendar.getInstance().getTimeInMillis();
	}
	
	public void sendMessage(String message) {
		output.println(message);
		output.flush();
	}

}
