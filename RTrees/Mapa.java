import java.awt.*;
import acm.program.*;
import acm.graphics.*;

public class Mapa extends GraphicsProgram {

	public void run() {
		setSize(600,600);
		setBackground(Color.BLACK);

		RTree mapa = new RTree(2, 4);

		//mapa.inserta("pineaple.jpg", 20, 20);


		Leaf<String> leaf1 = new Leaf<>("orange.jpg", 50, 150);
		mapa.root.hijos[0] = leaf1;
		leaf1.setColor("BLUE");
		leaf1.setCenter(100,100);
		add(leaf1.getRect());

		Leaf<String> leaf2 = new Leaf<>("banana.jpg", 75, 120);
		mapa.root.hijos[1] = leaf2;
		leaf2.setColor("WHITE");
		leaf2.setCenter(300,300);
		add(leaf2.getRect());
		System.out.println("Number of elements found:" + mapa.search(50, 50, 600, 600));

		System.out.println(mapa.inserta());
		/*Leaf<String> leaf2 = new Leaf();
		leaf2.value ="banana.jpg";
		mapa.root.hijos[1] = leaf2;*/
	}


	//mapa.root.

}