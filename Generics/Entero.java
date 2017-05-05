public class Entero implements SumCom<Entero> {
	int e;
	public Entero(int e) {
		this.e = e;
	}
	public Entero suma(Entero that) {
		return new Entero(this.e + that.e);
	}
        
        public Entero mult(Entero that) {
            return new Entero(this.e * that.e);
        }

	public String toString() {
		return this.e + "";
	}
}