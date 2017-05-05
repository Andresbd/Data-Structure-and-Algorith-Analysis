public class Par<S,U> {
	S s;
	U u;

	public S getPrimer() {
		return s;
	}

	public U getSegundo() {
		return u;
	}

	public Par(S s, U u) {
		this.s = s;
		this.u = u;
	}

	public void setPrimer(S s) {
		this.s = s;
	}

	public void setSegundo(U u) {
			this.u = u;
	}

	public String toString() {
		return s + " " + u;
	}
}