/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp4;
import java.util.Scanner;

/**
 *
 * @author Mauro
 */

class TestEmpleado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos empleados querés cargar? ");
        int n = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        Empleado[] empleados = new Empleado[n]; // arreglo para guardar empleados

        for (int i = 0; i < n; i++) {
            System.out.println("\nEmpleado #" + (i + 1));

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Puesto: ");
            String puesto = sc.nextLine();

            System.out.print("¿Deseás ingresar salario inicial? (s/n): ");
            String resp = sc.nextLine();

            if (resp.equalsIgnoreCase("s")) {
                System.out.print("Salario: ");
                double salario = sc.nextDouble();
                sc.nextLine();
                empleados[i] = new Empleado(i + 1, nombre, puesto, salario);
            } else {
                empleados[i] = new Empleado(nombre, puesto); // salario por defecto
            }
        }

        // Mostrar todos los empleados cargados
        System.out.println("\n*** Lista de empleados cargados ***");
        for (Empleado e : empleados) {
            System.out.println(e);
        }
        
        // Aplicar actualizaciones de salario a todos
        System.out.print("\n¿Querés actualizar los salarios por porcentaje o monto fijo? (p/m): ");
        String opcion = sc.nextLine();

        
        if (opcion.equalsIgnoreCase("p")) {
            System.out.print("Ingrese el porcentaje de aumento: ");
            double porc = sc.nextDouble();
            for (Empleado e : empleados) {
                e.actualizarSalario(porc); // usa versión porcentaje
            }
        } else {
            System.out.print("Ingrese el monto fijo a sumar: ");
            int monto = sc.nextInt();
            for (Empleado e : empleados) {
                e.actualizarSalario(monto); // usa versión fija
            }
        }
        
        // Mostrar lista después de actualización
        System.out.println("\n=== Empleados después de actualización ===");
        for (Empleado e : empleados) {
            System.out.println(e);
        }
        
        System.out.println("\nTotal empleados creados: " + Empleado.mostrarTotalEmpleados());

        sc.close();
    }
    
    
}
