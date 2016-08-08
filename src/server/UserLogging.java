package server;

public final class UserLogging {

	public static void logUserIn(User user, String loginMessage) {
		user.setId(loginMessage);
		user.setLoggedIn(true);
	}
	
}
