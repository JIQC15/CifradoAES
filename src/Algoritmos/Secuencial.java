package Algoritmos;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Secuencial {

//    public static void main(String[] args) {
//        try {
//            String key = "ClaveSecreta1234"; // Clave de 128 bits
//            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//
//            List<String> words = cargarPalabrasDesdeArchivo("src/ArchivosTXT/SPIDER-MAN.txt");
//
//            int iteraciones = 1; // Número de iteraciones deseado
//
//            long tiempoInicio = System.currentTimeMillis(); // Capturar el tiempo de inicio
//
//            List<byte[]> ciphertexts = cifrarTextos(words, cipher, secretKey, iteraciones);
////            List<String> decryptedTexts = descifrarTextos(ciphertexts, cipher, secretKey, iteraciones);
//
//            long tiempoFin = System.currentTimeMillis(); // Capturar el tiempo de finalización
//            long tiempoTotal = tiempoFin - tiempoInicio;
//            
//            System.out.println("\nCIFRADO SECUENCIAL...");
//            System.out.println("Tiempo total de ejecucion: " + tiempoTotal + " milisegundos");
//            System.out.println("Total de palabras en el texto: " + words.size());
//
//            // Puedes almacenar los textos cifrados y descifrados en arreglos o listas según tus necesidades
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
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
    
    public static List<byte[]> cifrarTextos(List<String> words, Cipher cipher, SecretKeySpec secretKey, int iteraciones) {
        List<byte[]> ciphertexts = new ArrayList<>();
        int palabrasCifradas = 0;

        for (String word : words) {
            byte[] ciphertext = cifrarTextoConIteraciones(word, cipher, secretKey, iteraciones);
            ciphertexts.add(ciphertext);

            // Mostrar el resultado en formato hexadecimal
            mostrarTextoCifradoEnHexadecimal(ciphertext);
            palabrasCifradas++;
        }
        System.out.println("Palabras cifradas: " + palabrasCifradas);
        return ciphertexts;
    }

    public static List<String> descifrarTextos(List<byte[]> ciphertexts, Cipher cipher, SecretKeySpec secretKey, int iteraciones) {
        List<String> decryptedTexts = new ArrayList<>();
        int palabrasDescifradas = 0;

        for (byte[] ciphertext : ciphertexts) {
            // Descifrar el texto y agregarlo a la lista de textos descifrados
            String decryptedText = descifrarTextoConIteraciones(ciphertext, cipher, secretKey, iteraciones);
            decryptedTexts.add(decryptedText);

            // Mostrar el texto descifrado
            mostrarTextoDescifrado(decryptedText);
            palabrasDescifradas++;
        }
        System.out.println("Palabras Descifradas: " + palabrasDescifradas);
        return decryptedTexts;
    }

    public static byte[] cifrarTextoConIteraciones(String texto, Cipher cipher, SecretKeySpec secretKey, int iteraciones) {
        try {
            byte[] plaintextBytes = texto.getBytes();
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Aplicar iteraciones
            for (int i = 0; i < iteraciones; i++) {
                plaintextBytes = cipher.doFinal(plaintextBytes);
            }

            return plaintextBytes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String descifrarTextoConIteraciones(byte[] ciphertext, Cipher cipher, SecretKeySpec secretKey, int iteraciones) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = ciphertext;

            // Aplicar iteraciones inversas (descifrado)
            for (int i = 0; i < iteraciones; i++) {
                decryptedBytes = cipher.doFinal(decryptedBytes);
            }

            return new String(decryptedBytes);
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

    public static void mostrarTextoDescifrado(String decryptedText) {
        System.out.println("Texto descifrado: " + decryptedText);
    }
}
