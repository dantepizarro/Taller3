package logica;

import java.util.List;
import dominio.*;
/**
 * Interfaz que define los metodos disponibles en el sistema de gestion 
 * de magos y hechizos
 * es implementada en SystemImpl
 * 
 */
public interface Sistema {
	/**
     * Agrega un hechizo de tipo Fuego o Tierra al sistema (carga desde archivo)
     *
     * @param nombreHechizo nombre del hechizo
     * @param tipo          tipo del hechizo ("Fuego" o "Tierra")
     * @param damage        daño base del hechizo
     * @param efecto        efecto específico (DuracionQuemadura o MejoraDefensa)
     */
	void AgregarTierraFuego(String nombreHechizo, String tipo, int damage, int efecto);
	/**
     * Agrega un hechizo de tipo Agua o Planta al sistema (carga desde archivo)
     *
     * @param nombreHechizo nombre del hechizo
     * @param tipo          tipo del hechizo ("Agua" o "Planta")
     * @param damage        daño base del hechizo
     * @param efecto1       primer efecto (CantidadHeal o DuracionStun)
     * @param efecto2       segundo efecto (PresionDelAgua o CantPlantas)
     */
	void AgregarAguaPlanta(String nombreHechizo, String tipo, int damage, int efecto1, int efecto2);
	/**
     * Agrega un mago al sistema buscando sus hechizos por nombre (carga desde archivo)
     *
     * @param nombreMago   nombre del mago
     * @param hechizosMago arreglo con los nombres de los hechizos del mago
     */
	void AgregarMago(String nombreMago, String[] hechizosMago);
	/**
     * Retorna el tipo del hechizo ubicado en el índice dado.
     *
     * @param opcion índice del hechizo en la lista
     * @return tipo del hechizo ("Fuego", "Agua", "Tierra" o "Planta")
     */
	String getTipoHechizo(int opcion);
	/**
	 * Imprime todos los hechizos existentes en el archivo Hechizos.txt
	 * enumerados para poder usar su indice en caso de ser necesario
	 */
	void MostrarHechizos();
	/**
	 * Imprime todos los nombres de magos existentes en el archivo Magos.txt
	 * enumerados para poder usar su indice en caso de ser necesario
	 */
	void MostrarMagos();
	/**
	 * Recorre la lista de hechizos de un mago en especifico
	 * e imprime esta lista de hechizos
	 * @param indice : indice del mago seleccionado desde el menu
	 */
	void MostrarHechizosMago(int indice);
	/**
	 * Imprime la puntuacion de todos los hechizos existentes
	 * utiliza visitor para visitar cada hechizo y realizar su calculo de puntaje
	 * @param visitor : visita cada instancia de hechizo y calcula su puntaje
	 */
	void MostrarHechizosPuntuacion(HechizoVisitor visitor);
	/**
	 * Imprime la puntuacion total de cada mago existente
	 * utiliza visitor para visitar cada mago y recorre su lista de hechizos
	 * para realizar el calculo de puntaje
	 * @param visitor : visita cada mago y calcula su puntuacion total
	 */
	void MostrarMagosPuntuacion(HechizoVisitor visitor) ;
	/**
	 * Ordena la lista de magos segun su puntuacion total (de mayor a menor)
	 * Imprime los 3 mejores magos segun su puntuacion total
	 * @param visitor : visita cada mago y calcula su puntuacion
	 */
	void TopMejoresMagos(HechizoVisitor visitor);
	/**
	 * Ordena la lista de hechizos segun su puntaje (de mayor a menor)
	 * Imprime los 10 mejores hechizos 
	 * @param visitor : visita cada hechizo y calcula su puntaje
	 */
	void TopMejoresHechizos(HechizoVisitor visitor);
	/**
	 * Modifica el nombre de un mago seleccionado con un nuevo nombre
	 * ingresado por teclado, a su vez muestra esta modificacion
	 * en el archivo correspondiente
	 * @param indice : indice del mago seleccionado
	 * @param newnombre : nuevo nombre para el mago
	 */
	void ModificarMagoNombre(int indice, String newnombre);
	/**
	 * Agrega un hechizo especifico a la lista de un mago seleccionado
	 * @param indice : indice del mago seleccionado
	 * @param indicehechizo : indice del hechizo seleccionado
	 */
	void ModificarMagoAddHechizos(int indice, int indicehechizo);
	/**
	 * Elimina un hechizo especifico de la lista de un mago seleccionado
	 * @param indice : indice del mago seleccionado
	 * @param indicehechizo : indice del hechizo seleccionado
	 */
	void ModificarMagoDeleteHechizos(int indice, int indicehechizo);
	/**
	 * Reescribe el archivo Magos.txt cada vez que es llamado
	 * utiliza la lista de magos y recorre sus hechizos
	 */
	void ReescribirMagos();
	/**
	 * Reescribe el archivo Hechizos.txt cada vez que es llamado
	 * utiliza la lista de hechizos para escribir cada hechizo existente
	 */
	void ReescribirHechizos();
	/**
	 * Elimina un mago seleccionado con un indice
	 * tambien llama a ReescribirMagos para eliminar al mago
	 * del archivo
	 * @param indice : indice del mago seleccionado
	 */
	void EliminarMago(int indice);
	/**
     * Agrega un hechizo de tipo Fuego o Tierra ingresado por el usuario
     * y lo escribe en el archivo.
     *
     * @param nombreHechizo nombre del hechizo
     * @param tipo          tipo del hechizo ("Fuego" o "Tierra")
     * @param damage        daño base del hechizo
     * @param efecto        efecto específico del tipo
     */
	void AgregarTierraFuegoNuevos(String nombreHechizo, String tipo, int damage, int efecto);
	/**
     * Agrega un hechizo de tipo Agua o Planta ingresado por el usuario
     * y lo escribe en el archivo.
     *
     * @param nombreHechizo nombre del hechizo
     * @param tipo          tipo del hechizo ("Agua" o "Planta")
     * @param damage        daño base del hechizo
     * @param efecto1       primer efecto específico del tipo
     * @param efecto2       segundo efecto específico del tipo
     */
	void AgregarAguaPlantaNuevos(String nombreHechizo, String tipo, int damage, int efecto1, int efecto2);
	 /**
     * Agrega un mago nuevo ingresado por el usuario y lo escribe en el archivo.
     *
     * @param NombreMago   nombre del mago
     * @param hechizosmago arreglo con los índices (como String) de sus hechizos
     */
	void AgregarMagosNuevos(String NombreMago, String[] hechizosmago);
	/**
	 * Buca un hechizo espefico utilizando un indice seleccionado
	 * e imprime su metodo ToString
	 * @param indice : indice del hechizo seleccionado
	 */
	void BuscarHechizo(int indice);
	/**
	 * Dependiendo de la opcion seleccionada, modifca cierto atributo de un
	 * hechizo, ademas llama a ReescribirMagos y ReescribirHechizos para
	 * mostrar los cambios realizados en los archivos
	 * @param Cambio : valor nuevo para el atributo del hechizo
	 * @param opcion : indice del hechizo a modificar
	 * @param op : atributo en especifico que desea modificar
	 */
	void ModificarHechizo(String Cambio, int opcion, int op);
	/**
	 * Muestra todas las opciones modificables de un hechizo
	 * dependiendo de su tipo y la cantidad de atributos que posee
	 * @param indice : indice del hechizo seleccionado
	 */
	void MostrarOpcionesModificar(int indice);
	/**
	 * ELimina un hechizo seleccionado con un indice
	 * llama a ReescribirHechizos y ReescribirMagos para
	 * modificar estos archivos
	 * @param indice
	 */
	void EliminarHechizo(int indice);
}
