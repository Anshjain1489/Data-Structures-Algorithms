package dsa.Array;

public class BinarySearch {

    public static int search(int arr[], int tar) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == tar) {
                return mid;
            } 
            else if (arr[mid] < tar) {
                start = mid + 1; // search right 
            } 
            else {
                end = mid - 1; // search left 
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int target = 3;

        int result = search(arr, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
