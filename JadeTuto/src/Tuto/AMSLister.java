package Tuto;

import jade.core.Agent;
import jade.core.AID;

import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.*;

public class AMSLister extends Agent {
	protected void setup() {
		AMSAgentDescription[] agents = null;
		try {
			SearchConstraints c = new SearchConstraints();
			c.setMaxResults(new Long(-1));
			agents = AMSService.search(this, new AMSAgentDescription(), c);
		} catch (Exception e) {
			System.out.println("Erreur " + e);
			e.printStackTrace();
		}

		System.out.println("----- Agent AMS Lister ----- ");
		for (int i = 0; i < agents.length; i++) {
			AID agentID = agents[i].getName();
			System.out.print("    " + i + ": " + agentID.getName());
			if (agentID.equals(getAID()))
				System.out.print(" <----- C'est moi ");
			System.out.println("");
		}
		System.out.println("---------------------------- ");

	}

}