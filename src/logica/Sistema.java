package logica;

import java.util.List;
import dominio.*;

public interface Sistema {
	
	void AgregarTierraFuego(String nombreHechizo, String tipo, int damage, int efecto);
	
	void AgregarAguaPlanta(String nombreHechizo, String tipo, int damage, int efecto1, int efecto2);
	
	void AgregarMago(String nombreMago, String[] hechizosMago);



	String getTipoHechizo(int opcion);



	void MostrarHechizos();
	void MostrarMagos();
	void MostrarHechizosMago(int indice);


	void MostrarHechizosPuntuacion(HechizoVisitor visitor);
	void MostrarMagosPuntuacion(HechizoVisitor visitor) ;
	void TopMejoresMagos(HechizoVisitor visitor);
	void TopMejoresHechizos(HechizoVisitor visitor);



	void ModificarMagoNombre(int indice, String newnombre);
	void ModificarMagoAddHechizos(int indice, int indicehechizo);
	void ModificarMagoDeleteHechizos(int indice, int indicehechizo);


	void ReescribirMagos();
	void ReescribirHechizos();


	void EliminarMago(int indice);



	void AgregarTierraFuegoNuevos(String nombreHechizo, String tipo, int damage, int efecto);
	void AgregarAguaPlantaNuevos(String nombreHechizo, String tipo, int damage, int efecto1, int efecto2);
	void AgregarMagosNuevos(String NombreMago, String[] hechizosmago);

	
	void BuscarHechizo(int indice);
	void ModificarHechizo(String Cambio, int opcion, int op);
	void MostrarOpcionesModificar(int indice);
	void EliminarHechizo(int indice);
}
