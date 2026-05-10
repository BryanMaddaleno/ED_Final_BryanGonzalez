public class Nodo {

    // Valor almacenado en el nodo
    int dato;

    // Referencias a los hijos izquierdo y derecho
    Nodo izquierdo;
    Nodo derecho;

    /**
     * Constructor del nodo
     * @param dato valor que almacenará el nodo
     */
    public Nodo(int dato) {
        this.dato = dato;
        izquierdo = null;
        derecho = null;
    }
}