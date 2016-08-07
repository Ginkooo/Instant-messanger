package server;

import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;

public final class ConnectionCleaner {
	public static boolean cleanConnections(User user) {
		if (!user.isActive()) {
			try {
				user.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("User " + user.getId() + " removed!");
			return true;
		}
		return false;
	}
}
