package pl.edu.agh.lab.toik.comm.impl;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pl.edu.agh.lab.toik.comm.ICommunicator;
import pl.edu.agh.lab.toik.comm.IMessageObserver;
import pl.edu.agh.lab.toik.comm.Message;

public class TCPCommunicator implements ICommunicator {

	private final String ID_PATTERN_REGEX = "(http://)(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}):(\\d+)(/)(\\S+)";
	private final Pattern ID_PATTERN = Pattern.compile(ID_PATTERN_REGEX);
	private MessagingService localService;

	public void init(String id) {
		Matcher idMatcher = ID_PATTERN.matcher(id);
		if (!idMatcher.matches())
			throw new RuntimeException("Provided wrong identifier");

		System.setSecurityManager(null);

		try {
			localService = new MessagingService();
			IMessagingService stub = (IMessagingService) UnicastRemoteObject
					.exportObject(localService, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(idMatcher.group(5), stub);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(Message message, String destination) {
		Matcher idMatcher = ID_PATTERN.matcher(destination);
		if (!idMatcher.matches())
			throw new RuntimeException("Provided wrong destination id");

		try {
			Registry registry = LocateRegistry.getRegistry(idMatcher.group(2));
			IMessagingService remoteService = (IMessagingService) registry
					.lookup(idMatcher.group(5));
			remoteService.invokeCommunication(message);
		} catch (AccessException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addMessageObserver(IMessageObserver observer) {
		localService.addMessageHandler(observer);
	}

	public void removeMessageObserver(IMessageObserver observer) {
		localService.removeMessageHandler(observer);
	}

}
