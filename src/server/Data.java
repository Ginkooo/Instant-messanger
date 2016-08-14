package server;

import java.util.ArrayList;

public final class Data {
	
	public static ArrayList<User> connectionArray = new ArrayList<User>();
	public static final int port = 2350;
	public static final Object connectionArrayLock = new Object();
	public static final Object messageFileLock = new Object();
	public static final int deelay = 60 * 1000;
	public static final String msgFileName = "messages.txt";

}
