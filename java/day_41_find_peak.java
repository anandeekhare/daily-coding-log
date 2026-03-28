public class Day41 {

    static int findPeak(int[] nums) {

        int left = 0, right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid; // peak is left side
            } else {
                left = mid + 1; // peak is right side
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,1};

        System.out.println(findPeak(arr));
    }
}
