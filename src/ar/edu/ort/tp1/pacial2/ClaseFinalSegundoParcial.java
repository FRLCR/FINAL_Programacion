package ar.edu.ort.tp1.pacial2;

import ar.edu.ort.tp1.pacial2.clases.*;

public class ClaseFinalSegundoParcial {

	public static void main(String[] args) {
		TiendaDeJuegos laTiendaDeJuegos = new TiendaDeJuegos("Ortadia");

		ingresarCuponesDeJuegosATienda(laTiendaDeJuegos);

		pedirJuegoClasico(laTiendaDeJuegos, "Excitebike", 12000, 20, TipoDePlataforma.PC, Cupon.TREINTA, TipoDeJuego.PLATAFORMAS);
		pedirJuegoClasico(laTiendaDeJuegos, "Mario Bros", 1500, 20, TipoDePlataforma.PC, Cupon.TREINTA, TipoDeJuego.PLATAFORMAS);
		pedirJuegoClasico(laTiendaDeJuegos, "", 1800, 20, TipoDePlataforma.PC, Cupon.TREINTA, TipoDeJuego.PLATAFORMAS);
		pedirJuegoClasico(laTiendaDeJuegos, "Ice Hockey", 11111, 20, TipoDePlataforma.PC, Cupon.TREINTA, TipoDeJuego.PLATAFORMAS);
		pedirJuegoClasico(laTiendaDeJuegos, "Mighty Bomb Jack", 2222, 10, TipoDePlataforma.XBOX, Cupon.DIEZ, TipoDeJuego.PLATAFORMAS);
		pedirJuegoClasico(laTiendaDeJuegos, "Metal Gear", -7000, 10, TipoDePlataforma.PLAYSTATION, Cupon.NINGUNO, TipoDeJuego.PLATAFORMAS);
		pedirJuegoClasico(laTiendaDeJuegos, " Zelda II: The Adventure of Link", -8200, 10, TipoDePlataforma.NINTENDO, null, TipoDeJuego.PLATAFORMAS);

		pedirJuegoEdicionEspecial(laTiendaDeJuegos, "The Legend of Zelda: Tears of the Kingdom Collector's Edition", 7700, 20, 0, ContenidoAdicional.DLC, Cupon.VEINTE, TipoDeJuego.PLATAFORMAS);
		pedirJuegoEdicionEspecial(laTiendaDeJuegos, "Far Cry 6 Collector's Edition\n", 8900, 15, 2001, ContenidoAdicional.EXPANSIONES, Cupon.VEINTE, TipoDeJuego.PLATAFORMAS);
		pedirJuegoEdicionEspecial(laTiendaDeJuegos, null, 6589, 15, 2002, ContenidoAdicional.EXPANSIONES, Cupon.CUARENTA, TipoDeJuego.PLATAFORMAS);
		pedirJuegoEdicionEspecial(laTiendaDeJuegos, "Among Us Ejected Edition", 12145, 15, 2003, ContenidoAdicional.EXPANSIONES, Cupon.CUARENTA, TipoDeJuego.PLATAFORMAS);
		pedirJuegoEdicionEspecial(laTiendaDeJuegos, "Beyond a Steel Sky", 2456, 15, 2004, ContenidoAdicional.COSMETICOS, Cupon.DIEZ, TipoDeJuego.PLATAFORMAS);
		ingresoNulo(laTiendaDeJuegos, Cupon.DIEZ);
		pedirJuegoEdicionEspecial(laTiendaDeJuegos, "The Dark Pictures Anthology: House of Ashes", 6500, 25, 2005, ContenidoAdicional.COSMETICOS, Cupon.TREINTA, TipoDeJuego.PLATAFORMAS);
		pedirJuegoEdicionEspecial(laTiendaDeJuegos, " Fire Emblem Engage  Divine Edition", 00, 25, 2006, ContenidoAdicional.COSMETICOS, Cupon.NINGUNO, TipoDeJuego.PLATAFORMAS);
		pedirJuegoEdicionEspecial(laTiendaDeJuegos, "Undertale Collectors Edition", 8900, 25, 2007, ContenidoAdicional.COSMETICOS, Cupon.CUARENTA, TipoDeJuego.PLATAFORMAS);
		pedirJuegoEdicionEspecial(laTiendaDeJuegos, "Elden Ring Launch Edition", 10000, 25, 2008, ContenidoAdicional.COSMETICOS, Cupon.CUARENTA, null);

		pedirJuegoMultijugador(laTiendaDeJuegos, "Guild Wars 2", 5000, 20, 2, ContenidoAdicional.EXPANSIONES, Cupon.DIEZ, TipoDeJuego.PLATAFORMAS);
		pedirJuegoMultijugador(laTiendaDeJuegos, "Final Fantasy XIV", 6000, 15, 2,  ContenidoAdicional.COSMETICOS, Cupon.DIEZ, TipoDeJuego.PLATAFORMAS);
		pedirJuegoMultijugador(laTiendaDeJuegos, "Fornite", 5500, 15, -2,  ContenidoAdicional.DLC, Cupon.VEINTE, TipoDeJuego.PLATAFORMAS);
		pedirJuegoMultijugador(laTiendaDeJuegos, "Rocket League", 4020, 15, 2, ContenidoAdicional.DLC, Cupon.TREINTA, TipoDeJuego.PLATAFORMAS);
		pedirJuegoMultijugador(laTiendaDeJuegos, "League of Legends", 1000, 15, 2, ContenidoAdicional.EXPANSIONES, Cupon.TREINTA, TipoDeJuego.PLATAFORMAS);
		pedirJuegoMultijugador(laTiendaDeJuegos, "Dragon Ball Fighter Z", 6500, 15, 2,  ContenidoAdicional.DLC, Cupon.TREINTA, TipoDeJuego.PLATAFORMAS);

		System.out.println("--------------------------------------");
		System.out.printf("Se pidieron %d juegos cuyo precio se encuentra entre $10000 y $20000 \n ", (laTiendaDeJuegos.cantidadDeJuegosEntrePrecios(10000, 20000)));

		System.out.println("--------------------------------------");
		laTiendaDeJuegos.mostrar();
	}

	private static void ingresarCuponesDeJuegosATienda(TiendaDeJuegos laTiendaDeJuegos) {
		laTiendaDeJuegos.ingresarCuponesDeJuegos(TipoDeJuego.RPG, Cupon.TREINTA, 2);
		laTiendaDeJuegos.ingresarCuponesDeJuegos(TipoDeJuego.RPG, Cupon.DIEZ, 1);
		laTiendaDeJuegos.ingresarCuponesDeJuegos(TipoDeJuego.RPG, Cupon.DIEZ, 1);
		laTiendaDeJuegos.ingresarCuponesDeJuegos(TipoDeJuego.RPG, Cupon.NINGUNO, 2);

		laTiendaDeJuegos.ingresarCuponesDeJuegos(TipoDeJuego.AVENTURA, Cupon.VEINTE, 2);
		laTiendaDeJuegos.ingresarCuponesDeJuegos(TipoDeJuego.AVENTURA, Cupon.CUARENTA, 2);
		laTiendaDeJuegos.ingresarCuponesDeJuegos(TipoDeJuego.AVENTURA, Cupon.DIEZ, 2);
		laTiendaDeJuegos.ingresarCuponesDeJuegos(TipoDeJuego.AVENTURA, Cupon.TREINTA, 2);

		laTiendaDeJuegos.ingresarCuponesDeJuegos(TipoDeJuego.PLATAFORMAS, Cupon.VEINTE, 4);
		laTiendaDeJuegos.ingresarCuponesDeJuegos(TipoDeJuego.PLATAFORMAS, Cupon.DIEZ, 1);
		laTiendaDeJuegos.ingresarCuponesDeJuegos(TipoDeJuego.PLATAFORMAS, Cupon.TREINTA, 2);

	}

	private static void ingresoNulo(TiendaDeJuegos laTiendaDeJuegos, Cupon cupon) {
		// DESCOMENTAR Y COMPLETAR
		try {
		 laTiendaDeJuegos.ingresarPedido(null, cupon);
		} catch (IllegalArgumentException ie) {
			System.out.println(ie.getMessage());
		}
	}

	private static void pedirJuegoClasico(TiendaDeJuegos laTiendaDeJuegos, String nombre, float costoBase, float porcentajeGanancia,
										  TipoDePlataforma tipoDePlataforma, Cupon cupon, TipoDeJuego tipoDeJuego) {
		// DESCOMENTAR Y COMPLETAR
		try {
		laTiendaDeJuegos.ingresarPedido(new JuegoClasico(nombre, costoBase, porcentajeGanancia, tipoDePlataforma, tipoDeJuego), cupon);
		} catch (IllegalArgumentException ie) {
			System.out.println(ie.getMessage());
		}
		catch (RuntimeException re) {
			System.out.println("No se pudo ingresar JuegoClasico por" + re.getMessage());
		}
	}

	private static void pedirJuegoEdicionEspecial(TiendaDeJuegos laTiendaDeJuegos, String nombre, float costoBase, float porcentajeGanancia,
												  int anioLanzamiento, ContenidoAdicional contenidoAdicional, Cupon cupon, TipoDeJuego tipoDeJuego) {
		// DESCOMENTAR Y COMPLETAR
		try {
		laTiendaDeJuegos.ingresarPedido(new JuegoEdicionEspecial(nombre, costoBase, porcentajeGanancia, anioLanzamiento, contenidoAdicional, tipoDeJuego), cupon);
		}  catch (IllegalArgumentException ie) {
			System.out.println(ie.getMessage());
		}
		catch (RuntimeException re) {
			System.out.println("No se pudo ingresar JuegoEspecial por" + re.getMessage());
		}
	}
	private static void pedirJuegoMultijugador(TiendaDeJuegos laTiendaDeJuegos, String nombre, float costoBase, float porcentajeGanancia,
											   long cantidadJugadores, ContenidoAdicional contenidoAdicional, Cupon cupon, TipoDeJuego tipoDeJuego) {
		// DESCOMENTAR Y COMPLETAR
		try {
		laTiendaDeJuegos.ingresarPedido(new JuegoMultijugador(nombre, costoBase, porcentajeGanancia, cantidadJugadores, contenidoAdicional, tipoDeJuego), cupon);
		} catch (IllegalArgumentException ie) {
			System.out.println(ie.getMessage());
	}		catch (RuntimeException re) {
		System.out.println("No se pudo ingresar JuegoMultijugador por" + re.getMessage());
	}
		}

}
