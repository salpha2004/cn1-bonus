class Router4 extends Router {

	Router4 (Router myNext, Router myPrev) {
		super();
		connectedRouters.add (myNext);
		connectedRouters.add (myPrev);
		type = "v4";
	}
}
