class Router4 extends Router {

	Router4 (Strng addr, Router myNext, Router myPrev) {
		super();
		this.addr = addr;
		connectedRouters.add (myNext);
		connectedRouters.add (myPrev);
		type = "v4";
	}
}
