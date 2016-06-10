class Topology {
	public static void main (String[] args) {
		Router4 r4 = new Router4();
		Router6 r6 = new Router6(r4, r4);
		Packet p1 = new Packet (4, "192.168.0.1", "192.168.0.2");
		r6.route (r4, p1);
	}
}