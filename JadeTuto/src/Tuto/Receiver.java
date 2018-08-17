package Tuto;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.*;

public class Receiver extends Agent {
	protected void setup() {
		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				ACLMessage msg = receive();
				if (msg != null) {
					System.out.println("PingPong : - " + myAgent.getLocalName() + " <- " + msg.getContent());
					
					ACLMessage reply = msg.createReply();
					reply.setPerformative(ACLMessage.INFORM);
					reply.setContent(" Pong");
					send(reply);
				}
				block();
			}
		});
	}
}
