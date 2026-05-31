package dominio;

public class Hechizo {
	protected String NombreHechizo,Tipo;
	protected int Damage;
	public Hechizo(String nombreHechizo, String tipo, int damage) {
		NombreHechizo = nombreHechizo;
		Tipo = tipo;
		Damage = damage;
	}
	public String getNombreHechizo() {
		return NombreHechizo;
	}
	public void setNombreHechizo(String nombreHechizo) {
		NombreHechizo = nombreHechizo;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public int getDamage() {
		return Damage;
	}
	public void setDamage(int damage) {
		Damage = damage;
	}
	
	
	
}
