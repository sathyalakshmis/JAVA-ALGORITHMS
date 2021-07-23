import java.util.Random;
import java.util.Scanner;
class Quicksort {
    static int[] a;
    static void quickSort(int a[],int low, int high) {
        if (low < high) {
            int j = partition(a,low, high);
            quickSort(a,low, j - 1);
            quickSort(a,j + 1, high);
        }
    }
    static int partition(int a[],int low, int high) {
        int pivot = a[low];
        int i = low+1, j = high;
        while (i < j) {
            while (i < high && a[i] <= pivot) {
                i = i + 1;
            }
            while (j > low && a[j] >= pivot) {
                j = j - 1;
            }
            if (i < j) {
                swap(a,i, j);
            }
        }
        a[low] = a[j];
        a[j] = pivot;
        return j;
    }
    static void swap(int a[],int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        n = scanner.nextInt();
        a = new int[n];
        System.out.println("Quick Sort");
        System.out.println("1. Best/Average Case");
        System.out.println("2. Worst Case");
        int ch = scanner.nextInt();
        switch (ch) {
        case 1:
            Random random = new Random(3000);
            for (int i = 0; i < n; i++) {
                a[i] = random.nextInt();
            }
            break;
        case 2:
            for (int i = 0; i < n; i++) {
                a[i] = i + 1;
            }
            break;
        }
        long start = System.nanoTime();
        quickSort(a,0, n - 1);
        long end = System.nanoTime();
        System.out.println("Sorted Array");
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
        System.out.println("Time taken: " + (end - start));
    }
}
