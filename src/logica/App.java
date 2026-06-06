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
			scan.nextLine();
			
			switch(opcion) {
			case 1:
				AgregarMagoNuevo();
				//por terminar
				break;
			case 2:
				ModificarMago();
				break;
			case 3:
				//EliminarMago();
				break;
			case 4:
				AgregarHechizo();
				break;
			case 5:
				//ModificarHechizo;
				break;
			case 6:
				EliminarHechizo();
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
			scan.nextLine();
			
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

	private static void AgregarMagoNuevo(){
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
	public static void ModificarMago() {
		int opcion;
		sys.MostrarMagos();
		System.out.println("Ingrese el numero del mago a modificar");
		System.out.print(">");
		String eleccion = scan.nextLine();
		opcion = Integer.parseInt(eleccion) - 1;
		System.out.println("¿Que te gustaria modificar su nombre o sus hehcizos? \n1) Nombre \n2) Agregar Hechizo \n3) Eliminar Hechizo");
		System.out.print(">");
		int tipo = Integer.parseInt(scan.nextLine());
		switch (tipo) {
		case 1:
			System.out.println("Ingrese el nuevo nombre del Mago");
			String nombre = scan.nextLine();
			sys.ModificarMagoNombre(opcion, nombre);
			break;
		case 2:
			sys.MostrarHechizos();
			System.out.println("Ingrese el hechizo que quiere agregar");
			System.out.print(">");
			int numhechizo = Integer.parseInt(scan.nextLine()) -1;
			sys.ModificarMagoAddHechizos(opcion , numhechizo);
			break;
		case 3:
			sys.MostrarHechizosMago(opcion);
			System.out.println("Ingrese el hechizo que quiere eliminar");
			System.out.print(">");
			int numhechizoD = Integer.parseInt(scan.nextLine())- 1;
			sys.ModificarMagoDeleteHechizos(opcion, numhechizoD);
			break;
		default:
			System.out.println("Opcion no valida");
		}
		
	}	
	private static void AgregarHechizo(){
		String nombreHechizo;
		String tipo;
		int Damage;
		System.out.println();

		System.out.println("Ingrese el nombre del Hechizo: ");
		System.out.print(">");
		nombreHechizo = scan.nextLine();

		System.out.println("Ingrese el tipo del Hechizo: ");
		System.out.print(">");
		tipo = scan.nextLine();

		System.out.println("Ingrese el daño del hechizo: ");
		System.out.print(">");
		String damagestr = scan.nextLine();
		Damage = Integer.parseInt(damagestr);
		if(tipo.equalsIgnoreCase("fuego")) {
				
					System.out.println("Ingrese el valor de Duracion de quemadura: ");
					String DuracionQuemadura = scan.nextLine();
					sys.AgregarTierraFuegoNuevos(nombreHechizo, tipo, Damage, Integer.parseInt(DuracionQuemadura));
		}else if (tipo.equalsIgnoreCase("tierra")) {
					System.out.println("Ingrese el valor de la mejora de defensa: ");
					String MejoraDefensa = scan.nextLine();
					sys.AgregarTierraFuegoNuevos(nombreHechizo, tipo, Damage, Integer.parseInt(MejoraDefensa));
		}else if (tipo.equalsIgnoreCase("planta")) {
				
					System.out.println("Ingrese la duracion del stun: ");
					String DuracionStun = scan.nextLine();
					System.out.println("Ingrese la cantidad de plantas: ");
					String CantPlantas = scan.nextLine();
					sys.AgregarAguaPlantaNuevos(nombreHechizo, tipo, Damage,Integer.parseInt(DuracionStun), Integer.parseInt(CantPlantas));
		}else {
					System.out.println("Ingrese la cantidad de heal: ");
					String CantidadHeal = scan.nextLine();
					System.out.println("Ingrese el daño de presion del agua: ");
					String PresionDelAgua = scan.nextLine();
					sys.AgregarAguaPlantaNuevos(nombreHechizo, tipo, Damage, Integer.parseInt(CantidadHeal), Integer.parseInt(PresionDelAgua));
			}				
				
	}
	private static void EliminarHechizo() {
		int opcion;
		sys.MostrarHechizos();
		System.out.println("Ingresa el numero del hechizo que desea eliminar ");
		System.out.print(">");
		String op = scan.nextLine();
		opcion = Integer.parseInt(op) - 1 ;
		sys.EliminarHechizo(opcion);
		System.out.println("Hechizo eliminado correctamente");
	}
	private static void EliminarMago(){
		int opcion;
		sys.MostrarMagos();
		System.out.println("Ingrese el numero del mago que desea eliminar: ");
		System.out.println(">");
		String op = scan.nextLine();
		opcion = Integer.parseInt(op) -1 ;
		sys.EliminarMago(opcion);
	}
}
