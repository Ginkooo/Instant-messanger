package server;

public final class MessageSender {

	public static void sendToAll(String message, User user) {
		message = user.getId() + ": " + message;
		for (User u : Data.connectionArray) {
			u.sendMessage(message);
		}
	}
	
	public static void send(String message, User destUser, User fromUser) {
		message = "From " + fromUser.getId() + ": " + message;
		for (User user: Data.connectionArray) {
			if (user.getId().equals(destUser.getId())) {
				user.sendMessage(message);
				return;
			}
		}
		fromUser.sendMessage("There is no user like " + destUser.getId());
	}
	
	
}
