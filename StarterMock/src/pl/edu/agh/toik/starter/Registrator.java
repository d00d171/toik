package pl.edu.agh.toik.starter;

import java.net.InetAddress;
import java.util.Properties;

public interface Registrator {

	public void registrate(InetAddress address, Integer id);

	//TODO tego ma docelowo nie byc
	public Properties getProperties();
	
}
