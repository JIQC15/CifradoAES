package Algoritmos;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Secuencial {

    public static void main(String[] args) {
        try {
            String key = "ClaveSecreta1234"; // Clave de 128 bits
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            List<String> words = cargarPalabrasDesdeArchivo("src/ArchivosTXT/Lorem.txt"); // Reemplaza con la ruta de tu archivo

            List<byte[]> ciphertexts = new ArrayList<>();

            long tiempoInicio = System.currentTimeMillis(); // Capturar el tiempo de inicio

            for (String word : words) {
                byte[] ciphertext = cifrarTexto(word, cipher, secretKey);
                ciphertexts.add(ciphertext);

                // Mostrar el resultado en formato hexadecimal
                mostrarTextoCifradoEnHexadecimal(ciphertext);
            }

            long tiempoFin = System.currentTimeMillis(); // Capturar el tiempo de finalización
            long tiempoTotal = tiempoFin - tiempoInicio;
            System.out.println("Tiempo total de ejecución: " + tiempoTotal + " milisegundos");

            // Puedes almacenar los textos cifrados en un arreglo, lista o archivo según tus necesidades
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> cargarPalabrasDesdeArchivo(String rutaArchivo) {
        List<String> palabras = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                palabras.add(linea);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return palabras;
    }

    public static byte[] cifrarTexto(String texto, Cipher cipher, SecretKeySpec secretKey) {
        try {
            byte[] plaintextBytes = texto.getBytes();
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(plaintextBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void mostrarTextoCifradoEnHexadecimal(byte[] ciphertext) {
        System.out.print("Texto cifrado en hexadecimal: ");
        for (byte b : ciphertext) {
            System.out.print(String.format("%02X", b));
        }
        System.out.println();
    }
}


