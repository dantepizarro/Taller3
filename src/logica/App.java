package logica;
import java.util.Scanner;

import dominio.HechizoVisitor;

import java.io.File;


public class App {
	private static Scanner scan = new Scanner (System.in);
	private static Sistema sys = new SystemImpl();
	public static void main(String[] args) {
		
		LeerHechizos();
		LeerMagos();
		menuInicial();
		scan.close();
	}
	public static void LeerHechizos() {
		try {
			Scanner scanHechizo = new Scanner(new File("Hechizos.txt"));
			while(scanHechizo.hasNextLine()) {
				String[] partes = scanHechizo.nextLine().split(";");
				String NombreHechizo = partes[0];
				String Tipo = partes[1];
				int Damage = Integer.parseInt(partes[2]);
				switch(Tipo) {
				case "Fuego":
					int DuracionQuemadura = Integer.parseInt(partes[3]);
					sys.AgregarTierraFuego(NombreHechizo, Tipo, Damage, DuracionQuemadura);
					break;
				case "Tierra":
					int MejoraDefensa = Integer.parseInt(partes[3]);
					sys.AgregarTierraFuego(NombreHechizo, Tipo, Damage, MejoraDefensa);
					break;
				case "Planta":
					String[] partes1 = partes[3].split(",");
					int DuracionStun = Integer.parseInt(partes1[0]);
					int CantPlantas = Integer.parseInt(partes1[1]);
					sys.AgregarAguaPlanta(NombreHechizo, Tipo, Damage, DuracionStun, CantPlantas);
					break;
				case "Agua":
					String[] partes2 = partes[3].split(",");
					int CantidadHeal = Integer.parseInt(partes2[0]);
					int PresionDelAgua = Integer.parseInt(partes2[1]);
					sys.AgregarAguaPlanta(NombreHechizo, Tipo, Damage, CantidadHeal, PresionDelAgua);
					break;
				
				}
			}
		}catch(Exception e) {
			System.out.println("problemas con el archivo Hechizos");
		}
	}
	public static void LeerMagos() {
		try {
			Scanner scanMagos = new Scanner(new File("Magos.txt"));
			while(scanMagos.hasNextLine()) {
				String[] partes = scanMagos.nextLine().split(";");
				String NombreMago = partes[0];
				String[] Hechizos = partes[1].split("\\|");
				sys.AgregarMago(NombreMago, Hechizos);
			}
		}catch(Exception e) {
			System.out.println("problemas con el archivo magos");
		}
	}
	public static void menuInicial() {
		int opcion;
		do {
			System.out.println("Elige el menu que quieras utilizar: ");
			System.out.println("1) Menu Administrador");
			System.out.println("2) Menu Analista");
			System.out.println("3) Salir");
			System.out.print(">");
			opcion = scan.nextInt();
			
			switch(opcion) {
			case 1:
				menuAdministrador();
				break;
			case 2:
				menuAnalista();
				break;
			}
		}while(opcion != 3);
	}
	public static void menuAdministrador() {
		int opcion;
		do {
			System.out.println("=====Menu Administrador=====");
			System.out.println("1. Agregar Mago");
			System.out.println("2. Modificar Mago");
			System.out.println("3. Eliminar Mago");
			System.out.println("4. Agregar Hechizo");
			System.out.println("5. Modificar Hechizo");
			System.out.println("6. Eliminar Hechizo");
			System.out.println("7. Salir");
			System.out.print(">");
			opcion = scan.nextInt();
			
			switch(opcion) {
			case 1:
				AgregarMago();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				return;
			default:
				System.out.println("Opcion invalida");
				break;
			}
			
		}while(opcion != 7);
	}
	public static void menuAnalista() {
		int opcion;
		do {
			System.out.println("=====Menu Analista=====");
			System.out.println("1. Top 10 Mejores Hechizos");
			System.out.println("2. Top 3 Mejores Magos");
			System.out.println("3. Mostrar todos los Hechizos");
			System.out.println("4. Mostrar todos los magos");
			System.out.println("5. Mostrar todos los Hechizos junto a su puntuacion");
			System.out.println("6. Mostrar todos los magos junto a su puntuacion");
			System.out.println("7. Salir");
			System.out.print(">");
			opcion = scan.nextInt();
			
			switch(opcion) {
			case 1:
				sys.TopMejoresHechizos(new PuntuacionVisitor());
				break;
			case 2:
				sys.TopMejoresMagos(new PuntuacionVisitor());
				break;
			case 3:
				sys.MostrarHechizos();
				break;
			case 4:
				sys.MostrarMagos();
				break;
			case 5:
				sys.MostrarHechizosPuntuacion(new PuntuacionVisitor());
				break;
			case 6:
				sys.MostrarMagosPuntuacion(new PuntuacionVisitor());
				break;
			case 7:
				return;
			default:
				System.out.println("Opcion Invalida");
				break;
			}
			
		}while(opcion != 7);
	}

	private static void AgregarMago(){
		System.out.println();

		System.out.println("Ingrese el nombre del mago: ");
		String NombreMago = scan.nextLine();
		String respuesta;
		String[] hechizoStrings = null;
		do{
			System.out.println("Desea agregarle hechizos?");
			System.out.print(">");
			respuesta = scan.nextLine();
			if(respuesta.equalsIgnoreCase("si")){
				sys.MostrarHechizos();
				System.out.println("Que hechizos desea agregar? (hechizo1,hechizo2,etc)");
				String hechizos = scan.nextLine();
				hechizoStrings = hechizos.split(",");
			}
			sys.AgregarMago(NombreMago, hechizoStrings);
			//Crear AgregarMagoNuevo, que incluya el bufferwriter
			
		}while(respuesta.equalsIgnoreCase("si"));
	}
		
	private static void AgregarHechizo(){
		System.out.println();

		System.out.println("Ingrese el nombre del Hechizo: ");
	}
}
