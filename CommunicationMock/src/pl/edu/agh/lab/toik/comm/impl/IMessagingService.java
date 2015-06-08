package pl.edu.agh.lab.toik.comm.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.jws.WebParam;
import javax.jws.WebService;

import pl.edu.agh.lab.toik.comm.Message;

@SuppressWarnings("restriction")
@WebService
public interface IMessagingService extends Remote {

	public void invokeCommunication(@WebParam(name = "message") Message message)
			throws RemoteException;

}
