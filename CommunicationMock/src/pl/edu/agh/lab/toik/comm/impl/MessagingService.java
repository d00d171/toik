package pl.edu.agh.lab.toik.comm.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import pl.edu.agh.lab.toik.comm.IMessageObserver;
import pl.edu.agh.lab.toik.comm.Message;

@SuppressWarnings("restriction")
@WebService(endpointInterface = "pl.edu.agh.lab.toik.comm.IMessagingService", serviceName = "IMessagingService")
public class MessagingService implements IMessagingService {

	private List<IMessageObserver> messageHandlers;

	public MessagingService() {
		messageHandlers = new ArrayList<IMessageObserver>();
	}

	@WebMethod(exclude = true)
	public List<IMessageObserver> getMessageHandlers() {
		return messageHandlers;
	}

	@WebMethod(exclude = true)
	public void setMessageHandlers(List<IMessageObserver> messageHandlers) {
		this.messageHandlers = messageHandlers;
	}

	public void invokeCommunication(Message message) {
		for (IMessageObserver messageObserver : messageHandlers)
			messageObserver.handleIncomingMessage(message);
	}

	@WebMethod(exclude = true)
	public void addMessageHandler(IMessageObserver observer) {
		messageHandlers.add(observer);
	}

	@WebMethod(exclude = true)
	public void removeMessageHandler(IMessageObserver observer) {
		messageHandlers.remove(observer);
	}

}
