package Array;

public class RotateArray{
    public static void reverseArray(int[] arr,int start,int end) {
        while (start<end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void rotateArray(int[]arr,int k){
        k = k%arr.length;
        reverseArray(arr,0, arr.length-1);
        reverseArray(arr, 0, k-1);
        reverseArray(arr, k, arr.length-1);
    }
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,7};
        rotateArray(arr, 3);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}