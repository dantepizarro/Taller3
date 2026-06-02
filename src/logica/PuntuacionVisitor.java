package logica;

import dominio.Agua;
import dominio.Fuego;
import dominio.HechizoVisitor;
import dominio.Planta;
import dominio.Tierra;

public class PuntuacionVisitor implements HechizoVisitor {
	private double puntaje;
	@Override
	public double visitar(Fuego fuego) {
		puntaje = fuego.getDamage() * fuego.getDuracionQuemadura();

		return puntaje;
	}

	@Override
	public double visitar(Agua agua) {
		puntaje = (agua.getDamage() + agua.getCantidadHeal() + agua.getPresionDelAgua());
		
		return puntaje;
	}

	@Override
	public double visitar(Tierra tierra) {
		
		puntaje = (tierra.getDamage() * tierra.getMejoraDefensa())/2 ;
		return puntaje;
	}

	@Override
	public double visitar(Planta planta) {
		puntaje = planta.getDamage() + (planta.getDuracionStun() * planta.getCantPlantas());
		
		return puntaje;
	}

}
