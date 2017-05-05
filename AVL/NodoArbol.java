
public class NodoArbol {

	NodoArbol nodIzq;
	NodoArbol nodDer;
	
	int info;
	int height;

	public NodoArbol(int dato) // Constructor del árbol
	{
		info = dato;
		height = 1;
		nodIzq = nodDer = null;
	}
	
	int height(NodoArbol n) {
		if (n == null)
			return 0;

		return n.height;
	}

	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// Función de rotación derecha
	NodoArbol rightRotate(NodoArbol y) {
		NodoArbol x = y.nodIzq;
		NodoArbol T2 = x.nodDer;

		// Perform rotation
		x.nodDer = y;
		y.nodIzq = T2;

		// Update heights
		y.height = max(height(y.nodIzq), height(y.nodDer)) + 1;
		x.height = max(height(x.nodIzq), height(x.nodDer)) + 1;

		// Return new root
		return x;
	}

	// Función de rotación izquierda
	NodoArbol leftRotate(NodoArbol x) {
		NodoArbol y = x.nodDer;
		NodoArbol T2 = y.nodIzq;

		// Realizar rotación
		y.nodIzq = x;
		x.nodDer = T2;

		// Actualiza alturas
		x.height = max(height(x.nodIzq), height(x.nodDer)) + 1;
		y.height = max(height(y.nodIzq), height(y.nodDer)) + 1;

		// Nueva Raíz
		return y;
	}

	// Factor de balance para el árbol
	int getBalance(NodoArbol N) {
		if (N == null)
			return 0;

		return height(N.nodIzq) - height(N.nodDer);
	}

	public NodoArbol insertar(NodoArbol N, int valor) {

		if (valor < N.info) {

			if (N.nodIzq == null)

				N.nodIzq = new NodoArbol(valor);

			else
				N.nodIzq.insertar(N.nodIzq, valor);
		}

		else if (valor > N.info) {

			if (N.nodDer == null) {

				N.nodDer = new NodoArbol(valor);
			}

			else {
				N.nodDer.insertar(N.nodDer, valor);
			}
		}
		
		// Comprobamos que el árbol esté balanceado

				N.height = 1 + max(height(N.nodIzq), height(N.nodDer));

				int balance = getBalance(N);

				// Caso1
				if (balance > 1 && valor < N.nodIzq.info)
					return rightRotate(N);

				// Caso2
				if (balance < -1 && valor > N.nodDer.info)
					return leftRotate(N);

				// Caso3
				if (balance > 1 && valor > N.nodIzq.info) {
					N.nodIzq = leftRotate(N.nodIzq);
					return rightRotate(N);
				}

				// Caso4
				if (balance < -1 && valor < N.nodDer.info) {
					N.nodDer = rightRotate(N.nodDer);
					return leftRotate(N);
				}

				return N;
			}
	
	public static void main(String[] args) {

		AVL arbol = new AVL();
		
		arbol.raiz = arbol.insertar(arbol.raiz, 25);
		arbol.raiz = arbol.insertar(arbol.raiz, 33);
		arbol.raiz = arbol.insertar(arbol.raiz, 40);
		arbol.raiz = arbol.insertar(arbol.raiz, 27);
		arbol.raiz = arbol.insertar(arbol.raiz, 26);
		
		System.out.println("Por nivel");
		arbol.nivel(arbol.raiz);
		
		// Ordenamiento del árbol
		System.out.println("arbol preOrder");
		arbol.preOrder();
		System.out.println("arbol inOrder");
		arbol.inOrder();
		System.out.println("arbol posOrder");
		arbol.posOrder();

		boolean encontrado;

		// Búsqueda
		encontrado = arbol.buscar(25);
		System.out.println("Encontrado: " + encontrado);
		
		// Eliminación
		arbol.eliminaDato(25);
		System.out.println("se elimno el 25");
		arbol.inOrder();
		

	}
	}
