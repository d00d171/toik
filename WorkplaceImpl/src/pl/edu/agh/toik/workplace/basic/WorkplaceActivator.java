package pl.edu.agh.toik.workplace.basic;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import pl.edu.agh.lab.toik.comm.ICommunicator;
import pl.edu.agh.toik.starter.Registrator;
import pl.edu.agh.toik.workplace.IWorkplace;

public class WorkplaceActivator implements BundleActivator{

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Workplace activator start");

		ServiceReference starterService = context.getServiceReference(Registrator.class.getName());
		Registrator registrator = context.getService(starterService);
		
		ServiceReference communicatorService = context.getServiceReference(ICommunicator.class.getName());
		ICommunicator communicator = context.getService(communicatorService);
		
		//Czy dodatkowo potrzebujmy modulu topologii zeby mu wstrzyknac konfiguracje?????
		
		Dictionary props = new Hashtable();
		context.registerService(IWorkplace.class, new BasicWorkplace(registrator, communicator), props);
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Workplace activator stop");
	}

}
