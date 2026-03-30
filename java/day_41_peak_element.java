public class Day41 {

    static int findPeak(int[] nums) {

        int left = 0, right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1; // go right
            } else {
                right = mid; // go left including mid
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,1};

        int peakIndex = findPeak(arr);
        System.out.println("Peak at index: " + peakIndex);
    }
}
