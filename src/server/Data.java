package server;

import java.util.ArrayList;

public final class Data {
	
	public static ArrayList<User> connectionArray = new ArrayList<User>();
	public static final int port = 2350;
	public static final Object connectionArrayLock = new Object();
	public static final int deelay = 10 * 60 * 1000;

}
