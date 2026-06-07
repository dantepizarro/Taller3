package dominio;

import logica.GuardarHechizo;
/**
 * Clase base que representa un hechizo en el sistema.
 * Contiene los atributos comunes a todos los tipos de hechizo:
 * nombre, tipo y daño base.
 * Las subclases concretas (Fuego, Agua, Tierra, Planta)
 * extienden esta clase agregando atributos específicos de cada tipo.
 */
public class Hechizo {
	 /** Nombre identificador del hechizo.
	  * Tipo del hechizo
	  * Daño base del hechizo
	  */
	protected String NombreHechizo,Tipo;
	protected int Damage;
	 /**
     * Constructor de la clase Hechizo.
     *
     * @param nombreHechizo nombre del hechizo
     * @param tipo          tipo del hechizo (Fuego, Agua, Tierra, Planta)
     * @param damage        daño base del hechizo
     */
	public Hechizo(String nombreHechizo, String tipo, int damage) {
		NombreHechizo = nombreHechizo;
		Tipo = tipo;
		Damage = damage;
	}
	/**
     * Retorna el nombre del hechizo.
     *
     * @return nombre del hechizo
     */
	public String getNombreHechizo() {
		return NombreHechizo;
	}
	/**
     * Establece el nombre del hechizo.
     *
     * @param nombreHechizo nuevo nombre del hechizo
     */
	public void setNombreHechizo(String nombreHechizo) {
		NombreHechizo = nombreHechizo;
	}
	 /**
     * Retorna el tipo del hechizo.
     *
     * @return tipo del hechizo
     */
	public String getTipo() {
		return Tipo;
	}
	/**
     * Establece el tipo del hechizo.
     *
     * @param tipo nuevo tipo del hechizo
     */
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	/**
     * Retorna el daño base del hechizo.
     *
     * @return daño base
     */
	public int getDamage() {
		return Damage;
	}
	/**
     * Establece el daño base del hechizo.
     *
     * @param damage nuevo valor de daño
     */
	public void setDamage(int damage) {
		Damage = damage;
	}
	/**
     * Método vacío para aceptar un visitante de tipo GuardarHechizo
     * Las subclases deben sobreescribir este método para delegar
     * correctamente al visitante.
     *
     * @param guardarHechizo visitante encargado de escribir el hechizo
     */
	public void aceptar(GuardarHechizo guardarHechizo) {
		
	}
	
	
	
	
}
