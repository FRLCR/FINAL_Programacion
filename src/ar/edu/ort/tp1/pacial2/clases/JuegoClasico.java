package ar.edu.ort.tp1.pacial2.clases;

public class JuegoClasico extends Juego{
	
	private TipoDePlataforma tipoDePlataforma;

	public JuegoClasico(String nombre, float precioBase, float porcentajeGanancia,  TipoDePlataforma tipoDePlataforma, TipoDeJuego tipoDeJuego) {
		super(nombre, precioBase, porcentajeGanancia, tipoDeJuego);
		this.tipoDePlataforma = tipoDePlataforma;
	}

	@Override
	public float getPrecioDeCosto() {		
		return super.getPrecioBase()*tipoDePlataforma.getMultiplicadorPlataforma();
	}

	@Override
	public String completar() {
		// TODO Auto-generated method stub
		return this.tipoDePlataforma.getDescripcion();
	}

}
