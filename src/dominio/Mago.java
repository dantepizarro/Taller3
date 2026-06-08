package dominio;
import java.util.List;
import java.util.ArrayList;
/**
 * Esta clase representa a los magos en el codigo.
 * Aqui se maneja el nombre del mago y sus hechizos son almacenados en una lista
 */
public class Mago {
	/**
	 * NombreMago es el nombre del mago
	 * hechizos es un ArrayList donde se encuentran los hechizos propios de cada mago
	 * puntuacion es un numero que puede ser decimal el cual dicta la puntuacion del mago segun sus hechizos
	 */
	public String NombreMago;
	public List<Hechizo> hechizos = new ArrayList<>();
	public double puntuacion;
	/**
	 * Este seria el constructor del objeto
	 * @param nombreMago es el nombre del mago que recibe del archivo
	 * @param hechizos es la lista de Hechizos que recibe del archivo
	 */
	public Mago(String nombreMago, List<Hechizo> hechizos) {
		NombreMago = nombreMago;
		this.hechizos = hechizos;
	}
	/**
	 * sirve para conseguir el nombre de algun mago
	 * @return retorna el nombre del mago solicitado
	 */
	public String getNombreMago() {
		return NombreMago;
	}
	/**
	 * Hace que cambie el nombre de todos o un mago especifico
	 * @param nombreMago hace que el nombre de un mago cambie por otro
	 */
	public void setNombreMago(String nombreMago) {
		NombreMago = nombreMago;
	}
	/**
	 * @return retorna la lista de hechizos del mago
	 */
	public List<Hechizo> getHechizos() {
		return hechizos;
	}
	/**
	 * hace que se pueda modificar algun hechizo del mago
	 * @param hechizos son los hechizos del mago 
	 */
	public void setHechizos(List<Hechizo> hechizos) {
		this.hechizos = hechizos;
	}
	/**
	 * esta clase llama al visitor para calcular la puntuaciobn de cada hechizo y sumarsela a la puntiacion del mago
	 * @param visitor pérmite realizar una visita al hechizo del mago y calcular su puntuacion
	 * @return retorna la suma de la puntuacion de los hechizos del mago
	 */
	public double getpuntuacion(HechizoVisitor visitor){
		double puntuacion = 0;
		for(Hechizo h : hechizos) {
	            puntuacion += ((Visitable) h).aceptar(visitor);
				
	        }
		return puntuacion;
	}
	
}
