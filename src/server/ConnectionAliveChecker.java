package server;

import java.util.Calendar;

public final class ConnectionAliveChecker extends Thread {
	public static final ConnectionAliveChecker connectionAliveChecker = new ConnectionAliveChecker();

	@Override
	public void run() {
		while (true) {
			synchronized (Data.connectionArrayLock) {
				long time = Calendar.getInstance().getTimeInMillis();
				for (User u : Data.connectionArray) {
					if (time - u.getLastActiveTime() >=  Data.deelay) {
						u.setActive(false);
					}
				}
			}
		}

	}

}
