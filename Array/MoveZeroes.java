package dsa.Array;

public class MoveZeroes {
    public static void moveZeroes(int[]arr){
        int j = 0;
        for(int i = 0;i < arr.length; i++){
            if(arr[i]!=0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    public static void main(String []args){
        int []arr = {5,7,0,1,2,3,0};
        moveZeroes(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}
