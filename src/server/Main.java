package server;

public class Main {

	public static void main(String[] args) {
		AcceptLoop.acceptLoop.start();
		MessageReciever.messageReciever.start();
		ConnectionCleaner.connectionCleaner.start();
		ConnectionAliveChecker.connectionAliveChecker.start();

	}

}
