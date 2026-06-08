package logica;

import dominio.*;


import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Implementa los metodos de la interfaz Sistema, y realiza todo los operaciones que solicita
 * App, Gestiona la lista de todos los hechizos y magos existentes, y utiliza visitor
 * para realizar calculos de puntajes y puntuaciones totales
 */
public class SystemImpl implements Sistema{
	/**
	 * ArrayList que contiene todos los hechizos existentes
	 * extraidos de Hechizos.txt
	 */
	private static List<Hechizo> hechizos = new ArrayList<Hechizo>();
	/**
	 * ArrayList que contiene todos los magos existentes
	 * extraidos de Magos.txt
	 */
	private static List<Mago> magos = new ArrayList<Mago>();
	/**
	 * Crea un objeto Hechizo del tipo Tierra o Fuego
	 */
	@Override
	public void AgregarTierraFuego(String nombreHechizo, String tipo, int damage, int efecto) {
		if(tipo.equalsIgnoreCase("fuego")) hechizos.add(new Fuego(nombreHechizo,tipo,damage,efecto));
		else hechizos.add(new Tierra(nombreHechizo,tipo,damage,efecto));
	}
	/**
	 * Crea un objeto Hechizo del tipo Agua o Planta
	 */
	@Override
	public void AgregarAguaPlanta(String nombreHechizo, String tipo, int damage, int efecto1, int efecto2) {
		if(tipo.equalsIgnoreCase("agua")) hechizos.add(new Agua(nombreHechizo,tipo,damage,efecto1,efecto2));
		else hechizos.add(new Planta(nombreHechizo,tipo,damage,efecto1,efecto2));
	}
	/**
	 * Agrega un mago leido desde el archivo Magos.txt a la lista global de magos
	 */
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
	/**
	 * Muestra todos los hechizos existentes
	 */
	public void MostrarHechizos() {
		int i = 1;
		for (Hechizo h : hechizos) {
			System.out.println(i+") "+ h.getNombreHechizo());
			i++;
		}
	
	} 
	/**
	 * Muestra todos los magos existentes
	 */
	public void MostrarMagos() {
		int a = 1;
		for (Mago m : magos) {
			System.out.println(a+") "+ m.getNombreMago());
			a++;
		}
	}
	/**
	 * Muestra todos los hechizos con sus puntajes correspondientes
	 */
	public void MostrarHechizosPuntuacion(HechizoVisitor visitor) {
		int i = 1;
		  for(Hechizo h : hechizos) {
		        if(h instanceof Visitable) {
		            double puntuacion = ((Visitable) h).aceptar(visitor);
		            System.out.println(i + ") " +h.getNombreHechizo() + " - Puntuación: " + puntuacion);
		            i ++ ;
		        }
		    }

	}
	/**
	 * Muestra todos los magos existentes con sus puntuaciones totales
	 */
	public void MostrarMagosPuntuacion(HechizoVisitor visitor) {
	    for(Mago m : magos) {
	        double puntuacionTotal = 0;
	        for(Hechizo h : m.getHechizos()) {
	            puntuacionTotal += ((Visitable) h).aceptar(visitor);
				
	        }
	        System.out.println(m.getNombreMago() + " - Puntuación: " + puntuacionTotal);
	    }
	}
	/**
	 * Muestra los 3 magos con puntuacion mas alta
	 */
	public void TopMejoresMagos(HechizoVisitor visitor){

		List<Mago> magosTop = new ArrayList<>(magos);
		for(int a = 0;a<magosTop.size()-1;a++){
			for(int b = 0;b<magosTop.size()-a-1;b++){
				if(magosTop.get(b).getpuntuacion(visitor)<magosTop.get(b+1).getpuntuacion(visitor)){
					Mago temp = magosTop.get(b);
					magosTop.set(b, magosTop.get(b+1));
					magosTop.set(b+1, temp);
				}
			}
		}
		int j= 1;
		for(int i = 0;i<3;i++){
			
			System.out.printf("%d) %s - Puntuación: %.2f\n",j,magosTop.get(i).getNombreMago(),magosTop.get(i).getpuntuacion(visitor));
			j++;
		}
	}
	/**
	 * Muestra los 10 mejores hechizos segun su puntaje
	 */
	public void TopMejoresHechizos(HechizoVisitor visitor){
		List<Hechizo> hechizosTop = new ArrayList<>(hechizos);
		for(int a = 0;a<hechizosTop.size()-1;a++){
			for(int b = 0;b<hechizosTop.size()-a-1;b++){
				if(((Visitable)hechizosTop.get(b)).aceptar(visitor)<((Visitable)hechizosTop.get(b+1)).aceptar(visitor)){
					Hechizo temp = hechizosTop.get(b);
					hechizosTop.set(b, hechizosTop.get(b+1));
					hechizosTop.set(b+1, temp);
				}
			}
		}

		
		for(int i = 0;i<10;i++){
			Hechizo h = hechizosTop.get(i);
			double puntuacion = ((Visitable) h).aceptar(visitor);
			System.out.printf("%d) %s - Daño: %.2f\n",i+1,h.getNombreHechizo(),puntuacion);
			
		}
	}
	/**
	 * Agrega un objeto Hechizo del tipo Tierra o Fuego nuevo a la lista de hechizos
	 */
	@Override
	public void AgregarTierraFuegoNuevos(String nombreHechizo, String tipo, int damage, int efecto) {
		if(tipo.equalsIgnoreCase("fuego")) {
			Fuego f = new Fuego(nombreHechizo,tipo,damage,efecto);
			hechizos.add(f);
			f.aceptar(new GuardarHechizo());
		}else {
			Tierra t = new Tierra(nombreHechizo,tipo,damage,efecto);
			hechizos.add(t);
			t.aceptar(new GuardarHechizo());
		}
	}
	/**
	 * Agrega un objeto Hechizo del tipo Agua o Planta nuevo a la lista de hechizos
	 */
	@Override
	public void AgregarAguaPlantaNuevos(String nombreHechizo, String tipo, int damage, int efecto1, int efecto2) {
		if(tipo.equalsIgnoreCase("planta")) {
			Planta p = new Planta(nombreHechizo,tipo,damage,efecto1,efecto2);
			hechizos.add(p);
			p.aceptar(new GuardarHechizo(true));
		}else {
			Agua a = new Agua(nombreHechizo,tipo,damage,efecto1,efecto2);
			hechizos.add(a);
			a.aceptar(new GuardarHechizo(true));
		}
	}
	/**
	 * Elimina un hechizo seleccionado de la lista de hechizo y de sus txt
	 */
	@Override
	public void EliminarHechizo(int indice) {
		String hechizo = hechizos.get(indice).getNombreHechizo();
		hechizos.remove(indice);
		for(Mago m : magos){
			for(int i = 0; i<m.getHechizos().size(); i++){
				if(m.getHechizos().get(i).getNombreHechizo().equalsIgnoreCase(hechizo)){
					m.getHechizos().remove(i);
					i--;
				}
			}
		}
		

		GuardarHechizo guardador = new GuardarHechizo(false);
		for(Hechizo h : hechizos){
			((Visitable) h).aceptar(guardador);
		}
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("Magos.txt"));
			for(Mago m: magos){
				String linea = m.getNombreMago() + ";";
				for(int i = 0;i<m.getHechizos().size();i++){
					linea = linea + m.getHechizos().get(i).getNombreHechizo();
					if(i<m.getHechizos().size() -1){
						linea = linea + "|";
					}
				}
				bw.write(linea);
				bw.newLine();
			}
			bw.close();
		}catch(IOException e){
			System.out.println("problemas reescribiendo archivos");
		}
	
		
	}
	/**
	 * ELimina un mago seleccionado de la lista de magos y de sus txt
	 */
	@Override
	public void EliminarMago(int indice) {
		String mago = magos.get(indice).getNombreMago();
		magos.remove(indice);
		ReescribirMagos();

	}
	/**
	 * MOdifica el nombre de un mago seleccionado
	 */
	public void ModificarMagoNombre(int indice,String newnombre) {
		magos.get(indice).setNombreMago(newnombre);
		ReescribirMagos();
	}
	/**
	 * Agrega un hechizo a algun mago seleccionado
	 */
	@Override
	public void ModificarMagoAddHechizos(int indice , int indicehechizo) {
		Hechizo h = hechizos.get(indicehechizo);
		magos.get(indice).getHechizos().add(h);
		ReescribirMagos();
	}
	/**
	 * Elimina un hechizo seleccionado de un mago en especifico
	 */
	public void ModificarMagoDeleteHechizos(int indice , int indicehechizo) {
		
		magos.get(indice).getHechizos().remove(indicehechizo);
		ReescribirMagos();
	}
	/**
	 * Reescribe el archivo de Magos.txt
	 */
	@Override
	public void ReescribirMagos() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Magos.txt",false));
			bw.close();
		}catch (Exception e) {
			System.out.println("Error al borrar los magos");
		}
		
		for (Mago m : magos) {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("Magos.txt",true));
				String Hechizos = "";
				for (int i = 0; i < m.getHechizos().size(); i++) {
					if (i == 0) {
						Hechizos += m.getHechizos().get(i).getNombreHechizo();
						
					}else {
						Hechizos += "|" + m.getHechizos().get(i).getNombreHechizo();
					}
				}
				bw.write(m.getNombreMago()+ ";" + Hechizos);
				bw.newLine();
				bw.close();
			}catch(Exception e ) {
				System.out.println("Error al reescribir los magos");
			}
		}
	}
	/**
	 * Muestra los hechizos de un mago seleccionado
	 */
	@Override
	public void MostrarHechizosMago(int indice) {
		List<Hechizo> lista = magos.get(indice).getHechizos();
				for (int i = 0; i<lista.size();i++) {
					System.out.println( (i+1) + ") " +lista.get(i).getNombreHechizo());
				}
	}
	/**
	 * Crea un mago nuevo con sus hechizos seleccionados y lo agrega
	 * a las listas y txts correspondientes
	 */
	@Override
	public void AgregarMagosNuevos(String NombreMago, String[] hechizosmago) {
		List<Hechizo> HechizosMago = new ArrayList<Hechizo>();
		for(int i = 0;i<hechizosmago.length;i++) {
			int  Indicehechizo = Integer.parseInt(hechizosmago[i])-1;
			HechizosMago.add(hechizos.get(Indicehechizo));
			System.out.println(HechizosMago.size());
			
		}
		magos.add(new Mago(NombreMago,HechizosMago));
		ReescribirMagos();
	}
	/**
	 * Modifica el atributo seleccionado de un hechizo especifico
	 */
	@Override
	public void ModificarHechizo(String cambio,int opcion, int op) {
		switch (op) {
			case 1:
				hechizos.get(opcion).setNombreHechizo(cambio);
				ReescribirMagos();
				ReescribirHechizos();	
				break;
		
			case 2:
				int DamageNuevo = Integer.parseInt(cambio);
				hechizos.get(opcion).setDamage(DamageNuevo);
				ReescribirHechizos();
				ReescribirMagos();
				break;
			case 3:
				int efectoNuevo = Integer.parseInt(cambio);
    			Hechizo h = hechizos.get(opcion);
    			switch (h.getTipo().toLowerCase()) {
        			case "fuego":
            			((Fuego) h).setDuracionQuemadura(efectoNuevo);
            			break;
					case "tierra":
						((Tierra) h).setMejoraDefensa(efectoNuevo);
						break;
					case "agua":
						((Agua) h).setCantidadHeal(efectoNuevo);
						break;
					case "planta":
						((Planta) h).setDuracionStun(efectoNuevo);
						break;
    			}
				ReescribirHechizos();
				ReescribirMagos();
				break;
			case 4:
				 int efecto2Nuevo = Integer.parseInt(cambio);
				 h = hechizos.get(opcion);
				switch (h.getTipo().toLowerCase()) {
					case "agua":
						((Agua) h).setPresionDelAgua(efecto2Nuevo);
						break;
					case "planta":
						((Planta) h).setCantPlantas(efecto2Nuevo);
						break;
				}
				ReescribirHechizos();
				ReescribirMagos();
				break;
					}
	}
	/**
	 * Busca un hechizo segun un indice seleccionado
	 */
	@Override
	public void BuscarHechizo(int indice) {
		Hechizo h = hechizos.get(indice);
		System.out.println(h);
	}
	/**
	 * Reescribe el archivo de Hechizos.txt
	 */
	@Override
	public void ReescribirHechizos() {
		GuardarHechizo guardador = new GuardarHechizo(false);
		for(Hechizo h : hechizos){
			((Visitable) h).aceptar(guardador);
		}
	}
	/**
	 * Muestra los atributos modificables para un hechizo seleccionado
	 */
	public void MostrarOpcionesModificar(int indice) {
    Hechizo h = hechizos.get(indice);
    System.out.println("1. Nombre: " + h.getNombreHechizo());
    System.out.println("2. Daño: " + h.getDamage());
    
    switch (h.getTipo().toLowerCase()) {
        case "fuego":
            System.out.println("3. Duración Quemadura: " + ((Fuego) h).getDuracionQuemadura());
            break;
        case "tierra":
            System.out.println("3. Mejora Defensa: " + ((Tierra) h).getMejoraDefensa());
            break;
        case "agua":
            System.out.println("3. Cantidad Heal: " + ((Agua) h).getCantidadHeal());
            System.out.println("4. Presión del Agua: " + ((Agua) h).getPresionDelAgua());
            break;
        case "planta":
            System.out.println("3. Duración Stun: " + ((Planta) h).getDuracionStun());
            System.out.println("4. Cantidad Plantas: " + ((Planta) h).getCantPlantas());
            break;
    }
}
	/**
	 * Retorna el tipo de un hechizo seleccionado
	 */
	@Override
	public String getTipoHechizo(int opcion) {
		return hechizos.get(opcion).getTipo();
	}
	
	


	
}
