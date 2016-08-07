package server;

import java.util.Calendar;

public final class ConnectionAliveChecker {

	public static void checkIfAlife(User user) {

		long time = Calendar.getInstance().getTimeInMillis();
		if (time - user.getLastActiveTime() >= Data.deelay) {
			user.setActive(false);
		}
	}

}
