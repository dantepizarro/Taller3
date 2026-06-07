package dominio;

import logica.GuardarHechizo;

public class Tierra extends Hechizo implements Visitable{
	public int MejoraDefensa;

	public Tierra(String nombreHechizo, String tipo, int damage, int mejoraDefensa) {
		super(nombreHechizo, tipo, damage);
		MejoraDefensa = mejoraDefensa;
	}

	public int getMejoraDefensa() {
		return MejoraDefensa;
	}

	public void setMejoraDefensa(int mejoraDefensa) {
		MejoraDefensa = mejoraDefensa;
	}
	public double aceptar(HechizoVisitor visitante) {
		return visitante.visitar(this);
	}
	public void aceptar(GuardarHechizo guardarHechizo) {
    	guardarHechizo.visitar(this);
	}
	@Override
	public String toString() {
		return "1) NombreHechizo= " + NombreHechizo + "\n2) Damage= " + Damage + "\n3) Mejora Defensa= "
				+ MejoraDefensa;
	}
}
