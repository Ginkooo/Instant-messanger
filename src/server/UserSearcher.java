package server;

public final class UserSearcher {
	
	public static User searchForUserById(String id) {
		for (User user: Data.connectionArray) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

}
