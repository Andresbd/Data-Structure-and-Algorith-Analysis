import java.util.*;
import acm.graphics.GObject;
import acm.graphics.GPoint;

class RTree {
	public Branch root;
	private int M;
	private int m;
	private int Max;

	public RTree(int min, int Max) {
		this.M = Max;
		this.m = min;
		this.root = new Branch(M, 600, 600);
	}

	public boolean inserta () {
		int i = 0;

		if (root.hijos[M-1] == null) {

			Leaf<String> leaf+i = new Leaf<>();
			root.hijos[i] = leaf+i;

			return true;
		}

		split();

		return false;
	}

	public boolean split() {
		return true;
	}

	public int search(double x, double y, double width, double height) {
		Nodo[] result = new Nodo[100];
		int j = 0;
		for(int i = 0; i < root.hijos.length ; i++) {
      if (root.hijos[i] == null) break;
			Leaf current = (Leaf)root.hijos[i];
			if(current.overlaps(x, y, width, height)) {
				result[j] = root.hijos[i];
				j++;
			}
		}
		return j;
	}

}

class Nodo {
	protected Rect rect;

	public Nodo(int width, int height) {
		rect = new Rect(width, height);
	}

	public GObject getRect() {
		return rect.getForm();
	}
}

class Leaf<E> extends Nodo {
	public E value;

	public Leaf(E _val, int width, int height) {
		super(width, height);
		this.value = _val;
	}

	public void setColor(String color) {
		rect.setColor(color);
	}

	public void setCenter(int x, int y) {
		rect.setCenter(new GPoint(x,y));
	}

	public boolean overlaps(double x, double y, double width, double height) {
		double posx = rect.getX();
		double posy = rect.getY();
		double rectWidth = rect.getWidth();
		double rectHeight = rect.getHeight();

		if( (x <= posx && posx <= (x + width)) || (x <= (posx + rectWidth) && (posx + rectWidth) <= (x + width)) ) {
			if( (y <= posy && posy <= (y + height)) || (y <= (posy + rectHeight) && (posy + rectHeight) <= (y + height)) )
			{
				return true;
			}
		}
		return false;
	}
}

class Branch extends Nodo {
	public Nodo[] hijos;

	public Branch(int max, int width, int height) {
		super(width, height);
		this.hijos = new Nodo[max];
	}
}
