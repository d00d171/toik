package pl.edu.agh.lab.toik.comm.impl;

import java.rmi.RemoteException;
import java.util.regex.Pattern;

import pl.edu.agh.lab.toik.comm.ICommunicator;
import pl.edu.agh.lab.toik.comm.IMessageObserver;
import pl.edu.agh.lab.toik.comm.Message;

public class WSCommunicator implements ICommunicator {

	private final String ID_PATTERN_REGEX = "(http://)(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}):(\\d+)(/)(\\S+)";
	private final Pattern ID_PATTERN = Pattern.compile(ID_PATTERN_REGEX);

	private MessagingService localService;


	public void sendMessage(Message message, String destination) {
		System.out.println("Message sent");
	}

	public void addMessageObserver(IMessageObserver observer) {
		System.out.println("Message added");
	}

	public void removeMessageObserver(IMessageObserver observer) {
	}

	@Override
	public void init(String id) {
		// TODO Auto-generated method stub
		
	}
}
