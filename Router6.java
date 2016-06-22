class Router6 extends Router {
	Router6 (Router myNext, Router myPrev) {
		super();
		connectedRouters.add (myNext);
		connectedRouters.add (myPrev);
		// TODO: how to initially fill the routing table?
		routingTable.put ("192.168.0.2", 0);
		type = "v6";
	}

	void route4 (Packet packet) {
		if ( routingTable.containsKey (packet.getDst()) ) {
			Integer targetInterface = routingTable.get (packet.getDst());
			Router targetRouter = connectedRouters.get(targetInterface);
			targetRouter.recv (packet);
		}
		else {
			System.err.println ("route not found: " + packet.getDst());
		}
	}

	public void route (Router next, Packet packet) {
		if (next.getType().equals ("v4")) {
			if (packet.getVersion() == 6) {
				// TODO: tunnel (pack)
			}
			/* in case 'packet' was ipv6, it's wrapped in an ipv4 packet above,
			and routed as a normal v4 packet.
			in case 'packet' was ipv4, it's not manipulated and is normally routed
			like v4. */
			route4 (packet);
		}
		else if (next.getType().equals ("v6")) {
			/* how a v6 router notices if the newly arrived v4 packet was a 
			normal v4 packet or wrapped due to tunelling?
			since destination address is changed to the edge IPv6 router in case
			of tunnelling, the edge router understands that the newly arrived
			v4 packet is in fact and ipv6 packet wrapped in v4. */
			// TODO: unpack and route6
		}
	}
}
