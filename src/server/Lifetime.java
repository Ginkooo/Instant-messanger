package server;

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
			for (User user : Data.connectionArray) {
				ConnectionAliveChecker.checkIfAlife(user);
				ConnectionCleaner.cleanConnections(user);
				String message = MessageReciever.recieveMessages(user);
				if (message != null) {
					MessageSender.sendToAll(message, user);
				}
			}
		}

	}

}
