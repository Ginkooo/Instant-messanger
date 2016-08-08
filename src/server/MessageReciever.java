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
					UserLogging.logUserIn(user, message);
					message = "User " + user.getId() + " logged in!";
					System.out.println(message);
				} else {
					user.keepAlive();
					System.out.println(user.getId() + ": " + message);
				}
				return message;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
