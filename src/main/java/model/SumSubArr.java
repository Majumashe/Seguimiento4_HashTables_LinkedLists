package model;


import structures.HashTable;

public class SumSubArr {
    /**
     * Encuentra un subarreglo cuya suma sea S usando una tabla hash.
     * @param arr El arreglo de entrada.
     * @param S La suma objetivo.
     * @return Índices del subarreglo [inicio, fin] o -1 si no se encuentra.
     */
    public static int[] findSubarrayWithSum(Integer[] arr, int S) {
        HashTable<Integer, Integer> hashTable = new HashTable<>(arr.length);
        int sum = 0;

        // Guardamos la suma 0 en caso de que el subarreglo empiece en el índice 0
        hashTable.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Si (sum - S) existe en la tabla, significa que hay un subarreglo con suma S
            Integer startIdx = hashTable.get(sum - S);
            if (startIdx != null) {
                return new int[]{startIdx + 1, i}; // Retornamos los índices del subarreglo encontrado
            }

            // Guardamos la suma actual en la tabla hash con su índice
            hashTable.put(sum, i);
        }

        return new int[]{-1};  // No se encontró un subarreglo con suma S
    }

}
