package logica;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.naming.directory.InvalidAttributeIdentifierException;

import dominio.*;

public class GuardarHechizo implements HechizoVisitor{
	private boolean append;
	 public GuardarHechizo(boolean append) {
        this.append = append;
    }
	public GuardarHechizo(){
		this.append = true;
	}
	
	@Override
	public double visitar(Fuego fuego) {
		escribir(fuego.getNombreHechizo() + ";" + fuego.getTipo()+ ";" + fuego.getDamage() + ";" + fuego.getDuracionQuemadura()) ;
		this.append = true;
		return 0;
	}

	@Override
	public double visitar(Agua agua) {
		escribir(agua.getNombreHechizo() + ";" + agua.getTipo()+ ";" + agua.getDamage() + ";" + agua.getCantidadHeal() + "," + agua.getPresionDelAgua()) ;
		this.append = true;
		return 0;
	}

	@Override
	public double visitar(Tierra tierra) {
		escribir(tierra.getNombreHechizo() + ";" + tierra.getTipo()+ ";" + tierra.getDamage() + ";" + tierra.getMejoraDefensa()) ;
		this.append = true;
		return 0;
	}

	@Override
	public double visitar(Planta planta) {
		escribir(planta.getNombreHechizo() + ";" + planta.getTipo()+ ";" + planta.getDamage() + ";" + planta.getDuracionStun() + "," + planta.getCantPlantas()) ;
		this.append = true;
		return 0;
	}
	private void escribir(String linea) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Hechizos.txt", append));
			if(append) bw.newLine();
			bw.write(linea);
			bw.close();
			append = true;
		}catch(Exception e) {
			System.out.println("Problemas al guardar el hechizo");
		}
	}
	
	
}
