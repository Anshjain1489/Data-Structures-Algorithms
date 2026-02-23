package Array;

public class LinearSearch {
    public static boolean search(int arr[] , int tar){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==tar) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4,5};
        if (search(arr,3)) {
            System.out.println("Element found");
        } else {
            System.out.println("Element not found");
        }
    }
}
