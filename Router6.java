class Router6 extends Router {
	
	void initIpTable () {
		// TODO: how to initially fill the routing table? a better way than hard-coding?
		/* arg1: destination subnet
		 * arg2: local (this router) interface to put the packet on
		 */
		routingTable.put ("192.168.0.X", 0);
	}

	Router6 (Router myNext, Router myPrev) {
		super();
		connectedRouters.add (myNext);
		connectedRouters.add (myPrev);
		initIpTable();
		type = "v6";
	}

	/* in practice, route function should only take the packet to route. next router
	 * is passed here so that the router knows whether it should tunnel or not. */
	public void route (Router next, Packet packet) {
		if (next.getType().equals ("v4")) {
			if (packet.getVersion() == 6) {
				// TODO: tunnel (pack)
			}
			/* in case 'packet' was ipv6, it's wrapped in an ipv4 packet above,
			and routed as a normal v4 packet.
			in case 'packet' was ipv4, it's not manipulated and is normally routed
			like v4. */
			super.route (packet); /* normal routing. */
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
