package logica;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.naming.directory.InvalidAttributeIdentifierException;

import dominio.*;
/** 
 * Esta clase la cual implementa la interfaz de Hechizovisitor permite al sistema escribir nuevos 
 * hechizos o modificarlos
 * mediante un bufferedwriter el cual cambia si es true o false se modifica el archivo Hechizos-txt
 */
public class GuardarHechizo implements HechizoVisitor{
	private boolean append;
	/**
	 *cambia el valor de append a true o false
	 * @param append es un booleano de tipo true o false
	 */
	 public GuardarHechizo(boolean append) {
        this.append = append;
    }
	 /**
	  * obliga a cambiar a append a true
	  */
	public GuardarHechizo(){
		this.append = true;
	}
	
	@Override
	/**
	 * permite que el visitor visite a una instancia de tipo fuego y la escriba
	 * @param Hechizo de tipo fuego
	 * @retunr retorna 0 pero no se utuliza es numero
	 */
	public double visitar(Fuego fuego) {
		escribir(fuego.getNombreHechizo() + ";" + fuego.getTipo()+ ";" + fuego.getDamage() + ";" + fuego.getDuracionQuemadura()) ;
		this.append = true;
		return 0;
	}

	@Override
	/**
	 * permite que el visitor visite a una instancia de tipo fuego y la escriba
	 * @param Hechizo de tipo fuego
	 * @retunr retorna 0 pero no se utuliza es numero
	 */
	public double visitar(Agua agua) {
		escribir(agua.getNombreHechizo() + ";" + agua.getTipo()+ ";" + agua.getDamage() + ";" + agua.getCantidadHeal() + "," + agua.getPresionDelAgua()) ;
		this.append = true;
		return 0;
	}

	@Override
	/**
	 * permite que el visitor visite a una instancia de tipo tierra y la escriba
	 * @param Hechizo de tipo tierra
	 * @retunr retorna 0 pero no se utuliza es numero
	 */
	public double visitar(Tierra tierra) {
		escribir(tierra.getNombreHechizo() + ";" + tierra.getTipo()+ ";" + tierra.getDamage() + ";" + tierra.getMejoraDefensa()) ;
		this.append = true;
		return 0;
	}

	@Override
	/**
	 * permite que el visitor visite a una instancia de tipo planta y la escriba
	 * @param Hechizo de tipo planta
	 * @retunr retorna 0 pero no se utuliza es numero
	 */
	public double visitar(Planta planta) {
		escribir(planta.getNombreHechizo() + ";" + planta.getTipo()+ ";" + planta.getDamage() + ";" + planta.getDuracionStun() + "," + planta.getCantPlantas()) ;
		this.append = true;
		return 0;
	}
	/*
	 * Este metodo del visitante escribe el hechizo que se visito en el txt dependiendo del append modifica
	 * o elimina un hechizo
	 * @param linea son los datos del hechizo escrito como string 
	 */
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
