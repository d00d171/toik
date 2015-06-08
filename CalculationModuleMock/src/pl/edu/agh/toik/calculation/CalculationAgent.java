package pl.edu.agh.toik.calculation;

public interface CalculationAgent {
	//TODO poki co to jest interfejs od nich, cos z tym trzeba zrobic
	boolean initializeAgent(Configuration configuration, TopologyCreator topology);
	void destructAgent();
	void startSimulation();
	void injectPopulation(Population population);
}
