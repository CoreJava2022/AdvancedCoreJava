package com.example;

public class SynchDemo {

	public static void main(String[] args) {
		
		MessageSender sender = new MessageSender();
		
		ThreadSendMessage m1 = new ThreadSendMessage("Hi class started", sender);
		
		ThreadSendMessage m2 = new ThreadSendMessage("bye class over", sender);

		//Start two thread of threaded Send type
		m1.start();
		m2.start();
		
		//Wait for threads to send
		try {
			m1.join();
			m2.join();
		}catch(Exception e) {
			System.out.println("Interrupted");
		}
	}

}
