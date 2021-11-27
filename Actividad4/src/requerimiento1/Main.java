package requerimiento1;

import java.security.GeneralSecurityException;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

// Clase que ejecuta el código main para el programa
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String mensaje = null;
		String mensajeCifrado = null;
		byte[] bytesMensajeCifrado = null;
		int opcion = 8;

		try {

			System.out.println("---------Máquina de cifrado---------\n");
			// Creamos el generador de claves
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			System.out.println("Generador de claves creado....");

			// Generamos la clave simetrica.
			SecretKey sk = kg.generateKey();
			System.out.println("Clave generada...");

			// Creamos el objeto para encriptar o desencriptar a partir de la clave
			Cipher cifrador = Cipher.getInstance("AES");
			System.out.println("Cifrador generado...");

			do {

				System.out.println("\n-----Elige la opción que deseas-----");
				System.out.println("	0. Salir");
				System.out.println("	1. Encriptar frase");
				System.out.println("	2. Mostrar frase encriptada");
				System.out.println("	3. Desencriptar frase");

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
					bytesMensajeCifrado = MaquinaCifrado.cifrar(mensaje, cifrador, sk);
					mensajeCifrado = new String(bytesMensajeCifrado);
					break;

				case 2:
					System.out.println("El mensaje cifrado es: " + mensajeCifrado);
					break;

				case 3:
					System.out.println("Descifrando: " + mensajeCifrado);
					mensaje = new String(MaquinaCifrado.descifrar(cifrador, sk, bytesMensajeCifrado));
					System.out.println("Mensaje descifrado: " + mensaje);
					break;

				default:
					System.out.println("Debes elegir una opción del 0 al 3");
				}

			} while (opcion != 0);

		} catch (GeneralSecurityException gse) {
			System.out.println("Error en la encriptación -> " + gse.getMessage());
			gse.printStackTrace();
		}

		// Cerramos el Scanner
		sc.close();
	}
}