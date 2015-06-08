package pl.edu.agh.lab.toik.comm;

public interface ICommunicator {

	public void init(String id);

	public void sendMessage(Message message, String destination);

	public void addMessageObserver(IMessageObserver observer);

	public void removeMessageObserver(IMessageObserver observer);

}