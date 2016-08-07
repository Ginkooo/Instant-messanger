package server;

import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;

public final class ConnectionCleaner extends Thread {
	public static final ConnectionCleaner connectionCleaner = new ConnectionCleaner();

	@Override
	public void run() {
		while (true) {
			synchronized (Data.connectionArrayLock) {
				for (Iterator<User> iterator = Data.connectionArray.iterator(); iterator.hasNext(); ) {
					User user = iterator.next();
					if (!user.isActive()) {
						try {
							user.close();
						} catch (IOException e) {
							System.err.println(e);
						}
						System.out.println("User " + user.getId() + " removed!");
						iterator.remove();
					}
				}
				}
			}
	}
}
