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
	public void MostrarHechizos() {
		int i = 1;
		for (Hechizo h : hechizos) {
			System.out.println(i+") "+ h.getNombreHechizo());
			i++;
		}
	
	} 
	public void MostrarMagos() {
		int a = 1;
		for (Mago m : magos) {
			System.out.println(a+") "+ m.getNombreMago());
			a++;
		}
	}
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
	public void MostrarMagosPuntuacion(HechizoVisitor visitor) {
	    for(Mago m : magos) {
	        double puntuacionTotal = 0;
	        for(Hechizo h : m.getHechizos()) {
	            puntuacionTotal += ((Visitable) h).aceptar(visitor);
				
	        }
	        System.out.println(m.getNombreMago() + " - Puntuación: " + puntuacionTotal);
	    }
	}
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
}
