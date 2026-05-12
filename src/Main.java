public class Main {
public static void main(String[] args) {

        // =====================================================
        // CREAR EL ARBOL BINARIO DE BUSQUEDA
        // =====================================================

        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        // =====================================================
        // INSERTAR VALORES EN EL ARBOL
        // =====================================================

        System.out.println("=== INSERTANDO VALORES EN EL ARBOL ===");

        arbol.insertar(50);
        arbol.insertar(100);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Valores insertados correctamente.\n");

        // =====================================================
        // MOSTRAR RECORRIDOS DEL ARBOL
        // =====================================================

        System.out.println("=== RECORRIDOS DEL ARBOL ===");

        // Recorrido In-Order
        // Muestra los datos ordenados de menor a mayor
        System.out.print("Recorrido In-Order: ");
        arbol.recorridoInOrder();

        // Recorrido Pre-Order
        // Primero muestra la raíz
        System.out.print("Recorrido Pre-Order: ");
        arbol.recorridoPreOrder();

        // Recorrido Post-Order
        // Primero muestra las hojas y al final la raíz
        System.out.print("Recorrido Post-Order: ");
        arbol.recorridoPostOrder();

        // =====================================================
        // BUSQUEDA DE ELEMENTOS
        // =====================================================

        System.out.println("\n=== BUSQUEDA DE VALORES ===");

        // Buscar un valor existente
        int valorBuscar1 = 40;

        if (arbol.buscar(valorBuscar1)) {
            System.out.println("El valor " + valorBuscar1 + " SI existe en el arbol.");
        } else {
            System.out.println("El valor " + valorBuscar1 + " NO existe en el arbol.");
        }

        // Buscar un valor inexistente
        int valorBuscar2 = 110;

        if (arbol.buscar(valorBuscar2)) {
            System.out.println("El valor " + valorBuscar2 + " SI existe en el arbol.");
        } else {
            System.out.println("El valor " + valorBuscar2 + " NO existe en el arbol.");
        }

        // =====================================================
        // ELIMINACION DE NODOS
        // =====================================================

        System.out.println("\n=== ELIMINACION DE NODOS ===");

        // -----------------------------------------------------
        // CASO 1: Eliminar nodo sin hijos
        // -----------------------------------------------------

        System.out.println("\nEliminando nodo 20 (sin hijos)");
        arbol.eliminar(20);

        System.out.print("Recorrido In-Order: ");
        arbol.recorridoInOrder();

        // -----------------------------------------------------
        // CASO 2: Eliminar nodo con un hijo
        // -----------------------------------------------------

        System.out.println("\nEliminando nodo 30 (con un hijo)");
        arbol.eliminar(30);

        System.out.print("Recorrido In-Order: ");
        arbol.recorridoInOrder();

        // -----------------------------------------------------
        // CASO 3: Eliminar nodo con dos hijos
        // -----------------------------------------------------

        System.out.println("\nEliminando nodo 50 (con dos hijos)");
        arbol.eliminar(50);

        System.out.print("Recorrido In-Order: ");
        arbol.recorridoInOrder();

        // =====================================================
        // FINALIZACION DEL PROGRAMA
        // =====================================================

        System.out.println("\n=== PROGRAMA FINALIZADO ===");
    }
}