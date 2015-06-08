package pl.edu.agh.toik.starter;

import java.net.InetAddress;
import java.util.Properties;

public interface Registrator {

	public void registrate(InetAddress address);

	//TODO tego ma docelowo nie byc, przyda sie w mocku zeby zastartowac od razu
	public Properties getProperties();
	
}
