class Topology {
	public static void main (String[] args) {
		Router6 r6 = new Router6(null, null);
		Router4 r4 = new Router4(r6, r6);
		Packet p1 = new Packet (4, "192.168.0.1", "192.168.10.2");
		r4.route (r6, p1);
	}
}