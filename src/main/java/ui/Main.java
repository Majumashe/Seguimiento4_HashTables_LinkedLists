package ui;
import model.SumSubArr;
import structures.HashTable;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Subarreglo con suma objetivo");
        System.out.println("------------------------");

        // Get array input
        System.out.print("Ingrese el tamaño del arreglo: ");
        int size = scanner.nextInt();
        Integer[] arr = new Integer[size];

        System.out.println("Ingrese los elementos del arreglo (enteros):");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Get target sum
        System.out.print("Ingrese la suma objetivo (S): ");
        int targetSum = scanner.nextInt();

        // Find subarray
        System.out.println("\nProcesando...");
        findSubarray(arr, targetSum);

        scanner.close();
    }

    public static void findSubarray(Integer[] arr, int s) {

        int[] currentSum = SumSubArr.findSubarrayWithSum(arr, s);



            // Case 1: Subarray starts at index 0
        if (currentSum.length == 1 && currentSum[0] == -1) {
            System.out.println("-1");
            System.out.println("\nNo se encontró un subarreglo con suma " + s);
        } else {
            System.out.println("Subarreglo encontrado en los indices: ");
            System.out.println("(" + currentSum[0] + ": " + currentSum[1] + ")");
        }

    }
}