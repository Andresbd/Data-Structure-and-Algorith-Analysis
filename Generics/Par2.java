public class Par2<S extends SumCom<S>> {

	S s1, s2;


	public S getPrimer() {
		return s1;
	}

	public S getSegundo() {
		return s2;
	}

	public Par2(S s1, S s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	public void setPrimer(S s1) {
		this.s1 = s1;
	}

	public void setSegundo(S s2) {
		this.s2 = s2;
	}

	public String toString() {
		return s1 + " " + s2;
	}

	public S suma() {
		return s1.suma(s2);
	}
}