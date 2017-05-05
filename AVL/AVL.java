import java.util.ArrayList;
import java.util.Stack;

public class AVL {
	
	public ArrayList<NodoArbol> F = new ArrayList();

	NodoArbol raiz;

	AVL() {

		raiz = null;
	}

	

	// Código para insertar en el árbol
	public NodoArbol insertar(NodoArbol N, int valor) {

		if (N == null) {

			return (new NodoArbol(valor));
		} else {

			N.insertar(N,valor);
		}
		
		return N;
	}

	public boolean buscar(int valor) {

		return buscarInterno(raiz, valor);
	}

	private boolean buscarInterno(NodoArbol n, int dato) {

		if (n == null)

			return false;

		else {

			if (n.info == dato)

				return true;

			else if (dato < n.info)

				return buscarInterno(n.nodIzq, dato);

			else

				return buscarInterno(n.nodDer, dato);
		}
	}

	public void preOrder() {

		preOrderInterno(raiz);
	}

	private void preOrderInterno(NodoArbol n) {
		if (n != null) {
			System.out.println(n.info);
			preOrderInterno(n.nodIzq);
			preOrderInterno(n.nodDer);
		}
	}

	public void inOrder() {

		inOrderInterno(raiz);
	}

	private void inOrderInterno(NodoArbol n) {
		if (n != null) {
			inOrderInterno(n.nodIzq);
			System.out.println(n.info);
			inOrderInterno(n.nodDer);
		}
	}

	public void posOrder() {
		posOrderInterno(raiz);
	}

	private void posOrderInterno(NodoArbol n) {
		if (n != null) {
			posOrderInterno(n.nodIzq);
			posOrderInterno(n.nodDer);
			System.out.println(n.info);

		}
	}

	// Medotos para eliminar nodos en un Arbol
	void eliminaDato(int dato) {
		if (!buscar(dato)) { // si el dato no esta
			System.out.println("El dato no se encuentra en el Arbol");

		} else {
			NodoArbol n = buscarNodo(dato, raiz);
			int nH = numeroHijos(n);
			if (nH == 0) { // es hoja
				eliminaHoja(n);
			} else if (nH == 1) { // tiene un unico hijo
				eliminaNodoHijoUnico(n);
			} else { // tiene dos hijos
				eliminaNodo2Hijos(n);
			}
		}
	}

	// Metodo para buscar el nodo a eliminar :O
	NodoArbol buscarNodo(int dato, NodoArbol aux) {
		if (aux == null)
			return null;
		else {
			if (aux.info == dato)
				return aux;
			else if (dato < aux.info)
				return buscarNodo(dato, aux.nodIzq);
			else
				return buscarNodo(dato, aux.nodDer);
		}
	}

	// Metodo para determinar el Numero Hijos
	int numeroHijos(NodoArbol aux) {
		if (aux != null) {
			if (aux.nodIzq == null && aux.nodDer == null)
				return 0;
			if ((aux.nodIzq == null && aux.nodDer != null) || (aux.nodDer == null && aux.nodIzq != null))
				return 1;

			else
				return 2;

		} // end if aux != null
		else
			return -1; // error.
	}

	// Metodo para encontrar al Padre de un nodo dado.
	NodoArbol buscarNodoPadre(NodoArbol hijo, NodoArbol n) {

		if (n.nodIzq == hijo || n.nodDer == hijo)
			return n;
		else if (hijo.info < n.info)
			return buscarNodoPadre(hijo, n.nodIzq);
		else
			return buscarNodoPadre(hijo, n.nodDer);

	}

	// Metodo para eliminar un nodo hoja.
	void eliminaHoja(NodoArbol n) {
		if (n == raiz)
			raiz = null;
		else {
			NodoArbol padre = buscarNodoPadre(n, raiz);

			if (padre.nodIzq == n)
				padre.nodIzq = null;
			else
				padre.nodDer = null;
		}

	}

	// Metodo para eliminar nodo con un solo hijo
	void eliminaNodoHijoUnico(NodoArbol n) {
		NodoArbol hijo;
		if (n.nodIzq == null)
			hijo = n.nodDer;
		else
			hijo = n.nodIzq;
		if (n == raiz)
			raiz = hijo;
		else {
			NodoArbol padre = buscarNodoPadre(n, raiz);
			if (padre.nodIzq == n)
				padre.nodIzq = hijo;
			else
				padre.nodDer = hijo;
		}

	}

	// Metodos para Predecesor (uno a la izquierda y todos a la derecha) y
	// Sucesor

	NodoArbol predecesor(NodoArbol n) {
		// Empezando por un nodo a la izquierda
		NodoArbol aux;
		aux = n.nodIzq;

		// Todo a la derecha
		while (aux.nodDer != null)
			aux = aux.nodDer;
		return aux;

	}

	NodoArbol sucesor(NodoArbol n) {
		// Empezando por un nodo a la derecha.
		NodoArbol aux;
		aux = n.nodDer;
		// Todos a la izquierda
		while (aux.nodIzq != null)
			aux = aux.nodIzq;
		return aux;
	}

	void eliminaNodo2Hijos(NodoArbol n) {
		// Buscar al Sucesor o Predecesor
		NodoArbol pre = predecesor(n);
		int datoDelPre = pre.info;

		// Elimina al Predecesor.
		int nH = this.numeroHijos(pre);
		if (nH == 0)
			eliminaHoja(pre);
		else
			eliminaNodoHijoUnico(pre);

		// intercambia indormacion
		n.info = datoDelPre;

		// eliminaDato(pre.info);
	}
	
	void nivel(NodoArbol n) {
		
		F.add(n);
		System.out.println(n.info);
		
		if (n.nodIzq != null) {
			
			F.add(n.nodIzq);
			nivel(n.nodIzq);
		}
		
		if (n.nodDer != null) {
			
			F.add(n.nodDer);
			nivel(n.nodDer);
		}
	}

}
