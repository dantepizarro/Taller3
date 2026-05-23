package dominio;

public class Tierra extends Hechizo{
	public int MejoraDefensa;

	public Tierra(String nombreHechizo, String tipo, int damage, int mejoraDefensa) {
		super(nombreHechizo, tipo, damage);
		MejoraDefensa = mejoraDefensa;
	}

	public int getMejoraDefensa() {
		return MejoraDefensa;
	}

	public void setMejoraDefensa(int mejoraDefensa) {
		MejoraDefensa = mejoraDefensa;
	}
	
	
}
