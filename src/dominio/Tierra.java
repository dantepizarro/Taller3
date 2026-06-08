package dominio;

import logica.GuardarHechizo;
/**
 * Representa un hechizo de tipo Tierra.
 * Extiende Hechizo agregando el atributo de mejora de defensa
 * que indica cuánta defensa obtendra el usuario que utilize el hechizo.
 * Implementa Visitable para ser procesado por el patrón Visitor.
 */
public class Tierra extends Hechizo implements Visitable{
	public int MejoraDefensa;
/**
 * Este es el contructor del hechizo tierra
 * @param nombreHechizo nombre del hechizo
 * @param tipo tipo del hechizo
 * @param damage daño del hechizo
 * @param mejoraDefensa la cantidad de defensa que mejora 
 */
	public Tierra(String nombreHechizo, String tipo, int damage, int mejoraDefensa) {
		super(nombreHechizo, tipo, damage);
		MejoraDefensa = mejoraDefensa;
	}
	/**
	 * permite regresar el valor de la defensa
	 * @return retorna el valor de la defensa
	 */
	public int getMejoraDefensa() {
		return MejoraDefensa;
	}
	/**
	 * Permite cambiar el valor de la defensa
	 * @param mejoraDefensa nuevo valor de la defensa
	 */
	public void setMejoraDefensa(int mejoraDefensa) {
		MejoraDefensa = mejoraDefensa;
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
	 * escribir este hechizo en el archivo de datos.
	 *
	 * @param guardarHechizo visitante encargado de guardar el hechizo
	 */
	
	public void aceptar(GuardarHechizo guardarHechizo) {
    	guardarHechizo.visitar(this);
	}
	@Override
	/**
	 * permite retornar un tetxo hacia la direccion de donde es llamado
	 * @return retorna un texto
	 */
	public String toString() {
		return "1) NombreHechizo= " + NombreHechizo + "\n2) Damage= " + Damage + "\n3) Mejora Defensa= "
				+ MejoraDefensa;
	}
}
