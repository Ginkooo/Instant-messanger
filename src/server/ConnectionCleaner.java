package server;

import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;

public final class ConnectionCleaner {
	public static void cleanConnections(User user) {
		if (!user.isActive()) {
			try {
				user.close();
			} catch (IOException e) {
				System.err.println(e);
			}
			System.out.println("User " + user.getId() + " removed!");
			Data.connectionArray.remove(user);
		}
	}
}
