import java.util.HashMap;
import java.util.Vector;

class Router {
	/* 	key = destination subnet
		value = next router's reaching interface */
	HashMap<String, Integer> routingTable;
	/* list of directly connected routers to this router. */
	Vector<Router> connectedRouters;
	/* router type: v4 or v6 */
	String type;
	public String getType () {
		return type;
	}
	/* function 'recv' is called by other routers when they want to
	 * pass a packet to this router. */
	public void recv (Packet packet) {
		System.out.println ("src: " + packet.getSrc());
		System.out.println ("dst: " + packet.getDst());
	}
	Router () {
		routingTable = new HashMap<String, Integer> ();
		connectedRouters = new Vector<Router> ();
	}
}
