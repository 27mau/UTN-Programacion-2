/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6;

/**
 *
 * @author Mauro
 */
public class SistemaUniversidadMain {
    
    public static void main(String[] args) {
        System.out.println("--- INICIO DEL SISTEMA UNIVERSITARIO ---");

        // Crear la universidad
        Universidad universidad = new Universidad("Universidad Tecnológica Nacional");

        // 2. Crear 3 profesores (codigo, Nombre, Especialidad)
        System.out.println("\n--- 1. CREANDO PROFESORES Y 5 CURSOS... ---");
        Profesor prof1 = new Profesor("616","Dr. Nicolas Tesla", "Física Teórica");
        Profesor prof2 = new Profesor("626", "Ing. Helena Poenix", "Análisis Matemático");
        Profesor prof3 = new Profesor("636", "Lic. Luz Andonian", "Programación");
        
        universidad.agregarProfesor(prof1);
        universidad.agregarProfesor(prof2);
        universidad.agregarProfesor(prof3);
        
        // 2. Crear 5 cursos y agregarlos a la universidad
        System.out.println("\n--- 2. AGREGANDO PROFESORES  Y CURSOS A LA UNIVERSIDAD... ---");
        Curso c1 = new Curso("FIS101", "Física I", null, 40);
        Curso c2 = new Curso("MAT102", "Análisis Matemático I", null, 50);
        Curso c3 = new Curso("QUI101", "Química General", null, 35);
        Curso c4 = new Curso("INF201", "Algoritmos y Estructura de Datos", null, 60);
        Curso c5 = new Curso("MAT203", "Análisis Matemático II", null, 45);

        universidad.agregarCurso(c1);
        universidad.agregarCurso(c2);
        universidad.agregarCurso(c3);
        universidad.agregarCurso(c4);
        universidad.agregarCurso(c5);
        
        // 3. Asignar profesores a cursos
        System.out.println("\n--- 3. ASIGNAR PROFESORES A CURSOS ---");
        universidad.asignarProfesorACurso("FIS101", prof1);
        universidad.asignarProfesorACurso("QUI101", prof1);
        universidad.asignarProfesorACurso("MAT102", prof2);
        universidad.asignarProfesorACurso("MAT203", prof2);
        universidad.asignarProfesorACurso("INF201", prof3);

        // 4. Listar cursos y profesores
        System.out.println("\n--- 4. LISTADO DE CURSOS ---");
        universidad.listarCursos();
        System.out.println("\n--- LISTADO DE PROFESORES ---");
        universidad.listarProfesores();
        
        // 5. Cambiar profesor de un curso y verificar sincronización
        System.out.println("\n--- 5. CAMBIANDO PROFESOR DEL CURSO FIS101 ---");
        universidad.asignarProfesorACurso("FIS101", prof3);

        universidad.listarCursos();
        universidad.listarProfesores();

        // 6. Remover un curso y confirmar que se elimina del profesor
        System.out.println("\n--- 6. ELIMINANDO CURSO QUI101 ---");
        universidad.removerCurso("QUI101");
        universidad.listarProfesores();
        
        // 7. Remover un profesor y dejar cursos con profesor = null
        System.out.println("\n--- 7. ELIMINANDO PROFESOR 626 (Helena Poenix) ---");
        universidad.removerProfesor("626");
        universidad.listarCursos();

        // 8. Reporte de cantidad de cursos por profesor
        System.out.println("\n--- 8. REPORTE: CANTIDAD DE CURSOS POR PROFESOR ---");
        universidad.reporteCursosPorProfesor();

        System.out.println("\n--- FIN DEL PROGRAMA ---");
    }
}
