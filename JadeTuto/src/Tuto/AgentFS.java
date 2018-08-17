package Tuto;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class AgentFS extends Agent {

	protected void setup() {
		System.out.println("----- Agent Fournisseur de service ----- ");
		System.out.println(getArguments()[0].toString());
		ServiceDescription sd = new ServiceDescription();
		sd.setType(getArguments()[0].toString());
		sd.setName(getLocalName());
		register(sd);

		System.out.println("-------------------------- ");
		System.out.println(" ");

	}

	void register(ServiceDescription sd) {
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());
		dfd.addServices(sd);

		try {
			DFService.register(this, dfd);
		} catch (FIPAException fe) {
			fe.printStackTrace();
		}
	}

}
