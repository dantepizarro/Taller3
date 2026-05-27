package logica;

import dominio.*;
import java.util.List;
import java.util.ArrayList;

public class SystemImpl implements Sistema{

	private static List<Hechizo> hechizos = new ArrayList<Hechizo>();
	private static List<Mago> magos = new ArrayList<Mago>();
	@Override
	public void AgregarTierraFuego(String nombreHechizo, String tipo, int damage, int efecto) {
		if(tipo.equalsIgnoreCase("fuego")) hechizos.add(new Fuego(nombreHechizo,tipo,damage,efecto));
		else hechizos.add(new Tierra(nombreHechizo,tipo,damage,efecto));
	}

	@Override
	public void AgregarAguaPlanta(String nombreHechizo, String tipo, int damage, int efecto1, int efecto2) {
		if(tipo.equalsIgnoreCase("agua")) hechizos.add(new Agua(nombreHechizo,tipo,damage,efecto1,efecto2));
		else hechizos.add(new Planta(nombreHechizo,tipo,damage,efecto1,efecto2));
	}

	@Override
	public void AgregarMago(String nombreMago, String[] hechizosMago) {
		List<Hechizo> HechizosMago = new ArrayList<Hechizo>();
		for(int i = 0;i<hechizosMago.length;i++) {
			String hechizo = hechizosMago[i];
			for(Hechizo h: hechizos) {
				if(hechizo.equals(h.getNombreHechizo())) HechizosMago.add(h);
					
			}
		}
		magos.add(new Mago(nombreMago,HechizosMago));
		
	}

}
