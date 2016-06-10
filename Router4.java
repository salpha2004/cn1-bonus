class Router4 extends Router {

	void initIpTable () {
		// TODO: how to initially fill the routing table? a better way than hard-coding?
		/* arg1: destination subnet
		 * arg2: local (this router) interface to put the packet on
		 */
		routingTable.put ("192.168.10.X", 0);
	}

	Router4 (Router myNext, Router myPrev) {
		super();
		connectedRouters.add (myNext);
		connectedRouters.add (myPrev);
		initIpTable();
		type = "v4";
	}

	/* router4 can only route ipv4 packets (normal routing w/o tunnelling). */
	public void route (Router next, Packet packet) {
		super.route (packet);
	}
}
