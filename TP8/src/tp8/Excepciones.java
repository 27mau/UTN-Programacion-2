/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp8;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Mauro
 */

public class Excepciones {

    // 1. División 
    // Demuestra la captura de la excepción ArithmeticException (una excepción Unchecked o no verificada).
    public static void divisionSegura(int a, int b) {
        try {
            // Si b es cero, Java lanza la excepción.
            int r = a / b;
            System.out.println("Resultado: " + r);
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por cero: " + e.getMessage());
        }
    }

    // 2. Conversión segura de String a int
    // Demuestra la captura de la excepción NumberFormatException
    public static void conversionSegura(String texto) {
        try {
            // El bloque try utiliza Integer.parseInt(texto) para convertir la cadena en un entero.
            int valor = Integer.parseInt(texto);
            System.out.println("Valor convertido: " + valor);
        } catch (NumberFormatException e) {
            System.out.println("Formato inválido para entero: " + texto);
        }
    }

    // 3 y 5. Lectura de archivo con try-with-resources
    // Demuestra la gestión de recursos (FileReader, BufferedReader) y la captura de IOException (una excepción Checked o verificada).
    public static void leerArchivo(String ruta) {
        System.out.println("Intentando leer el archivo en: " + ruta);
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            System.out.println("Contenido:");
            while ((linea = br.readLine()) != null) {
                System.out.println(" -> " + linea);
            }
        } catch (IOException e) { // captura FileNotFoundException y otros IOExceptions
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
    }

    // 4. Excepción personalizada para edad
    // Demuestra cómo lanzar manualmente una excepción y el concepto de Excepciones Verificadas (Checked).
    public static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("Edad inválida fuera del rango (0-120): " + edad);
        }
        System.out.println("Edad válida: " + edad);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       // 1. Prueba de División Segura (ArithmeticException)
        System.out.println("\n--- 1. Validación de División por Cero ---");
        System.out.print("Ingrese el numerador: ");
        int num = scanner.nextInt();
        System.out.print("Ingrese el divisor (pruebe con 0 para error, o 2 para éxito): ");
        int den = scanner.nextInt();
        divisionSegura(num, den);

        // 2. Prueba de Conversión Segura (NumberFormatException)
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.println("\n--- 2. Validación de Formato Numérico ---");
        System.out.print("Ingrese texto para convertir (pruebe '123' o 'texto'): ");
        String texto = scanner.nextLine();
        conversionSegura(texto);

       // 3. Prueba de Lectura de Archivo (IOException - Checked)
        System.out.println("\n--- 3. Validación de Acceso a Archivo (try-with-resources) ---");
        System.out.print("Ingrese la ruta de un archivo (pruebe 'archivo_inexistente.txt' para error): ");
        String rutaArchivo = scanner.nextLine();
        leerArchivo(rutaArchivo);

        // 4. Prueba de Excepción Personalizada (EdadInvalidaException - Checked)
        System.out.println("\n--- 4. Validación de Edad (Excepción Personalizada) ---");
        System.out.print("Ingrese una edad válida (ej. 30): ");
        int edadValida = scanner.nextInt();
        System.out.print("Ingrese una edad inválida (ej. 150 o negativo): ");
        int edadInvalida = scanner.nextInt();

        try {
            // Intenta el valor válido
            validarEdad(edadValida);
            
            // Intenta el valor inválido (aquí se lanzará la excepción)
            validarEdad(edadInvalida); 
            
        } catch (EdadInvalidaException e) {
            // Captura la excepción personalizada lanzada
            System.out.println("*** Capturada excepción personalizada: " + e.getMessage());
        }

        scanner.close();
    }
}
