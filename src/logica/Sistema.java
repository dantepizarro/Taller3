package logica;

import java.util.List;
import dominio.*;

public interface Sistema {
	void AgregarTierraFuego(String nombreHechizo, String tipo, int damage, int efecto);
	
	void AgregarAguaPlanta(String nombreHechizo, String tipo, int damage, int efecto1, int efecto2);
	
	void AgregarMago(String nombreMago, String[] hechizosMago);
	
	void MostrarHechizos();
	void MostrarMagos();
	void MostrarHechizosPuntuacion(HechizoVisitor visitor);
	void MostrarMagosPuntuacion(HechizoVisitor visitor) ;
	void TopMejoresMagos(HechizoVisitor visitor);
	void TopMejoresHechizos(HechizoVisitor visitor);
}
