package toik_calculationmodule;

import java.util.Properties;

import pl.edu.agh.toik.topology.TopologyCreator;
import pl.edu.agh.toik.workplace.IWorkplace;

public interface CalculationAgent {
	boolean initializeAgent(IWorkplace workplace, Properties configuration, TopologyCreator topology);
	void step();
	void injectPopulation(Population population);
}
