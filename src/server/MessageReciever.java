package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public final class MessageReciever {

	public static String recieveMessages(User user) {
		try {
			if (user.getInput().ready()) {
				String message = user.getInput().readLine();
				if (!user.isLoggedIn()) {
					try {
						UserLogging.logUserIn(user, message);
						message = "User " + user.getId() + " logged in!";
						System.out.println(message);
					} catch (Exception e) {
						user.sendMessage(e.getMessage());
					}
				} else {
					user.keepAlive();
					try {
						processPrvMessage(message);
					} catch (RuntimeException e) {
						user.sendMessage(e.getMessage());
					}
					System.out.println(user.getId() + ": " + message);
				}
				return message;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void processPrvMessage(String message) throws RuntimeException {
		String[] splittedMessage = message.split(",");
		if (splittedMessage.length != 3)
			throw new RuntimeException("Wrong message pattern. Correct: yourusername,otherusername,messagetosend!");
		String fromUserId = splittedMessage[0];
		String toUserId = splittedMessage[1];
		String messageToSend = splittedMessage[2];

		User fromUser = UserSearcher.searchForUserById(fromUserId);
		User destUser = UserSearcher.searchForUserById(toUserId);
		if (fromUser == null || destUser == null) {
			throw new RuntimeException("Cant process message");
		}
		destUser.keepAlive();
		MessageSender.send(messageToSend, destUser, fromUser);

	}

}
