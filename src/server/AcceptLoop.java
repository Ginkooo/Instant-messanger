package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public final class AcceptLoop extends Thread {
	public static final AcceptLoop acceptLoop = new AcceptLoop();

	@Override
	public void run() {
		try {
		ServerSocket sSocket = new ServerSocket(Data.port);
		while (true) {
			Socket socket = sSocket.accept();
			synchronized (Data.connectionArrayLock) {
				Data.connectionArray.add(new User(socket));
				System.out.println(Data.connectionArray.size());
			}
		}
		} catch (IOException e) {
			
		}
	}
}
