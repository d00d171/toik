package pl.edu.agh.toik.workplace;

import pl.edu.agh.toik.common.Population;

public interface IWorkplace {

	//Dla agent�w
	public void sendPopulationToAgent(Population population, String workplaceAddress, Integer agentId);
	
}
