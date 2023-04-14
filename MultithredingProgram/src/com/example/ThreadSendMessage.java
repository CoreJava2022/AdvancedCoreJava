package com.example;

public class ThreadSendMessage extends Thread{

	private String msg;
	MessageSender sender;
	
	//Receives a message object and a string
	//Message to be send
	ThreadSendMessage(String m, MessageSender obj){
		msg = m;
		sender = obj;
	}
	
	public void run() {
		synchronized(sender){
			sender.send(msg);
		}
	}

}
