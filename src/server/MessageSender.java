package server;

public final class MessageSender {

	public static void sendToAll(String message, User user) {
		message = user.getId() + ": " + message;
		for (User u : Data.connectionArray) {
			u.sendMessage(message);
		}
	}
}
