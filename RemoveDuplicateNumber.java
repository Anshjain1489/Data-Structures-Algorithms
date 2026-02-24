package dsa.Array;

public class RemoveDuplicateNumber {

    public static int removeDuplicate(int arr[]){
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[idx]!=arr[i]) {
                arr[idx+1] = arr[i];
                idx++;
            }
        }
        return idx+1;
    }
    public static void main(String[] args) {
        int arr[] = {0,0,1,1,1,2,2,3,3,3,4,4,5};
        int newLengthArray = removeDuplicate(arr);
        for (int i = 0; i < newLengthArray; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}