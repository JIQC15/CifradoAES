package Algoritmos;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Concurrente {

     public static void main(String[] args) {
        try {
            String key = "ClaveSecreta1234"; // Clave de 128 bits
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

            int numberOfWords = 2000;
            List<String> words = generarPalabrasAleatorias(numberOfWords);

            List<byte[]> ciphertexts = new ArrayList<>();

            int numThreads = Runtime.getRuntime().availableProcessors(); // Obtener el número de núcleos del procesador
            ExecutorService executor = Executors.newFixedThreadPool(numThreads);

            long startTime = System.nanoTime(); // Iniciar el cronómetro

            for (String word : words) {
                executor.execute(() -> cifrarYMostrarTextoEnHexadecimal(word, secretKey, ciphertexts));

                // Mostrar la cantidad de hilos activos
                int activeThreads = ((ThreadPoolExecutor) executor).getActiveCount();
                System.out.println("Cantidad de hilos activos: " + activeThreads);
            }

            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

            long endTime = System.nanoTime(); // Detener el cronómetro
            long duration = (endTime - startTime) / 1000000; // Calcular la duración en milisegundos

            System.out.println("Tiempo total (ms): " + duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> generarPalabrasAleatorias(int cantidad) {
        List<String> palabras = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            palabras.add(generarPalabraAleatoria());
        }
        return palabras;
    }

    public static String generarPalabraAleatoria() {
        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder palabra = new StringBuilder();

        int longitud = random.nextInt(10) + 1; // Longitud aleatoria entre 1 y 10 caracteres

        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(alfabeto.length());
            palabra.append(alfabeto.charAt(indice));
        }

        return palabra.toString();
    }

//    public static void cifrarYMostrarTextoEnHexadecimal(String word, SecretKeySpec secretKey, List<byte[]> ciphertexts) {
//        try {
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//
//            byte[] plaintextBytes = word.getBytes();
//            byte[] ciphertext = cipher.doFinal(plaintextBytes);
//
//            synchronized (ciphertexts) {
//                ciphertexts.add(ciphertext);
//                System.out.println("Texto cifrado en hexadecimal: " + bytesToHex(ciphertext));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
    }
    
    public static void cifrarYMostrarTextoEnHexadecimal(String word, SecretKeySpec secretKey, List<byte[]> ciphertexts) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] plaintextBytes = word.getBytes();
            byte[] ciphertext = cipher.doFinal(plaintextBytes);

            synchronized (ciphertexts) {
                ciphertexts.add(ciphertext);
                System.out.println("Texto cifrado en hexadecimal: " + bytesToHex(ciphertext));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}


