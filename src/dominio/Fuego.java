package dominio;

import logica.GuardarHechizo;

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
	public void aceptar(GuardarHechizo guardarHechizo) {
    	guardarHechizo.visitar(this);
	}
	@Override
	public String toString() {
		return "1) NombreHechizo=" + NombreHechizo + "\n2) Damage=" + Damage + "\n3) Duracion Quemadura="
				+ DuracionQuemadura;
	}
}
