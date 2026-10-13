package week5;
import java.io.*;
import java.util.*;

class Solution2 {
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + (i == a.length - 1 ? "" : " "));
        }
        System.out.println();
    }
    public  static int  partition (int a[] , int l , int r){
        int pivot = a[r];
        int i = l-1;
        for (int j = l; j < r; j++){
            if(a[j] <= pivot){
                i++;
                swap(a,i,j);

            }

        }
        i++;
        swap(a,i,r);
        printArray(a);
        return i;

    }
    public static void quicksort(int a[] , int l, int r){
        if(l >= r) return ;
        int p = partition(a, l, r);
        quicksort(a, l, p-1);
        quicksort(a, p+1, r);
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            quicksort(a, 0, n - 1);
        }
        sc.close();
    }
}