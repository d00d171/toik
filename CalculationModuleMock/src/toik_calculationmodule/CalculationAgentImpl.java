package toik_calculationmodule;

import java.util.Properties;

import pl.edu.agh.toik.common.Population;
import pl.edu.agh.toik.topology.TopologyCreator;
import pl.edu.agh.toik.workplace.IWorkplace;

public class CalculationAgentImpl implements CalculationAgent{

	@Override
	public boolean initializeAgent(IWorkplace workplace,
			Properties configuration, TopologyCreator topology, Integer id) {
		//Tutaj sobie niby przetwarzaja konfiguracje otrzymana w argumencie configuration i sie przygotowuja do odpalenia
		return false;
	}
	
	@Override
	public void step() {
		//TUTAJ sie dziej� kolejne akcje w danym kroku, moze tez byc cos wyslane
	}

	@Override
	public void injectPopulation(Population population) {
		//uzywane przez workplace jak trzeba przekazac populacje wyslana od innego agenta
	}

}
