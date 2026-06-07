package dominio;

import logica.GuardarHechizo;

public class Planta extends Hechizo implements Visitable{
	public int DuracionStun,CantPlantas;


	public Planta(String nombreHechizo, String tipo, int damage, int duracionStun, int cantPlantas) {
		super(nombreHechizo, tipo, damage);
		DuracionStun = duracionStun;
		CantPlantas = cantPlantas;
	}

	public int getDuracionStun() {
		return DuracionStun;
	}

	public void setDuracionStun(int duracionStun) {
		DuracionStun = duracionStun;
	}

	public int getCantPlantas() {
		return CantPlantas;
	}

	public void setCantPlantas(int cantPlantas) {
		CantPlantas = cantPlantas;
	}
	public double aceptar(HechizoVisitor visitante) {
		return visitante.visitar(this);
	}
	public void aceptar(GuardarHechizo guardarHechizo) {
    	guardarHechizo.visitar(this);
	}
	@Override
	public String toString() {
		return "1) NombreHechizo=" + NombreHechizo + "\n2) Damage=" + Damage + "\n3) Duracion del Stun="
				+ DuracionStun + "\n4) Cantidad de plantas=" + CantPlantas;
	}
	
}
