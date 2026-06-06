package dominio;

import logica.GuardarHechizo;
import logica.PuntuacionVisitor;

public class Agua extends Hechizo implements Visitable{
	public int CantidadHeal,PresionDelAgua;

	public Agua(String nombreHechizo, String tipo, int damage, int cantidadHeal, int presionDelAgua) {
		super(nombreHechizo, tipo, damage);
		CantidadHeal = cantidadHeal;
		PresionDelAgua = presionDelAgua;
	}

	public int getCantidadHeal() {
		return CantidadHeal;
	}

	public void setCantidadHeal(int cantidadHeal) {
		CantidadHeal = cantidadHeal;
	}

	public int getPresionDelAgua() {
		return PresionDelAgua;
	}

	public void setPresionDelAgua(int presionDelAgua) {
		PresionDelAgua = presionDelAgua;
	}
	
	public double aceptar(HechizoVisitor visitante) {
		return visitante.visitar(this);
	}
	public void aceptar(GuardarHechizo guardarHechizo) {
    	guardarHechizo.visitar(this);
	}
	
}
