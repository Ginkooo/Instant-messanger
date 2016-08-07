package server;

public final class MessageSender {
	public static void sendToAll(String message, User user) {
		message = user.getId() + ": " + message;
		synchronized(Data.connectionArrayLock) {
			for (User u: Data.connectionArray) {
				u.sendMessage(message);
			}
		}
	}
}
