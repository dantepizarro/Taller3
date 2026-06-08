package dominio;
/**
 * interfaz del patron visitor
 */
public interface Visitable {
	/**
	 * Permite que las clase que implemnete esta interfaz puedan ser visitadas por la clase Hechizo visitor
	 * @param visitante es el que visitara a las clases que lo implemente
	 * @return un numero decimal
	 */
	double aceptar(HechizoVisitor visitante);
}
