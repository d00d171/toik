package pl.agh.lab.toik.communicationmock;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import pl.edu.agh.lab.toik.comm.ICommunicator;
import pl.edu.agh.lab.toik.comm.impl.WSCommunicator;

public class Activator implements BundleActivator {
	private ServiceRegistration<ICommunicator> serviceRegistration;

	public void start(BundleContext context) throws Exception {
		ICommunicator service = new WSCommunicator();
		
		serviceRegistration = context.registerService(ICommunicator.class, service, null);
		System.out.println("Communication registered");
	}
	
	public void stop(BundleContext context) throws Exception {
		System.out.println("Communication exit");
	}

}
