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

		// Ex 1: Notre premier agent (qui blink toutes les sec.)
		AgentController agentController00;

		try {
			agentController00 = containerController.createNewAgent("MyAgent", "Tuto.MyAgent", null);
			agentController00.start();
		} catch (StaleProxyException e) {
			e.printStackTrace();
		}

		// Ex 2: Notre premier message entre agents (ping-pong toutes les 1.5 sec)
		AgentController agentController01, agentController02;

		try {
			agentController01 = containerController.createNewAgent("Sender", "Tuto.Sender", null);
			agentController01.start();
			agentController02 = containerController.createNewAgent("Receiver", "Tuto.Receiver", null);
			agentController02.start();
		} catch (StaleProxyException e) {
			e.printStackTrace();
		}

		// Ex 3: Liste des agents via AMS
		AgentController agentController03;

		try {
			agentController03 = containerController.createNewAgent("AMSLister", "Tuto.AMSLister", null);
			agentController03.start();
		} catch (StaleProxyException e) {
			e.printStackTrace();
		}
		/** **/
		// Ex 4: Liste des agents via DF
		AgentController ac04, ac05, ac06, ac07, ac08, ac09;
		Object[] argsAgent1 = new Object[1];
		argsAgent1[0] = "Service1";

		Object[] argsAgent2 = new Object[1];
		argsAgent2[0] = "Service2";

		try {
			ac04 = containerController.createNewAgent("AgentFS1", "Tuto.AgentFS", argsAgent1);
			ac04.start();
			ac05 = containerController.createNewAgent("AgentFS2", "Tuto.AgentFS", argsAgent1);
			ac05.start();
			ac06 = containerController.createNewAgent("AgentFS3", "Tuto.AgentFS", argsAgent2);
			ac06.start();
			ac07 = containerController.createNewAgent("AgentFS4", "Tuto.AgentFS", argsAgent2);
			ac07.start();
			ac08 = containerController.createNewAgent("AgentFS5", "Tuto.AgentFS", argsAgent2);
			ac08.start();
			ac08 = containerController.createNewAgent("DFLister", "Tuto.DFLister", null);
			ac08.start();
		} catch (StaleProxyException e) {
			e.printStackTrace();
		}

	}

}
