package pl.edu.agh.toik.workplace.basic;

import java.net.InetAddress;

import pl.edu.agh.lab.toik.comm.ICommunicator;
import pl.edu.agh.lab.toik.comm.IMessageObserver;
import pl.edu.agh.lab.toik.comm.Message;
import pl.edu.agh.lab.toik.comm.MessageType;
import pl.edu.agh.toik.starter.Registrator;
import pl.edu.agh.toik.workplace.IWorkplace;

public class BasicWorkplace implements IWorkplace, IMessageObserver{
	
	private ICommunicator communicator;
	private Registrator registrator;
	
	public BasicWorkplace(Registrator registrator, ICommunicator communicator){
		this.communicator = communicator;
		registrator.registrate(getWorkplaceAddress(), getWorkplaceId()); //dlaczemu tutaj pierwszy parametr to ma byc inet address
		communicator.init(getWorkplaceAddress().getCanonicalHostName());  //a tutaj juz string ?
		communicator.addMessageObserver(this);
	}

	@Override
	public void handleIncomingMessage(Message message) {

		if(message.getType().equals(MessageType.CONFIG)){
			handleConfigurationMessage(message.getValue());
		}
		
		if(message.getType().equals(MessageType.WORPLACE_INIT)){
			handleInitMessage();
		}
		
		if(message.getType().equals(MessageType.POPULATION)){
			handlePopulationMessage(message.getValue());
		}
	}
	
	//To zostaje tak jak jest
	@Override
	public void sendPopulationToAgent(Object population, String agentAddress) {
		Message message = new Message();
		message.setType(MessageType.POPULATION);
		message.setValue(population);
		communicator.sendMessage(message, agentAddress);
	}
	
	private void handleConfigurationMessage(Object value){
		//TODO obs³uga pocz¹tkowej konfiguracji
		//konfiguracja i przygotowanie agentów
		//konfiguracja i przygotowanie topologii ????
	}
	
	private void handleInitMessage(){
		//TODO obs³uga startowania i kroków kolejnych
	}
	
	private void handlePopulationMessage(Object population) {
		//TODO obs³uga wstrzykiwania populacji
	}

	private InetAddress getWorkplaceAddress(){
		//TODO zwracanie ip
		return null;
	}
	
	private Integer getWorkplaceId(){
		//TODO co to za id oni chc¹?
		return 1;
	}
	
}
