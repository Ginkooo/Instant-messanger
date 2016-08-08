package server;

public final class UserLogging {

	public static void logUserIn(User user, String loginMessage) throws Exception {
		if (!isUsernameAvaliable(loginMessage)) {
			System.err.println("Exception occured");
			throw new Exception("Username unavaliable!");
		}
		user.setId(loginMessage);
		user.setLoggedIn(true);
	}
	
	private static boolean isUsernameAvaliable(String login) {
		for (User user: Data.connectionArray) {
			if (login.equals(user.getId())) {
				return false;
			}
		}
		return true;
	}
	
}
