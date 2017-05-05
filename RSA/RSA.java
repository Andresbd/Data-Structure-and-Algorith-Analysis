public class RSA {

	long pResult;
	long qResult;
	long n;
	long e;
	long d;
	long phi;
	
	public void checarPrimos() {
		
		boolean pPrime, qPrime;
		
		pResult =  (long) ((Math.random() * 100) + 1);
		qResult =  (long) ((Math.random() * 100) + 1);
		
		pPrime = isPrime(pResult);
		qPrime = isPrime(qResult);
		
		if (pPrime && qPrime == true) {
			
			generadorNPHI();
		}else {
			
			checarPrimos();
		}
	}
	
	public void generadorNPHI() {
		
		n = pResult * qResult;
		phi = (pResult - 1) * (qResult - 1);
		
		generarE();
	}
	
	public void generarE() {
		
		boolean relPrim;
		
		e =  (long) ((Math.random() * phi - 1) + 1);
		
		relPrim = relativelyPrime(e, phi);
		
		if (relPrim == true) {
			
			ExtendedEuclid ext = new ExtendedEuclid();
			
			ext.EE(e, phi);
			
			d = ext.res;
			
			long test = d * e;
			test = test % phi;
			
			if (test != 1) {
				
				generarE();
			}
			

		}else {
			
			generarE();
		}
	}
	
	public void encrypt(long code) {
		
		long crypt, decrypt;
		
		checarPrimos();
		
		System.out.println("Valor de n = " + n);
		System.out.println("Valor de e = " + e);
		System.out.println("Valor de d = " + d);
		System.out.println("Valor de phi = " + phi);
		System.out.println("Valor de mensaje = " + code);
		
		crypt = expMod(code, 39423, 46927);
		
		System.out.println("Valor encriptado = " + crypt);
		
		inverseText(crypt);
		
		decrypt = expMod(21166, 26767, 46927);
		
		System.out.println("Valor desencriptado = " + decrypt);
		
	}
	
	public void inverseText(long a) {
		
		long decode = a;
		long[] result = new long[10];
		int i = 0;
		
		while (decode != 0) {
		
			result[i] = decode % 26;
			decode = decode / 26;
			i++;
			System.out.println(result[i]);
		}
		
		
	}
	
	public void textCode(String a) {
		
		long sum = 0;
		
		char[] split = a.toCharArray();
		
		for (int i = 0; i < split.length; i++) {
			
			switch (split[i]) {
			
			case 'a':
				
				sum = (long) (sum + (0* Math.pow(26, i)));
				
				break;
				
			case 'b':
				
				sum = (long) (sum + (1* Math.pow(26, i)));
				
				break;
			case 'c':
				
				sum = (long) (sum + (2* Math.pow(26, i)));
				
				break;
			case 'd':
				
				sum = (long) (sum + (3* Math.pow(26, i)));
				
				break;
			case 'e':
				
				sum = (long) (sum + (4* Math.pow(26, i)));
				
				break;
			case 'f':
				
				sum = (long) (sum + (5* Math.pow(26, i)));
				
				break;
			case 'g':
				
				sum = (long) (sum + (6* Math.pow(26, i)));
				
				break;
			case 'h':
				
				sum = (long) (sum + (7* Math.pow(26, i)));
				
				break;
			case 'i':
				
				sum = (long) (sum + (8* Math.pow(26, i)));
				
				break;
				
			case 'j':
				
				sum = (long) (sum + (9* Math.pow(26, i)));
				
				break;
			case 'k':
				
				sum = (long) (sum + (10* Math.pow(26, i)));
				
				break;
			case 'l':
				
				sum = (long) (sum + (11* Math.pow(26, i)));
				
				break;
			case 'm':
				
				sum = (long) (sum + (12* Math.pow(26, i)));
				
				break;
			case 'n':
				
				sum = (long) (sum + (13* Math.pow(26, i)));
				
				break;
			case 'o':
				
				sum = (long) (sum + (14* Math.pow(26, i)));
				
				break;
			case 'p':
				
				sum = (long) (sum + (15* Math.pow(26, i)));
				
				break;
			case 'q':
				
				sum = (long) (sum + (16* Math.pow(26, i)));
				
				break;
				
			case 'r':
				
				sum = (long) (sum + (17* Math.pow(26, i)));
				
				break;
			case 's':
				
				sum = (long) (sum + (18* Math.pow(26, i)));
				
				break;
			case 't':
				
				sum = (long) (sum + (19* Math.pow(26, i)));
				
				break;
			case 'u':
				
				sum = (long) (sum + (20* Math.pow(26, i)));
				
				break;
			case 'v':
				
				sum = (long) (sum + (21* Math.pow(26, i)));
				
				break;
			case 'w':
				
				sum = (long) (sum + (22* Math.pow(26, i)));
				
				break;
			case 'x':
				
				sum = (long) (sum + (23* Math.pow(26, i)));
				
				break;
			case 'y':
				
				sum = (long) (sum + (24* Math.pow(26, i)));
				
				break;
				
			case 'z':
				
				sum = (long) (sum + (25* Math.pow(26, i)));
				
				break;
			}
		}
		
		encrypt(sum);
	}
	
	public long expMod(long a, long b, long c) {
		
		long x = 1;
		long y = a;
		
		while (b > 0) {
			
			if (b%2 == 1) {
				
				x = (x * y)%c;
			}
			y = (y*y)%c;
			b /= 2;
		}
		
		return x%c;
	}
	
	boolean isPrime(long a) {
		
		if (a == 2 || a == 3) {
			
			return true;
		}
		
	    //check if n is a multiple of 2
	    if (a%2==0) return false;
	    //if not, then just check the odds
	    
	    for(long i=3;i*i<=a;i+=2) {
	        if(a%i==0)
	            return false;
	    }
	    return true;
	}
	
	public boolean relativelyPrime(long d2, long phi2) {
		
		long verdad = gdc(d2, phi2);
		
		if (verdad == 1) {
			
			return true;
		}else {
			
			return false;
		}
	}

	private long gdc(long d2, long phi2) {
		
		long t;
	    while(phi2 != 0){
	        t = d2;
	        d2 = phi2;
	        phi2 = t%phi2;
	    }
	    return d2;
	}
}
