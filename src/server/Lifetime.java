package server;

import java.util.Iterator;

public final class Lifetime extends Thread {

	public static final Lifetime lifetime = new Lifetime();

	@Override
	public void run() {
		while (true) {
			process();
		}
	}

	private void process() {
		synchronized (Data.connectionArrayLock) {
			for (Iterator iterator = Data.connectionArray.iterator(); iterator.hasNext();) {
				User user = (User) iterator.next();
				ConnectionAliveChecker.checkIfAlife(user);
				boolean userRemoved = ConnectionCleaner.cleanConnections(user);
				if (userRemoved) { iterator.remove(); continue; }
				String message = MessageReciever.recieveMessages(user);
				if (message != null) {
					MessageSender.sendToAll(message, user);
				}
			}
		}

	}

}
