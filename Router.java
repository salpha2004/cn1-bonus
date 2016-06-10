import java.util.HashMap;
import java.util.Vector;

/* common functions between an ipv6-capable router and an ipv4-capable router
 * are implemented in this class.
 */
class Router {
	/* 	key = destination subnet
		value = next router's reaching interface */
	HashMap<String, Integer> routingTable;
	Vector<Router> connectedRouters;
	String type;

	Router () {
		routingTable = new HashMap<String, Integer> ();
		connectedRouters = new Vector<Router> ();
	}

	public String getType () {
		return type;
	}

	public void route (Packet packet) {
		if ( routingTable.containsKey (packet.getDstMasked()) ) {
			Integer targetInterface = routingTable.get(packet.getDstMasked());
			Router targetRouter = connectedRouters.get(targetInterface);
			targetRouter.recv (packet);
		}
		else {
			System.err.println ("[ERR] route not found: " + packet.getDst());
		}
	}

	public void recv (Packet packet) {
		System.out.println ("src: " + packet.getSrc());
		System.out.println ("dst: " + packet.getDst());
	}
}