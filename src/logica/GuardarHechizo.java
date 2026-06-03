package logica;
import java.io.BufferedWriter;
import java.io.FileWriter;

import dominio.*;

public class GuardarHechizo implements HechizoVisitor{
	
	@Override
	public double visitar(Fuego fuego) {
		escribir(fuego.getNombreHechizo() + ";" + fuego.getTipo()+ ";" + fuego.getDamage() + ";" + fuego.getDuracionQuemadura()) ;
		return 0;
	}

	@Override
	public double visitar(Agua agua) {
		escribir(agua.getNombreHechizo() + ";" + agua.getTipo()+ ";" + agua.getDamage() + ";" + agua.getCantidadHeal() + "," + agua.getPresionDelAgua()) ;
		return 0;
	}

	@Override
	public double visitar(Tierra tierra) {
		escribir(tierra.getNombreHechizo() + ";" + tierra.getTipo()+ ";" + tierra.getDamage() + ";" + tierra.getMejoraDefensa()) ;
		return 0;
	}

	@Override
	public double visitar(Planta planta) {
		escribir(planta.getNombreHechizo() + ";" + planta.getTipo()+ ";" + planta.getDamage() + ";" + planta.getDuracionStun() + "," + planta.getCantPlantas()) ;

		return 0;
	}
	private void escribir(String linea) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Hechizos.txt", true));
			bw.newLine();
			bw.write(linea);
			bw.close();
		}catch(Exception e) {
			System.out.println("Problemas al guardar el hechizo");
		}
	}
	
}
