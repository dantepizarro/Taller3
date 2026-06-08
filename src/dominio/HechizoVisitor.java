package dominio;
/**
 * Interfaz la cual  define las operaciones de visita para los distintos tipos de hechizos utilizando el patrón Visitor
 
 */
public interface HechizoVisitor {
	/**
	 *En este metodo se recibe un Hechizo de tipo fuego el cual sera visitado 
	 *@param fuego es de tipo Hechizo y sera procesado
	 *@return valor numerico double el cual resultara de la interaccion del visitor
	 */
	double visitar(Fuego fuego);
	/**
	 *En este metodo se recibe un Hechizo de tipo agua el cual sera visitado 
	 *@param fuego es de tipo Hechizo y sera procesado
	 *@return valor numerico double el cual resultara de la interaccion del visitor
	 */
	double visitar(Agua agua);
	/**
	 *En este metodo se recibe un Hechizo de tipo tierra el cual sera visitado 
	 *@param fuego es de tipo Hechizo y sera procesado
	 *@return valor numerico double el cual resultara de la interaccion del visitor
	 */
	double visitar(Tierra tierra);
	/**
	 *En este metodo se recibe un Hechizo de tipo planta el cual sera visitado 
	 *@param fuego es de tipo Hechizo y sera procesado
	 *@return valor numerico double el cual resultara de la interaccion del visitor
	 */
	double visitar(Planta planta);

}
