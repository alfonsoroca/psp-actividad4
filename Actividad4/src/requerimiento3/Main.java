package requerimiento3;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.SealedObject;

// Clase que ejecuta el código main para el programa
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String mensaje = null;
		String mensajeCifrado = null;
		byte[] bytesMensajeCifrado = null;
		Coche c;
		SealedObject so;
		int opcion = 8;

		try {

			System.out.println("---------Máquina de cifrado---------\n");
			// Creamos el generador de claves
			KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
			System.out.println("Generador de claves creado....");

			// Generamos el par de claves privada y pública
			KeyPair kp = kg.generateKeyPair();
			System.out.println("Claves privada y pública generadas...");

			// Creamos el objeto para encriptar o desencriptar a partir de la clave
			Cipher cifrador = Cipher.getInstance("RSA");
			System.out.println("Cifrador generado...");

			do {

				System.out.println("\n-----Elige la opción que deseas-----");
				System.out.println("	0. Salir");
				System.out.println("	1. Encriptar frase");
				System.out.println("	2. Mostrar frase encriptada");
				System.out.println("	3. Desencriptar frase");
				System.out.println("	4. Encriptar coche");

				try {
					opcion = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e) {
				}

				switch (opcion) {

				case 0:
					System.out.println("Saliendo de la máquina de cifrado.....");
					break;

				case 1:
					System.out.println("Introduce la frase a cifrar.....");
					mensaje = sc.nextLine();
					bytesMensajeCifrado = MaquinaCifrado.cifrar(mensaje, cifrador, kp);
					mensajeCifrado = new String(bytesMensajeCifrado);
					break;

				case 2:
					System.out.println("El mensaje cifrado es: " + mensajeCifrado);
					break;

				case 3:
					System.out.println("Descifrando: " + mensajeCifrado);
					mensaje = new String(MaquinaCifrado.descifrar(cifrador, kp, bytesMensajeCifrado));
					System.out.println("Mensaje descifrado: " + mensaje);
					break;

				// Se solicitan los datos de un coche que posteriormente se pasa como argumento
				// al llamar al método estático cifrarCoche()
				case 4:
					System.out.println("Introduce los datos del coche a cifrar...");
					System.out.println("Introduce matrícula...");
					String matricula = sc.nextLine();
					System.out.println("Introduce marca...");
					String marca = sc.nextLine();
					System.out.println("Introduce modelo...");
					String modelo = sc.nextLine();
					System.out.println("Introduce precio...");
					double precio = Double.parseDouble(sc.nextLine());
					c = new Coche(matricula, marca, modelo, precio);
					so = MaquinaCifrado.cifrarCoche(c, cifrador, kp);
					System.out.println("Coche para cifrar: " + c);
					System.out.println("Coche cifrado: " + so.toString());
					break;

				default:
					System.out.println("Debes elegir una opción del 0 al 4");
				}

			} while (opcion != 0);

		} catch (Exception e) {
			System.out.println("Error en la encriptación -> " + e.getMessage());
			e.printStackTrace();
		}
		// Cerramos el Scanner
		sc.close();
	}
}