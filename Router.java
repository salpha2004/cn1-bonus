import java.util.HashMap;
import java.util.Vector;

/* common functions between an ipv6-capable router and an ipv4-capable router
 * are implemented in this class.
 */
class Router {
	/* 	key = destination subnet
		value = next router's reaching interface */
	HashMap<String, Integer> routingTable;
	/* list of directly connected routers to this router. */
	Vector<Router> connectedRouters;
	/* router type: "v4" or "v6" */
	String type;
	String addr;

	Router () {
		routingTable = new HashMap<String, Integer> ();
		connectedRouters = new Vector<Router> ();
	}

	public String getType () {
		return type;
	}

	public Router nextRouter (Packet packet) {
		Router targetRouter = null;
		if ( routingTable.containsKey (packet.getDstMasked()) ) {
			Integer targetInterface = routingTable.get(packet.getDstMasked());
			targetRouter = connectedRouters.get(targetInterface);
		}
		return targetRouter;
	}

	public void route (Packet packet) {
		// TODO: what to do if src and dst of the packet were in a same subnet?
		if ( routingTable.containsKey (packet.getDstMasked()) ) {
			Integer targetInterface = routingTable.get(packet.getDstMasked());
			Router targetRouter = connectedRouters.get(targetInterface);
			targetRouter.recv (packet);
		}
		else {
			System.err.println ("[ERR] route not found: " + packet.getDst());
		}
	}

	/* 'addr' is the subnet address (i.e. combined with subnet mask. e.g. 192.168.1.X for subnet 24).
	 * subnet should always be written with "X"s.
	 * 'ifNo' is the interface number which packets destined for 'addr' should be sent to.
	 */
	public void addRoute (String addr, int ifNo) {
		// TODO: how to initially fill the routing table? a better way than hard-coding?
		/* arg1: destination subnet
		 * arg2: local (this router) interface to put the packet on
		 */
		routingTable.put (addr, ifNo);
	}

	/* function 'recv' is called by other routers when they want to
	 * pass a packet to this router. */
	public void recv (Packet packet) {
		System.out.println ("## ROUTED ##   src: " + packet.getSrc());
		System.out.println ("## ROUTED ##   dst: " + packet.getDst());
		System.out.println ("-------------");
	}
}
