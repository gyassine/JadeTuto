package Tuto;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class MyAgent extends Agent {

	protected void setup() {
		System.out.println("----- Agent MyAgent ----- ");
		System.out.println("Je suis le tout premier Agent: " + 
				getLocalName() + " appelé aussi " + getAID().getName());
		System.out.println("-------------------------- ");
		System.out.println(" ");
		addBehaviour(new TickerBehaviour(this, 1000) {
			@Override
			protected void onTick() {
				System.out.println("MyAgent -----> Blink ");
			}
		});

	}


}
