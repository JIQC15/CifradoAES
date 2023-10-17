package Algoritmos;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Secuencial {

    public static void main(String[] args) {
        try {
//            String key = "ClaveSecreta1234"; // Clave de 128 bits
            String key = "ClaveSecreta1234ClaveSecreta1234"; //Clave 196 bites
//            String key = "ClaveSecreta1234ClaveSecreta1234ClaveSecreta1234"; //Clave 256 bites
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            List<String> words = cargarPalabrasDesdeArchivo("src/ArchivosTXT/SPIDER-MAN.txt");

            List<byte[]> ciphertexts = new ArrayList<>();
            List<String> decryptedTexts = new ArrayList<>(); // Lista para almacenar los textos descifrados

            long tiempoInicio = System.currentTimeMillis(); // Capturar el tiempo de inicio

            cifrarYDescifrarTextos(words, cipher, secretKey, ciphertexts, decryptedTexts);

            long tiempoFin = System.currentTimeMillis(); // Capturar el tiempo de finalización
            long tiempoTotal = tiempoFin - tiempoInicio;
            System.out.println("Tiempo total de ejecucion: " + tiempoTotal + " milisegundos");
            System.out.println("Total de palabras en el texto: " + words.size());

            // Puedes almacenar los textos cifrados y descifrados en arreglos o listas según tus necesidades
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int contarPalabrasEnTexto(String texto) {
        String[] palabras = texto.split("\\s+"); // Divide el texto en palabras usando espacios en blanco como delimitadores
        return palabras.length;
    }

    public static List<String> cargarPalabrasDesdeArchivo(String rutaArchivo) {
        List<String> palabras = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en palabras utilizando espacios en blanco como separadores
                String[] palabrasEnLinea = linea.split("\\s+");
                palabras.addAll(Arrays.asList(palabrasEnLinea));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return palabras;
    }

    public static void cifrarYDescifrarTextos(List<String> words, Cipher cipher, SecretKeySpec secretKey,
                                              List<byte[]> ciphertexts, List<String> decryptedTexts) {
        int palabrasCifradas = 0;
        int saltoLineaCada = 1000; // Cambiar a 1000 para hacer un salto de línea cada 1000 palabras

        for (String word : words) {
            byte[] ciphertext = cifrarTexto(word, cipher, secretKey);
            ciphertexts.add(ciphertext);

            // Mostrar el resultado en formato hexadecimal
            mostrarTextoCifradoEnHexadecimal(ciphertext);

            // Descifrar el texto y agregarlo a la lista de textos descifrados
//            String decryptedText = descifrarTexto(ciphertext, cipher, secretKey);
//            decryptedTexts.add(decryptedText);

            // Mostrar el texto descifrado
//            mostrarTextoDescifrado(decryptedText);

            palabrasCifradas++;

            // Hacer un salto de línea si hemos cifrado un múltiplo de "saltoLineaCada" palabras
            if (palabrasCifradas % saltoLineaCada == 0) {
                System.out.println();
            }
        }
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

    public static String descifrarTexto(byte[] ciphertext, Cipher cipher, SecretKeySpec secretKey) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(ciphertext);
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void mostrarTextoDescifrado(String decryptedText) {
        System.out.println("Texto descifrado: " + decryptedText);
    }
}
