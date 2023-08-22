package ar.edu.ort.tp1.pacial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Cola;
import ar.edu.ort.tp1.tdas.interfaces.ListaOrdenada;

public class TiendaDeJuegos implements Mostrable {

	private static final String MSG_JUEGO_NULO = "No se pudo fabricar Juego o Cupon nulo.";	
	private static final String MSG_TIPO_DE_JUEGO = "Error de parametros incorporando tipos de juegos";
	private static final String MSG_TOTALES = "La venta total fue: $%8.2f\n";
	public static final String MENSAJE_FABRICA_POR_TIPO = "Se han fabricado: %d RPG, %d Aventura, %d Plataformas y %d Carreras\n";

	private String nombre;
	// @TODO A completar
	//FIXME no era mejor un vector?
	private int totRpg;
	private int totAventura;
	private int totPlataformas;
	private int totCarreras;
	private float totalRecaudado;
	private int[][] cuponesPorTipoDeJuego;
	private Cola<String> colaDeErrores;
	private ListaJuegosPorPrecio juegosPorPrecio;

	public TiendaDeJuegos(String nombre) {
		setNombre(nombre);
		// @TODO A completar
		this.cuponesPorTipoDeJuego = new int[TipoDeJuego.values().length][Cupon.values().length];
		this.colaDeErrores = new ColaNodos<>();
		this.juegosPorPrecio = new ListaJuegosPorPrecio();
		//FIXME no hace falta, los atributos int nacen en 0
		this.totRpg = 0;
		this.totAventura = 0;
		this.totPlataformas = 0;
		this.totCarreras = 0;
		this.totalRecaudado = 0;
	}

	private void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty() || nombre.isBlank()) {
			throw new IllegalArgumentException("Nombre de Juego Invalido");
		} else {
			this.nombre = nombre;
		}		
	}

	public void ingresarCuponesDeJuegos(TipoDeJuego tipoDeJuego, Cupon cupon, int cantidad) {
		if (cantidad <= 0) {
			throw new IllegalArgumentException(MSG_JUEGO_NULO);
		} else {
			this.cuponesPorTipoDeJuego[tipoDeJuego.ordinal()][cupon.ordinal()] += cantidad;
		}
	}

	public void ingresarPedido(Juego juego, Cupon cupon) {
		if (juego == null || cupon == null) {
			this.colaDeErrores.add(MSG_JUEGO_NULO);
			throw new IllegalArgumentException(MSG_JUEGO_NULO);
		} else {
			if (veritificarStockDeCupones(cupon, juego.getTipo())) {
				juego.agregarCupon(cupon);
				procesarParaEstadisticas(juego);
				actualizarStockCupon(juego.getTipo().ordinal(), cupon.ordinal());
				agregarJuegoALaLista(juego);
			} else {
				this.colaDeErrores.add("No se pudo ingresar " + juego.getClass().getSimpleName()
						+ " por falta de cupon de " + cupon.getNombre());
				throw new RuntimeException(" falta de cupon de " + cupon.getNombre());
			}
		}
	}

	private void agregarJuegoALaLista(Juego juego) {
		this.juegosPorPrecio.add(juego);
	}

	private void procesarParaEstadisticas(Juego juego) {
		TipoDeJuego tj = juego.getTipo();
		this.totalRecaudado += juego.getPrecioDeVenta();

		if (tj == TipoDeJuego.AVENTURA) {
			totAventura++;
		} else if (tj == TipoDeJuego.RPG) {
			totRpg++;
		} else if (tj == TipoDeJuego.PLATAFORMAS) {
			totPlataformas++;
		} else if (tj == TipoDeJuego.CARRERAS) {
			totCarreras++;
		}
	}

	public int cantidadDeJuegosEntrePrecios(float precioMinimo, float precioMaximo) {
		int cantidad = 0;
		int index = 0;
		Juego j;
		while (index < juegosPorPrecio.size() && juegosPorPrecio.get(index).getPrecioDeVenta() <= precioMaximo) {
			j = juegosPorPrecio.get(index);
			if ((j.getPrecioDeVenta() >= precioMinimo)) {
				cantidad++;
			}
			index++;
		}
		return cantidad;
	}

	public boolean veritificarStockDeCupones(Cupon cupon, TipoDeJuego tipoDeJuego) {
		return this.cuponesPorTipoDeJuego[tipoDeJuego.ordinal()][cupon.ordinal()] > 0;
	}

	private void actualizarStockCupon(int fila, int columna) {
		this.cuponesPorTipoDeJuego[fila][columna]--;
	}

	@Override
	public void mostrar() {
		System.out.println("TiendaDeJuegos: " + this.nombre); // No sabia si poner el getSimpleName ya que es identico a
																// la salida del parcial o la cadena de strings
		System.out.printf(MENSAJE_FABRICA_POR_TIPO, totRpg, totAventura, totPlataformas, totCarreras);
		System.out.printf(MSG_TOTALES, totalRecaudado);
		System.out.println("-----------------------");
		mostrarListadoDeJuegos();
		System.out.println("-----------------------");
		System.out.println("Pedidos con error: ");
		mostrarErrores();
	}

	private void mostrarListadoDeJuegos() {
		System.out.println("Listado de juegos: ");
		for (Juego j : this.juegosPorPrecio) {
			j.mostrar();
		}
	}

	private void mostrarErrores() {
		String cent = null;
		this.colaDeErrores.add(cent);
		String aux = this.colaDeErrores.remove();
		while (aux != cent) {
			System.out.println(aux);
			this.colaDeErrores.add(aux);
			aux = this.colaDeErrores.remove();
		}
		this.colaDeErrores.remove();
	}
}
