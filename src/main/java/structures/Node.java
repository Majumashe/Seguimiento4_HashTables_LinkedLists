package structures;

// Implementación de una Tabla Hash con Listas Enlazadas Dobles Propias

/**
 * Clase Nodo para nuestra lista enlazada doble.
 * Representa un elemento con clave y valor.
 * @param <K> Tipo de la clave.
 * @param <V> Tipo del valor.
 */
class Node<K, V> {
    K key;  // Clave del nodo
    V value;  // Valor almacenado en el nodo
    Node<K, V> next;  // Apunta al siguiente nodo
    Node<K, V> prev;  // Apunta al nodo anterior

    /**
     * Constructor de un nodo con clave y valor.
     * @param key Clave del nodo.
     * @param value Valor del nodo.
     */
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

}
