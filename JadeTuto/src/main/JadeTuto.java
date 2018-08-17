package main;

import jade.core.*;
import jade.core.Runtime;
import jade.wrapper.*;

public class JadeTuto {

	public static void main(String[] args) {
		Runtime runtime = Runtime.instance();
		Profile profile = new ProfileImpl();
		profile.setParameter(Profile.MAIN_HOST, "localhost");
		profile.setParameter(Profile.GUI, "true");
		ContainerController containerController = runtime.createMainContainer(profile);

		AgentController agentController01, agentController02;

		try {
			agentController01 = containerController.createNewAgent("Sender", "Tuto.Sender", null);
			agentController01.start();
			agentController02 = containerController.createNewAgent("Receiver", "Tuto.Receiver", null);
			agentController02.start();
		} catch (StaleProxyException e) {
			e.printStackTrace();
		}

	}

}
