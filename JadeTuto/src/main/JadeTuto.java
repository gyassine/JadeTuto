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

		
		
		// Notre premier agent (qui blink toutes les sec.)
		AgentController agentController00;

		try {
			agentController00 = containerController.createNewAgent("MyAgent", "Tuto.MyAgent", null);
			agentController00.start();
		} catch (StaleProxyException e) {
			e.printStackTrace();
		}


		// Notre premier message entre agents (ping-pong toutes les 1.5 sec)
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
