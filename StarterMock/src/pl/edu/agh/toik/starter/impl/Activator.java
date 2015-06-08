package pl.edu.agh.toik.starter.impl;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import pl.edu.agh.toik.starter.Registrator;

public class Activator implements BundleActivator{

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Start activator start");
		Dictionary<String, String> props = new Hashtable<String, String>();
		context.registerService(Registrator.class, new RegistratorImpl(), props);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Start activator stop");
	}

}
