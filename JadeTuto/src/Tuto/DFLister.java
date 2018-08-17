package Tuto;

import java.util.concurrent.TimeUnit;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class DFLister extends Agent {

	protected void setup() {
		// Une petite pause le temps que tous les agents s'enregistrent...
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----- Agent DF Lister ----- ");

		try {
			DFAgentDescription dfd = new DFAgentDescription();
			DFAgentDescription[] result = DFService.search(this, dfd);
			// Liste de tous les éléments de l'annuaire
			System.out.println("Présent ds l'annuaire: " + result.length + " elements");
			for (int i = 0; i < result.length; i++)
				System.out.println(" " + result[i].getName());

			ServiceDescription sd = new ServiceDescription();

			// Liste des agents qui fournisse le service 1
			sd.setType("Service1");
			dfd.addServices(sd);
			result = DFService.search(this, dfd);
			System.out.println("Fournisseur de Service 1: " + result.length + " elements");
			for (int i = 0; i < result.length; i++)
				System.out.println(" " + result[i].getName().getLocalName());

			// Liste des agents qui fournisse le service 2
			sd.setType("Service2");
			dfd.addServices(sd);
			result = DFService.search(this, dfd);
			System.out.println("Fournisseur de Service 2: " + result.length + " elements");
			for (int i = 0; i < result.length; i++)
				System.out.println(" " + result[i].getName().getLocalName());

		} catch (FIPAException fe) {
			fe.printStackTrace();
		}
		System.out.println("-------------------------------- ");
	}

	AID getService(String service) {
		DFAgentDescription dfd = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		sd.setType(service);
		dfd.addServices(sd);
		try {
			DFAgentDescription[] result = DFService.search(this, dfd);
			if (result.length > 0)
				return result[0].getName();
		} catch (Exception fe) {
		}
		return null;
	}

}
