package dominio;

import logica.GuardarHechizo;
/**
 * Representa un hechizo de tipo Planta.
 * Extiende Hechizo agregando el atributo de duracion de stun y de cantidad de plantas,
 * el primer efecto entrega los segundos que dura el aturdimiento y el segundo la cantida de plantas generadas
 * Implementa Visitable para ser procesado por el patrón Visitor.
 */
public class Planta extends Hechizo implements Visitable{
	public int DuracionStun,CantPlantas;

	/**
	 * Este es el contructor para los hehcizo de tipo planta
	 * @param nombreHechizo el nombre del hechizo 
	 * @param tipo el tipo de hechizo
	 * @param damage indica el daño del ataque
	 * @param duracionStun la cantidad de segundos que dura
	 * @param cantPlantas las plantas generadas
	 */
	public Planta(String nombreHechizo, String tipo, int damage, int duracionStun, int cantPlantas) {
		super(nombreHechizo, tipo, damage);
		DuracionStun = duracionStun;
		CantPlantas = cantPlantas;
	}
	/**
	 * permite retornar a algun metodo la duracion de stun
	 * @return retorna el entero de las duracion
	 */
	public int getDuracionStun() {
		return DuracionStun;
	}
	/**
	 * permite cambiar el valor de la duracion por otro valor
	 * @param duracionStun es el nuevo valor del stun 
	 */
	public void setDuracionStun(int duracionStun) {
		DuracionStun = duracionStun;
	}
	
	/**
	 * permite retornar a algun metodo la cantidad de plantas
	 * @return retorna el entero de las cantidades
	 */
	public int getCantPlantas() {
		return CantPlantas;
	}
	/**
	 * permite cambiar el valor de las cantidades por otro valor
	 * @param duracionStun es el nuevo valor de las plantas
	 */
	public void setCantPlantas(int cantPlantas) {
		CantPlantas = cantPlantas;
	}
	/**
	 * este metodo permite que un visitor pueda interactuar con este objeto en especifico donde sea llamado
	 *@param visitante visitante que procesará este hechizo
     * @return resultado de la operación del visitante
	 */
	public double aceptar(HechizoVisitor visitante) {
		return visitante.visitar(this);
	}
	/**
	 * este metodo funciona de manera que permite recibir un GuardarHechizo para la modificacion o guardado de algun hehcizo
	 * @param guardarHechizo visitante encargado de guardar el hechizo
	 */
	public void aceptar(GuardarHechizo guardarHechizo) {
    	guardarHechizo.visitar(this);
	}
	@Override
	/**
	 * Este metodo permite retornar una cadena de texto
	 * @return retorna la cadena texto que se colocque
	 */
	public String toString() {
		return "1) NombreHechizo=" + NombreHechizo + "\n2) Damage=" + Damage + "\n3) Duracion del Stun="
				+ DuracionStun + "\n4) Cantidad de plantas=" + CantPlantas;
	}
	
}
