package pl.edu.agh.toik.common;

public enum ConfigurationParameters {
	
	STEPS_COUNT("STEPS_COUNT"), AGENTS_COUNT("AGENTS_COUNT"), POPULATION_SIZE("POPULATION_SIZE"), STEP_ACTIONS("STEP_ACTIONS"), WORKPLACE_ADDRESSES("STEP_ACTIONS");
	
	String value;
	ConfigurationParameters(String value){
		this.value = value;
	}
}
