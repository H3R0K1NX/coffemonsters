package Airports;

import Ido_Stack.Node;

public class Airport {
	private Node<Flight> flights;
	private Node<Flight> p;

	public Airport() {
		flights = new Node<Flight>();
		p = flights;
	}

	public Node<Flight> getFlights() {
		return flights;
	}

	public void addFlight(Flight f) {
		if (p == flights) {
			flights.setValue(f);
			flights.setNext(new Node<Flight>());
			p = flights.getNext();
		} else {
			if (p.getValue() == null)
				p.setValue(f);
			else {
				p.setNext(new Node<Flight>(f));
				p = p.getNext();
			}
		}
	}

}
