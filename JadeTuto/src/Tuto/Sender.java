package Tuto;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;
import jade.lang.acl.*;

public class Sender extends Agent {
	protected void setup() {
		
		addBehaviour(new TickerBehaviour(this, 1500) {
			@Override
			protected void onTick() {
				ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
				msg.setContent("Ping");
				msg.addReceiver(new AID("Receiver", AID.ISLOCALNAME));
				send(msg);
			}
		});

		
		
		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				ACLMessage msg = receive();
				if (msg != null)
					System.out.println("== Answer" + " <- " + msg.getContent() + " from " + msg.getSender().getName());
				block();
			}
		});

	}
}
