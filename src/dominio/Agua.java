package dominio;

import logica.GuardarHechizo;
import logica.PuntuacionVisitor;

/*
Representa un hechizo de tipo agua
Extiende de Hechizo agregando sus atributos (nombreHechizo,tipo,damage)
implemente Visitable para ser procesado por el patron visitor
*/

public class Agua extends Hechizo implements Visitable{
	//CantidadHeal = Cantidad de puntos de vida que cura el hechizo
	//PresionDelAgua = Fuerza de presion del agua 
	public int CantidadHeal,PresionDelAgua;


	/**
	Constructor de la clase Agua
	@param nombreHechizo : nombre del hechizo
	@param tipo : tipo del hechizo
	@param damage : daño base del hechizo
	@param cantidadHeal : cantidad de puntos de vida que cura
	@param PresionDelAgua : fuerza de presion del agua en el hechizo
	*/
	public Agua(String nombreHechizo, String tipo, int damage, int cantidadHeal, int presionDelAgua) {
		super(nombreHechizo, tipo, damage);
		CantidadHeal = cantidadHeal;
		PresionDelAgua = presionDelAgua;
	}
	/**
	Retorna la cantidad de vida que cura el hechizo
	
	@return cantidad de puntos de vida que cura
	*/
	public int getCantidadHeal() {
		return CantidadHeal;
	}
	/**
	Establece la cantidad de vida que cura el hechizo
	
	@param CantidadHeal : cantidad de puntos de vida que cura*/
	public void setCantidadHeal(int cantidadHeal) {
		CantidadHeal = cantidadHeal;
	}
	/**
	 * Retorna la presion del agua del hechizo
	
	@return presion del agua del hechizo*/
	public int getPresionDelAgua() {
		return PresionDelAgua;
	}
	/*Establece la presion del agua del hechizo
	
	@param PresionDelAgua : valor de la presion del agua del hechizo*/
	public void setPresionDelAgua(int presionDelAgua) {
		PresionDelAgua = presionDelAgua;
	}
	/**
     * Acepta un visitante de tipo HechizoVisitor y delega
     * la operación al método correspondiente del visitante
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
	/**
     * Retorna una representación en texto del hechizo Agua
     * con sus atributos numerados para mostrar al usuario.
     *
     * @return cadena con nombre, daño, cantidad de heal y presión del agua
     */
	@Override
	public String toString() {
		return "1) NombreHechizo=" + NombreHechizo + "\n2) Damage=" + Damage + "\n3) CantidadHeal="
				+ CantidadHeal + "\n4) PresionDelAgua=" + PresionDelAgua;
	}
	
}
