
public class ExtendedEuclid {
	
	long a, b, c, res;
	
	public OpResult EE(long a, long b) {
		OpResult r, rPrima, rResult;
		long d;
		long x,y;
		if (b == 0) {
			
			r = new OpResult(a,1,0);
			return r;
			
		}else {
			
			c = a%b;
			
			rPrima = EE(b,c);
			d = rPrima.getD();
			x = rPrima.getY();
			y = (long) (rPrima.getX() - Math.floor(a/b) * rPrima.getY());
					
			rResult	= new OpResult(d,x,y);
			
			res = rResult.getX();
					
			return rResult;
		
		
	}
	}
}
