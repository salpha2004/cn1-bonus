class Router6 extends Router {
	
	Router6 (String addr, Router myNext, Router myPrev) {
		super();
		this.addr = addr;
		connectedRouters.add (myNext);
		connectedRouters.add (myPrev);
		type = "v6";
	}

<<<<<<< HEAD
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
=======
	void pack (Packet packet) {
		Packet original = new Packet(packet);
		packet.setData (original);
		packet.setVersionTo4 ();
		packet.setSrc (addr);
		//packet.setDst (); // TODO: how to find dst addr?
	}

	/* in practice, route function should only take the packet to route. next router
	 * is passed here so that the router knows whether it should tunnel or not. */
	@Override
	public void route (Packet packet) {
		Router next = super.nextRouter (packet);
		/* ask the next router in the route if it supports IPv6. */
>>>>>>> 63aa34d0d0ff07d8dbbd4d260a9663a9a56809d9
		if (next.getType().equals ("v4")) {
			if (packet.getVersion() == 6) {
				pack (packet);
			}
			/* in case 'packet' was ipv6, it's wrapped in an ipv4 packet above,
			and routed as a normal v4 packet.
			in case 'packet' was ipv4, it's not manipulated and is normally routed
			like v4. */
			super.route (packet); /* normal routing. */
		}
		else if (next.getType().equals ("v6")) {
			if (packet.getVersion() == 4) {
				// check if it was a packed (tunnelled) packet
				/* how a v6 router notices if the newly arrived v4 packet was a 
				normal v4 packet or wrapped due to tunelling?
				since destination address is changed to the edge IPv6 router in case
				of tunnelling, the edge router understands that the newly arrived
				v4 packet is in fact and ipv6 packet wrapped in v4. */
				// TODO: unpack and route6

			}
			super.route (packet);
		}
	}
}
