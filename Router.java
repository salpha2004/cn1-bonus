import java.util.HashMap;
import java.util.Vector;

class Router {
	/* 	key = destination subnet
		value = next router's reaching interface */
	HashMap<String, Integer> routingTable;
	Vector<Router> connectedRouters;
	String type;
	public String getType () {
		return type;
	}
	public void recv (Packet packet) {
		System.out.println ("src: " + packet.getSrc());
		System.out.println ("dst: " + packet.getDst());
	}
	Router () {
		routingTable = new HashMap<String, Integer> ();
		connectedRouters = new Vector<Router> ();
	}
}