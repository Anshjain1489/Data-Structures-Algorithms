package dsa.Array;

public class TrappingRainwater {
    public static int trappedWater(int height[]) {
        int n = height.length;

        int leftmax[] = new int[n];
        leftmax[0] = height[0];

        for (int i = 1; i < n; i++) {
            if (height[i] > leftmax[i - 1]) {
                leftmax[i] = height[i];
            } else {
                leftmax[i] = leftmax[i - 1];
            }
        }

        int rightmax[] = new int[n];
        rightmax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (height[i] > rightmax[i + 1]) {
                rightmax[i] = height[i];
            } else {
                rightmax[i] = rightmax[i + 1];
            }
        }

        int trappedwater = 0;

        for (int i = 0; i < n; i++) {
            int waterlevel;
            if (leftmax[i] < rightmax[i]) {
                waterlevel = leftmax[i];
            } else {
                waterlevel = rightmax[i];
            }

            trappedwater += waterlevel - height[i];
        }

        return trappedwater;
    }

    public static void main(String[] args) {
        int height[] = {4, 2, 0, 6, 3, 2, 5};
        System.out.println(trappedWater(height));  
    }
}
