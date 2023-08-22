package ar.edu.ort.tp1.pacial2.clases;

public class JuegoMultijugador extends Juego{

	private final static float PRECIO_JUGADOR = 45;
	private long maximoOnline;
	private ContenidoAdicional contenidoAdicional; 
	
	public JuegoMultijugador(String nombre, float precioBase, float porcentajeGanancia, long maximoOnline, ContenidoAdicional contenidoAdicional, TipoDeJuego tipoDeJuego ) {
		super(nombre, precioBase, porcentajeGanancia, tipoDeJuego);
		this.setOnline(maximoOnline);
		this.contenidoAdicional = contenidoAdicional;
	}

	private void setOnline(long mo) {
		if (mo < 0) {
			throw new IllegalArgumentException("Los maximos online no pueden ser negativos!");
		} else {
			this.maximoOnline = mo;
		}		
	}

	@Override
	public float getPrecioDeCosto() {
		return super.getPrecioBase() + (PRECIO_JUGADOR * this.maximoOnline) + this.contenidoAdicional.getAdicional();
	}

	@Override
	public String completar() {
		return " - " + this.maximoOnline + " - " + this.contenidoAdicional.getDescripcion();
	}

}
