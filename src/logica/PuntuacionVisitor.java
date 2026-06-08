package logica;

import dominio.Agua;
import dominio.Fuego;
import dominio.HechizoVisitor;
import dominio.Planta;
import dominio.Tierra;
/**
 * Esta clase que implemtenta Hechizovisitor permite calcular la puntuaciond de cada hechizo dependiendo
 * su tipo
 * puntaje se encarga de gurdar la puntuacion
 */
public class PuntuacionVisitor implements HechizoVisitor {
	private double puntaje;
	@Override
	/**
	 * si el visitor visita un Hechizo de fuego calculara su puntuacion mediante
	 * la multiplicacion de su daño por la duracion de la quemadura
	 * @param fuego es un hechizo de fuego
	 *  @return puntaje retorna el puntaje calculado
	 */
	public double visitar(Fuego fuego) {
		puntaje = fuego.getDamage() * fuego.getDuracionQuemadura();

		return puntaje;
	}

	@Override
	/**
	 * si el visitor visita un Hechizo de agua calculara su puntuacion mediante
	 * la suma de su daño con la cantidad de heal y la presion del agua
	 * @param agua es un hechizo de agua
	 *  @return puntaje retorna el puntaje calculado
	 */
	public double visitar(Agua agua) {
		puntaje = (agua.getDamage() + agua.getCantidadHeal() + agua.getPresionDelAgua());
		
		return puntaje;
	}

	@Override
	/**
	 * si el visitor visita un Hechizo de tierra calculara su puntuacion mediante
	 * la multiplicacion de su daño por la mejora de la defensa divido en dos
	 * @param tierra es un hechizo de tierra
	 *  @return puntaje retorna el puntaje calculado
	 */
	public double visitar(Tierra tierra) {
		
		puntaje = (tierra.getDamage() * tierra.getMejoraDefensa())/2 ;
		return puntaje;
	}

	@Override
	/**
	 * si el visitor visita un Hechizo de planta calculara su puntuacion mediante
	 * la multiplicacion de la duracion del stun con la cantidad de plantas sumando el daño del ataque
	 * @param planta es un hechizo de planta
	 * @return puntaje retorna el puntaje calculado
	 */
	public double visitar(Planta planta) {
		puntaje = planta.getDamage() + (planta.getDuracionStun() * planta.getCantPlantas());
		
		return puntaje;
	}

}
