public class ArbolBinarioBusqueda {

    // Nodo raíz del árbol
    Nodo raiz;

    // =====================================================
    // METODO INSERTAR
    // =====================================================

    /**
     * Método público para insertar un valor en el árbol
     * @param dato valor a insertar
     */
    public void insertar(int dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    /**
     * Método recursivo que inserta el nodo en la posición correcta
     * siguiendo las reglas del Árbol Binario de Búsqueda
     */
    private Nodo insertarRecursivo(Nodo raiz, int dato) {

        // Si el árbol está vacío, crear nuevo nodo
        if (raiz == null) {
            raiz = new Nodo(dato);
            return raiz;
        }

        // Si el dato es menor, insertar a la izquierda
        if (dato < raiz.dato) {
            raiz.izquierdo = insertarRecursivo(raiz.izquierdo, dato);
        }

        // Si el dato es mayor, insertar a la derecha
        else if (dato > raiz.dato) {
            raiz.derecho = insertarRecursivo(raiz.derecho, dato);
        }

        // Retornar la raíz actualizada
        return raiz;
    }

    // =====================================================
    // METODO BUSCAR
    // =====================================================

    /**
     * Método público para buscar un valor en el árbol
     * @param dato valor a buscar
     * @return true si existe, false si no existe
     */
    public boolean buscar(int dato) {
        return buscarRecursivo(raiz, dato);
    }

    /**
     * Método recursivo para buscar un nodo
     */
    private boolean buscarRecursivo(Nodo raiz, int dato) {

        // Si llegamos a un nodo vacío, el dato no existe
        if (raiz == null) {
            return false;
        }

        // Si encontramos el dato
        if (raiz.dato == dato) {
            return true;
        }

        // Buscar en el subárbol izquierdo
        if (dato < raiz.dato) {
            return buscarRecursivo(raiz.izquierdo, dato);
        }

        // Buscar en el subárbol derecho
        return buscarRecursivo(raiz.derecho, dato);
    }

    // =====================================================
    // METODO ELIMINAR
    // =====================================================

    /**
     * Método público para eliminar un valor del árbol
     * @param dato valor a eliminar
     */
    public void eliminar(int dato) {
        raiz = eliminarRecursivo(raiz, dato);
    }

    /**
     * Método recursivo para eliminar nodos
     * Contempla los tres casos:
     * 1. Nodo sin hijos
     * 2. Nodo con un hijo
     * 3. Nodo con dos hijos
     */
    private Nodo eliminarRecursivo(Nodo raiz, int dato) {

        // Si el árbol está vacío
        if (raiz == null) {
            return null;
        }

        // Buscar el nodo a eliminar
        if (dato < raiz.dato) {
            raiz.izquierdo = eliminarRecursivo(raiz.izquierdo, dato);
        }

        else if (dato > raiz.dato) {
            raiz.derecho = eliminarRecursivo(raiz.derecho, dato);
        }

        // Nodo encontrado
        else {

            // =================================================
            // CASO 1: Nodo sin hijos
            // =================================================
            if (raiz.izquierdo == null && raiz.derecho == null) {
                return null;
            }

            // =================================================
            // CASO 2: Nodo con un solo hijo
            // =================================================

            // Solo tiene hijo derecho
            else if (raiz.izquierdo == null) {
                return raiz.derecho;
            }

            // Solo tiene hijo izquierdo
            else if (raiz.derecho == null) {
                return raiz.izquierdo;
            }

            // =================================================
            // CASO 3: Nodo con dos hijos
            // =================================================

            // Buscar el menor valor del subárbol derecho
            int sucesor = obtenerValorMinimo(raiz.derecho);

            // Reemplazar el valor del nodo actual
            raiz.dato = sucesor;

            // Eliminar el nodo duplicado
            raiz.derecho = eliminarRecursivo(raiz.derecho, sucesor);
        }

        return raiz;
    }

    // =====================================================
    // OBTENER VALOR MINIMO
    // =====================================================

    /**
     * Obtiene el valor más pequeño del subárbol
     * @param raiz nodo raíz del subárbol
     * @return valor mínimo encontrado
     */
    private int obtenerValorMinimo(Nodo raiz) {

        int minimo = raiz.dato;

        // Recorrer hacia la izquierda hasta encontrar el menor
        while (raiz.izquierdo != null) {
            minimo = raiz.izquierdo.dato;
            raiz = raiz.izquierdo;
        }

        return minimo;
    }

    // =====================================================
    // RECORRIDO IN-ORDER
    // =====================================================

    /**
     * Recorre el árbol en In-Order
     * Izquierda -> Raíz -> Derecha
     */
    public void recorridoInOrder() {
        recorridoInOrderRecursivo(raiz);
        System.out.println();
    }

    private void recorridoInOrderRecursivo(Nodo raiz) {

        if (raiz != null) {

            recorridoInOrderRecursivo(raiz.izquierdo);

            System.out.print(raiz.dato + " ");

            recorridoInOrderRecursivo(raiz.derecho);
        }
    }

    // =====================================================
    // RECORRIDO PRE-ORDER
    // =====================================================

    /**
     * Recorre el árbol en Pre-Order
     * Raíz -> Izquierda -> Derecha
     */
    public void recorridoPreOrder() {
        recorridoPreOrderRecursivo(raiz);
        System.out.println();
    }

    private void recorridoPreOrderRecursivo(Nodo raiz) {

        if (raiz != null) {

            System.out.print(raiz.dato + " ");

            recorridoPreOrderRecursivo(raiz.izquierdo);

            recorridoPreOrderRecursivo(raiz.derecho);
        }
    }

    // =====================================================
    // RECORRIDO POST-ORDER
    // =====================================================

    /**
     * Recorre el árbol en Post-Order
     * Izquierda -> Derecha -> Raíz
     */
    public void recorridoPostOrder() {
        recorridoPostOrderRecursivo(raiz);
        System.out.println();
    }

    private void recorridoPostOrderRecursivo(Nodo raiz) {

        if (raiz != null) {

            recorridoPostOrderRecursivo(raiz.izquierdo);

            recorridoPostOrderRecursivo(raiz.derecho);

            System.out.print(raiz.dato + " ");
        }
    }
}