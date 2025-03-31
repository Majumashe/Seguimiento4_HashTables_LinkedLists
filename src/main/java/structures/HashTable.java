package structures;

/**
 * Implementación de una Tabla Hash.
 * Usa una lista enlazada doble en cada índice para manejar colisiones.
 * @param <K> Tipo de la clave.
 * @param <V> Tipo del valor.
 */
public class HashTable<K, V> {
    private int capacity;  // Tamaño de la tabla
    private LinkedList<K, V>[] table;  // Arreglo de listas enlazadas

    /**
     * Constructor de la Tabla Hash.
     * @param capacity Tamaño inicial de la tabla.
     */
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    /**
     * Genera un índice para una clave usando una función hash personalizada.
     * @param key Clave a hashear.
     * @return Índice en la tabla hash.
     */
    private int customHash(K key) {
        int hash = 0;
        String keyString = key.toString();
        for (int i = 0; i < keyString.length(); i++) {

            // se usa ese valor para hash porque es un tipo de standar
            // https://stackoverflow.com/questions/299304/why-does-javas-hashcode-in-string-use-31-as-a-multiplier
            hash = (hash * 31 + keyString.charAt(i)) % capacity;
        }
        return Math.abs(hash);
    }

    /**
     * Inserta un par clave-valor en la tabla hash.
     * @param key Clave.
     * @param value Valor asociado a la clave.
     */
    public void put(K key, V value) {
        int index = customHash(key);
        table[index].add(key, value);
    }

    /**
     * Obtiene el valor asociado a una clave.
     * @param key Clave a buscar.
     * @return Valor correspondiente a la clave, o null si no existe.
     */
    public V get(K key) {
        int index = customHash(key);
        return table[index].get(key);
    }

    /**
     * Elimina un par clave-valor de la tabla hash.
     * @param key Clave a eliminar.
     */
    public void remove(K key) {
        int index = customHash(key);
        table[index].remove(key);
    }
}

