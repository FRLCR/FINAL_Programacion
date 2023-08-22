package ar.edu.ort.tp1.pacial2.clases;

public class JuegoEdicionEspecial extends Juego{

	private final static int ANIO_MINIMO = 1951;
	private final static float DESCUENTO_LANZAMIENTO = 15890.10f;
	private ContenidoAdicional contenido;
	private int anioLanzamiento;

	public JuegoEdicionEspecial(String nombre, float precioBase, float porcentajeGanancia, int anioLanzamiento, ContenidoAdicional contenido, TipoDeJuego tipoDeJuego) {
		super(nombre, precioBase, porcentajeGanancia, tipoDeJuego);
		this.setAnio(anioLanzamiento);
		this.contenido = contenido;
		
	}

	private void setAnio(int al) {
		if (al < ANIO_MINIMO) {
			throw new IllegalArgumentException("No puede ser menor al primer año de lanzamiento!");
		} else {
			this.anioLanzamiento = al;
		}
		
	}

	@Override
	public float getPrecioDeCosto() {
		return super.getPrecioBase() + contenido.getAdicional() - DESCUENTO_LANZAMIENTO / this.anioLanzamiento;
	}

	@Override
	public String completar() {
		return "Anio de lanzamiento: "+ this.anioLanzamiento + " - " + this.contenido.getDescripcion();
	}

}
