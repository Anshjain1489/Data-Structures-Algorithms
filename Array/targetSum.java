package dsa.Array;
public class targetSum {
    public static boolean tsum(int arr[],int tar) {
		int start = 0;
		int end = arr.length-1;
		while(start<end) {
			int sum = arr[start]+arr[end];
			if(sum==tar) {
				System.out.println(arr[start]+"+"+arr[end]+"="+tar);
				return true;
			} else if (sum<tar) {
				start++;
			} else {
				end--;
			}
		}
		return false;
	}

	public static void tsum1(int arr[], int tar) {
		int start = 0, end = arr.length - 1;
        while(start < end) {
			int sum = arr[start] + arr[end];
            if(sum == tar) {
				System.out.println(arr[start] + " + " + arr[end] + " = " + tar);
				start++;
				end--;
			}
			else if(sum < tar) {
				start++;
			}
			else {
				end--;
			}
		}
	}
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9};
		if(tsum(arr,11)) {
			System.out.println("Target sum found ");
		}
		else {
			System.out.println("Target sum not found ");
		}
		tsum1(arr,12);
	}
}
//javac Array\targetSum.java
//java Array.targetSum
