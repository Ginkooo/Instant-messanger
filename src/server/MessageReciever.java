package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public final class MessageReciever extends Thread {
	public static final MessageReciever messageReciever = new MessageReciever();

	@Override
	public void run() {
		try {
			while (true) {
				synchronized (Data.connectionArrayLock) {
					for (User u : Data.connectionArray) {
						if (u.getInput().ready()) {
							String message = u.getInput().readLine();
							u.keepAlive();
							System.out.println(u.getId() + ": " + message);
							MessageSender.sendToAll(message, u);
						}
					}
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

}
