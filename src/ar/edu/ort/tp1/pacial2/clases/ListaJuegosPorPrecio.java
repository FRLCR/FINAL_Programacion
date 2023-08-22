package ar.edu.ort.tp1.pacial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaJuegosPorPrecio extends ListaOrdenadaNodos<Float, Juego>{

	@Override
	public int compare(Juego dato1, Juego dato2) {
		Float d = dato1.getPrecioDeVenta();
		return d.compareTo(dato2.getPrecioDeVenta());
	}

	@Override
	public int compareByKey(Float clave, Juego elemento) {
		// TODO Auto-generated method stub
		return clave.compareTo(elemento.getPrecioDeVenta());
	}

}
