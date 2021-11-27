package requerimiento2;

import javax.crypto.Cipher;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class MaquinaCifrado {

	// Método estático para cifrar
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

	// Método estático para descifrar
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

	// Método estático para cifrar objetos
	public static SealedObject cifrarCoche(Coche c, Cipher cifrador, SecretKey sk) {

		try {
			
			// Configuramos el cifrador para encriptar con clave simétrica
			cifrador.init(Cipher.ENCRYPT_MODE, sk);
			System.out.println("Configurado el cifrador para encriptar con clave AES");
			
			// Creamos un objeto SealedObject
			SealedObject so = new SealedObject(c, cifrador);
			return so;
		} catch (Exception e) {
			System.out.println("Error en la desencriptación -> " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}