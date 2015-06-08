package toik_calculationmodule;

public class PopulationMessageValue {

	private Integer agentId;
	
	private Population population;
	
	public PopulationMessageValue(Integer agentId, Population population) {
		this.agentId = agentId;
		this.population = population;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public Population getPopulation() {
		return population;
	}

	public void setPopulation(Population population) {
		this.population = population;
	}
	
}
