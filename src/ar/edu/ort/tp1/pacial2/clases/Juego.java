package ar.edu.ort.tp1.pacial2.clases;

public abstract class Juego implements Mostrable {

	private static final String MSG_GANANCIA_INVALIDA = "Ganancia invalida";
	private static final String MSG_PRECIO_INVALIDO = "Costo invalido";
	private static final String MSG_NOMBRE_INVALIDO = "Nombre invalido";
	private static final String MSG_TIPO_INVALIDO = "Tipo invalido";
	private final static String MSG_MOSTRAR = "%s - %s - Precio de Venta: $ %.2f - %s \n";

	private String nombre;
	private float precioBase;
	private float porcentajeGanancia;
	private TipoDeJuego tipoDeJuego;
	private Cupon cupon;

	public Juego(String nombre, float precioBase, float porcentajeGanancia, TipoDeJuego tipoDeJuego) {
		this.setNombre(nombre);
		this.setPrecioBase(precioBase);
		this.setPorcentajeGanancia(porcentajeGanancia);
		this.setTipoJuego(tipoDeJuego);
	}

	private void setTipoJuego(TipoDeJuego tj) {
		if (tj == null) {
			throw new IllegalArgumentException(MSG_TIPO_INVALIDO);
		} else {
			this.tipoDeJuego = tj;
		}
	}

	private void setPorcentajeGanancia(float pg) {
		if (pg < 0) {
			throw new IllegalArgumentException(MSG_GANANCIA_INVALIDA);
		} else {
			this.porcentajeGanancia = pg;
		}
	}

	private void setPrecioBase(float pb) {
		if (pb <= 0) {
			throw new IllegalArgumentException(MSG_PRECIO_INVALIDO);
		} else {
			this.precioBase = pb;
		}

	}

	private void setNombre(String n) {
		if (n == null || n.isEmpty()) {
			throw new IllegalArgumentException(MSG_NOMBRE_INVALIDO);
		} else {
			this.nombre = n;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public float getPrecioBase() {
		return precioBase;
	}

	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public float getPrecioDeVenta() {
		// Informa el precio de VENTA (getPrecioCosto() + getPrecioCosto *
		// PorcentajeGanancia - cuponDescuento)
		float precioDeVenta = getPrecioDeCosto();
		float precioFinal = precioDeVenta + (precioDeVenta * this.porcentajeGanancia / 100);
		return precioFinal - (precioFinal * (this.cupon.getPorcentaje() / 100));
	}

	public void mostrar() {
		// MUESTRA La clase del Juego, Su nombre y El precio de venta
		System.out.printf(MSG_MOSTRAR, getClass().getSimpleName(), this.nombre, this.getPrecioDeVenta(), completar());

	}

	public abstract String completar();

	public abstract float getPrecioDeCosto();

	public TipoDeJuego getTipo() {
		return this.tipoDeJuego;
	}

	public void agregarCupon(Cupon c) {
		//FIXME que pasaría si fuese null?
		this.cupon = c;
	}
}
