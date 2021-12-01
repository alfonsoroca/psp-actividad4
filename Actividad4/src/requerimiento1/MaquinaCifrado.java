package requerimiento1;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class MaquinaCifrado {

	// Método estático para cifrar al que se le pasan como parámetros el mensaje a
	// cifrar, el cifrador de la clase Cipher y la sk de la clase SecretKey
	public static byte[] cifrar(String mensaje, Cipher cifrador, SecretKey sk) {

		try {
			// Configuramos el cifrador para encriptar con clave simétrica
			cifrador.init(Cipher.ENCRYPT_MODE, sk);
			System.out.println("Configurado el cifrador para encriptar con clave AES");

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
	// de la clase Cipher, la sk de la clase SecretKey y el mensaje cifrado en un
	// array de bytes
	public static String descifrar(Cipher cifrador, SecretKey sk, byte[] bytesMensajeCifrado) {

		try {
			// Configuramos el cifrador para desencriptar con clave simétrica
			cifrador.init(Cipher.DECRYPT_MODE, sk);

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
}