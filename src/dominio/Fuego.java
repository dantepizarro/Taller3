package dominio;

public class Fuego extends Hechizo{
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
	
}
