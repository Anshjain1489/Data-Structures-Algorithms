package dsa.Array;

public class PairArray {

    public static void pairArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int p = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + p + "," + arr[j] + ") ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        pairArray(arr);
    }
}