package dsa.Array;

public class SubArray{

    public static void subArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
			int ts = 0;
			for (int j = i; j < arr.length; j++) {
				ts += arr[j];
				for (int k = i; k <= j; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
			System.out.print("Sum = " + ts);
			System.out.println();
		}
    }

    public static void maxSubArrayPrefixSum(int arr[]) {
		int maxSum = Integer.MIN_VALUE;
		int prefix[] = new int[arr.length];
		prefix[0] = arr[0];
		for(int i = 1; i < prefix.length; i++){
		    prefix[i] = prefix[i-1] + arr[i];
		}
        for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
                int cs = i == 0 ? prefix[j] : prefix[j]-prefix[i-1]; 
                
                if (cs > maxSum) {
					maxSum = cs; 
				}
			}
		}
        System.out.println("Max Subarray Sum = " + maxSum);
	}

    public static void kadanes(int arr[]){
	    int ms = Integer.MIN_VALUE;
	    int cs = 0;
	    for (int i = 0;i < arr.length;i++ ){
	        cs = cs + arr[i];
	        if(cs < 0){
	            cs = 0;
	        }
	        ms = Math.max(cs,ms);
	    } 
	    System.out.println("Max kadanes subArray : "+ms);
	}

    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,7,8};
		int karr[] = {-2,-3, 4,-1,-2,1,5,-3};
		subArray(arr);
		maxSubArrayPrefixSum(arr);
		kadanes(karr);
	}

}