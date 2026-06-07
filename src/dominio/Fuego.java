package dominio;

import logica.GuardarHechizo;
/**
 * Representa un hechizo de tipo Fuego.
 * Extiende Hechizo agregando el atributo de duración de quemadura,
 * que indica cuántos turnos dura el efecto de quemadura aplicado al objetivo.
 * Implementa Visitable para ser procesado por el patrón Visitor.
 */
public class Fuego extends Hechizo implements Visitable{
	/** Cantidad de turnos que dura el efecto de quemadura. */
	public int DuracionQuemadura;
	/**
     * Constructor de la clase Fuego.
     *
     * @param nombreHechizo  :  nombre del hechizo
     * @param tipo            :  tipo del hechizo
     * @param damage          : daño base del hechizo
     * @param duracionQuemadura : duración en turnos del efecto de quemadura
     */
	public Fuego(String nombreHechizo, String tipo, int damage, int duracionQuemadura) {
		super(nombreHechizo, tipo, damage);
		DuracionQuemadura = duracionQuemadura;
	}
	/**
     * Retorna la duración del efecto de quemadura.
     *
     * @return duración de quemadura en turnos
     */
	public int getDuracionQuemadura() {
		return DuracionQuemadura;
	}
	/**
     * Establece la duración del efecto de quemadura.
     *
     * @param duracionQuemadura nueva duración de quemadura en turnos
     */
	public void setDuracionQuemadura(int duracionQuemadura) {
		DuracionQuemadura = duracionQuemadura;
	}
	/**
     * Acepta un visitante de tipo HechizoVisitor y delega
     * la operación al método correspondiente del visitante.
     *
     * @param visitante visitante que procesará este hechizo
     * @return resultado de la operación del visitante
     */
	public double aceptar(HechizoVisitor visitante) {
		return visitante.visitar(this);
	}
	/**
     * Acepta un visitante de tipo GuardarHechizo para
     * persistir este hechizo en el archivo de datos.
     *
     * @param guardarHechizo visitante encargado de guardar el hechizo
     */
	public void aceptar(GuardarHechizo guardarHechizo) {
    	guardarHechizo.visitar(this);
	}
	/**
     * Retorna una representación en texto del hechizo Fuego
     * con sus atributos numerados para mostrar al usuario.
     *
     * @return cadena con nombre, daño y duración de quemadura
     */
	@Override
	public String toString() {
		return "1) NombreHechizo=" + NombreHechizo + "\n2) Damage=" + Damage + "\n3) Duracion Quemadura="
				+ DuracionQuemadura;
	}
}
