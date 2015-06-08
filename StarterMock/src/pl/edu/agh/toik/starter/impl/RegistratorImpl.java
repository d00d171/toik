package pl.edu.agh.toik.starter.impl;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import pl.edu.agh.toik.common.ConfigurationParameters;
import pl.edu.agh.toik.starter.Registrator;

public class RegistratorImpl implements Registrator{

	private Map<InetAddress, Integer> registeredWorkspaces = new HashMap<InetAddress, Integer>();
	
	@Override
	public void registrate(InetAddress address, Integer id) {
		System.out.println("Registering new agent: " + address +  " " + id);
	}

	@Override
	public Properties getProperties() {
		Properties prop = new Properties();
		prop.put(ConfigurationParameters.AGENTS_COUNT, 5);
		prop.put(ConfigurationParameters.POPULATION_SIZE, 10);
		prop.put(ConfigurationParameters.STEPS_COUNT, 10);
		return prop;
	}

}
