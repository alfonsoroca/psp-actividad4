package requerimiento3;

import java.security.KeyPair;

import javax.crypto.Cipher;
import javax.crypto.SealedObject;

public class MaquinaCifrado {

	// Método estático para cifrar al que se le pasan como parámetros el mensaje a
	// cifrar, el cifrador de la clase Cipher y la kp de la clase KeyPair
	public static byte[] cifrar(String mensaje, Cipher cifrador, KeyPair kp) {

		try {
			// Configuramos el cifrador para encriptar con clave privada
			cifrador.init(Cipher.ENCRYPT_MODE, kp.getPrivate());
			System.out.println("Configurado el cifrador para encriptar con clave RSA");

			// Ciframos el mensaje introducido trabajando en bytes
			byte[] bytesMensaje = mensaje.getBytes();
			byte[] bytesMensajeCifrado = cifrador.doFinal(bytesMensaje);
			System.out.println("Realizado cifrado de: " + mensaje);
			return bytesMensajeCifrado;

		} catch (Exception e) {
			System.out.println("Error en la encriptación -> " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	// Método estático para descifrar al que se le pasan como parámetros el cifrador
	// de la clase Cipher, la kp de la clase KeyPair y el mensaje cifrado en un
	// array de bytes
	public static String descifrar(Cipher cifrador, KeyPair kp, byte[] bytesMensajeCifrado) {

		try {
			// Configuramos el cifrador para desencriptar con clave publica
			cifrador.init(Cipher.DECRYPT_MODE, kp.getPublic());

			// Desciframos el mensaje trabajando en bytes y transformándolo en String
			byte[] bytesMensajeDescifrado = cifrador.doFinal(bytesMensajeCifrado);
			String mensajeDescifrado = new String(bytesMensajeDescifrado);
			return mensajeDescifrado;

		} catch (Exception e) {
			System.out.println("Error en la encriptación -> " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	// Método estático para cifrar objetos al que se le pasan como parámetros el
	// coche de la clase Coche, el cifrador de la clase Cipher y la kp de la clase
	// KeyPair
	public static SealedObject cifrarCoche(Coche c, Cipher cifrador, KeyPair kp) {

		try {
			// Configuramos el cifrador para encriptar con clave privada
			cifrador.init(Cipher.ENCRYPT_MODE, kp.getPrivate());
			System.out.println("Configurado el cifrador para encriptar con clave RSA");

			// Creamos un objeto SealedObject
			SealedObject so = new SealedObject(c, cifrador);
			return so;
		} catch (Exception e) {
			System.out.println("Error en la encriptación -> " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}