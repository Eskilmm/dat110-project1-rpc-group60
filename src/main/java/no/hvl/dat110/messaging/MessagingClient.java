package no.hvl.dat110.messaging;


import java.io.IOException;
import java.net.Socket;

import no.hvl.dat110.TODO;

public class MessagingClient {

	// name/IP address of the messaging server
	private String server;

	// server port on which the messaging server is listening
	private int port;
	
	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}
	
	// setup of a messaging connection to a messaging server
	public MessageConnection connect () {

		// client-side socket for underlying TCP connection to messaging server
		Socket clientSocket;

		MessageConnection connection = null;
		
		 try {
		        Socket clientSocket1 = new Socket(server, port);
		        connection = new MessageConnection(clientSocket1);
		    } catch (IOException ex) {
		        System.out.println("Error connecting to messaging server: " + ex.getMessage());
		        ex.printStackTrace();
		    }
		    return connection;
		
		
	}
}
