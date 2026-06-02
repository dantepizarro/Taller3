package dominio;
import java.util.List;
import java.util.ArrayList;
public class Mago {
	public String NombreMago;
	public List<Hechizo> hechizos = new ArrayList<>();
	public double puntuacion;
	public Mago(String nombreMago, List<Hechizo> hechizos) {
		NombreMago = nombreMago;
		this.hechizos = hechizos;
	}
	public String getNombreMago() {
		return NombreMago;
	}
	public void setNombreMago(String nombreMago) {
		NombreMago = nombreMago;
	}
	public List<Hechizo> getHechizos() {
		return hechizos;
	}
	public void setHechizos(List<Hechizo> hechizos) {
		this.hechizos = hechizos;
	}
	public double getpuntuacion(HechizoVisitor visitor){
		double puntuacion = 0;
		for(Hechizo h : hechizos) {
	            puntuacion += ((Visitable) h).aceptar(visitor);
				
	        }
		return puntuacion;
	}
	
}
