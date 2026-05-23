package logica;
import java.util.Scanner;
import java.io.File;


public class App {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		LeerHechizos();
		LeerMagos();
		menuInicial();
		scan.close();
	}
	public static void LeerHechizos() {
		try {
			scan = new Scanner(new File("Hechizos.txt"));
			while(scan.hasNextLine()) {
				String[] partes = scan.nextLine().split(";");
				String NombreHechizo = partes[0];
				String Tipo = partes[1];
				int Damage = Integer.parseInt(partes[2]);
				switch(Tipo) {
				case "Fuego":
					int DuracionQuemadura = Integer.parseInt(partes[3]);
					break;
				case "Tierra":
					int MejoraDefensa = Integer.parseInt(partes[3]);
					break;
				case "Planta":
					int DuracionStun = Integer.parseInt(partes[3]);
					int CantPlantas = Integer.parseInt(partes[4]);
					break;
				case "Agua":
					int CantidadHeal = Integer.parseInt(partes[3]);
					int PresionDelAgua = Integer.parseInt(partes[4]);
					break;
				
				}
			}
		}catch(Exception e) {
			System.out.println("problemas con el archivo Hechizos");
		}
	}
	public static void LeerMagos() {
		try {
			scan = new Scanner(new File("Magos.txt"));
			while(scan.hasNextLine()) {
				String[] partes = scan.nextLine().split(";");
				String NombreMago = partes[0];
				String[] Hechizos = partes[1].split("|");
				for(int i = 0;i<Hechizos.length;i++) {
					String Hechizo = Hechizos[i];
				}
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
			opcion = scan.nextInt();
			
			switch(opcion) {
			case 1:
				break;
			case 2:
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
			opcion = scan.nextInt();
			
			switch(opcion) {
			case 1:
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
			opcion = scan.nextInt();
			
			switch(opcion) {
			case 1:
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
				System.out.println("Opcion Invalida");
				break;
			}
			
		}while(opcion != 7);
	}
}
