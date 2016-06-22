class Topology {
	public static void main (String[] args) {
		Router6 r6 = new Router6(null, null);
		Router4 r4 = new Router4(r6, r6);
		Router6 r6_1 = new Router6(r4, r6);
		r6_1.addRoute ("192.168.10.X", 0);
		r6_1.addRoute ("fe80:0000:0000:0000:X:X:X:X", 1);
		Packet p1 = new Packet (4, "192.168.0.1", "192.168.10.2");
		Packet p2 = new Packet (6, "fe85:0000:0000:0000:0201:2eff:fe35:30b3", "fe80:0000:0000:0000:0201:2eff:fe35:00b3");
		r6_1.route (p1);
		r6_1.route (p2);
	}
}