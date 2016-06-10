class Router4 extends Router {
	Router4 () {
		type = "v4";
	}
	public void route (Router next, Packet packet) {
		System.out.println ("next is next!");
	}
}
