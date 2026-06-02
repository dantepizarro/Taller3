package dominio;

public class Fuego extends Hechizo implements Visitable{
	public int DuracionQuemadura;
	
	public Fuego(String nombreHechizo, String tipo, int damage, int duracionQuemadura) {
		super(nombreHechizo, tipo, damage);
		DuracionQuemadura = duracionQuemadura;
	}
	
	public int getDuracionQuemadura() {
		return DuracionQuemadura;
	}
	
	public void setDuracionQuemadura(int duracionQuemadura) {
		DuracionQuemadura = duracionQuemadura;
	}
	public double aceptar(HechizoVisitor visitante) {
		return visitante.visitar(this);
	}
	
}
