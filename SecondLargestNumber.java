package dsa.Array;
public class SecondLargestNumber{
    public static void secLargest(int []arr){
        int max = arr[0];
        int secMax = arr[0];
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > max){
                secMax = max;
                max = arr[i];
            }else if(arr[i] > secMax && arr[i] != max){
                secMax = arr[i];
            }
        }
        System.out.println("Max element : "+max);
        System.out.println("Second Max element : "+secMax);
    }

    public static void main(String []args){
        int []arr = {8,4,6,2,10,1,13};
        secLargest(arr);
    }
}