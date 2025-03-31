package structures;

/**
 * Clase para una lista enlazada doble.
 * Se utiliza para manejar colisiones en la tabla hash.
 * @param <K> Tipo de la clave.
 * @param <V> Tipo del valor.
 */
class LinkedList<K, V> {
    private Node<K, V> head; // Referencia al primer nodo

    /**
     * Agrega un nodo al final de la lista.
     * @param key Clave del nodo.
     * @param value Valor del nodo.
     */
    public void add(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        if (head == null) {
            head = newNode;
        } else {
            Node<K, V> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    /**
     * Busca un nodo por su clave y devuelve su valor.
     * @param key Clave del nodo.
     * @return Valor del nodo si se encuentra, de lo contrario null.
     */
    public V get(K key) {
        Node<K, V> temp = head;
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * Elimina un nodo basado en su clave.
     * @param key Clave del nodo a eliminar.
     */
    public void remove(K key) {
        Node<K, V> temp = head;
        while (temp != null) {
            if (temp.key.equals(key)) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next;
                }
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    }
}