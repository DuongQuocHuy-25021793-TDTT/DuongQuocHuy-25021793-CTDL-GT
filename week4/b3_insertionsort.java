package week4;



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class b3_insertionsort {


    public static void insertionSort1(int n, List<Integer> arr) {
        int target = arr.get(n - 1);
        int i = n - 2;


        while (i >= 0 && arr.get(i) > target) {
            arr.set(i + 1, arr.get(i));
            printArray(arr);
            i--;
        }



        arr.set(i + 1, target);
        printArray(arr);
    }
    private static void printArray(List<Integer> arr) {
        for (int j = 0; j < arr.size(); j++) {
            System.out.print(arr.get(j) + (j == arr.size() - 1 ? "" : " "));
        }
        System.out.println();
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        b3_insertionsort.insertionSort1(n, arr);
        scanner.close();
    }
}