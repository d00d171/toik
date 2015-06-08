package pl.edu.agh.toik.workplace.basic;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import pl.edu.agh.lab.toik.comm.ICommunicator;
import pl.edu.agh.lab.toik.comm.Message;
import pl.edu.agh.lab.toik.comm.MessageType;
import pl.edu.agh.toik.starter.Registrator;
import pl.edu.agh.toik.workplace.IWorkplace;

public class WorkplaceActivator implements BundleActivator{

	ServiceRegistration<IWorkplace> workplaceService;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Workplace activator start");

		ServiceReference starterService = context.getServiceReference(Registrator.class.getName());
		Registrator registrator = context.getService(starterService);
		
		ServiceReference communicatorService = context.getServiceReference(ICommunicator.class.getName());
		ICommunicator communicator = context.getService(communicatorService);
		
		Dictionary props = new Hashtable();
		BasicWorkplace workplace = new BasicWorkplace(registrator, communicator);
		workplaceService = context.registerService(IWorkplace.class, workplace, props);
		
		//TODO do usuniêcia, tymczasowo dla u³atwienia tylko ---START---
		//msg z konfiguracja od startera
		Message msg = new Message();
		msg.setType(MessageType.CONFIG);
		msg.setValue(registrator.getProperties());
		workplace.handleIncomingMessage(msg);
		
		//msg z info ze pora zaczac dzialac od startera
		msg = new Message();
		msg.setType(MessageType.WORPLACE_INIT);
		workplace.handleIncomingMessage(msg);
		//do usuniecia ---END---
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Workplace activator stop");
	}

}
