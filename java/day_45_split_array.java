// Binary search to minimize maximum subarray sum
public class Day45 {

    static int splitArray(int[] nums, int k) {

        int left = 0, right = 0;

        for (int n : nums) {
            left = Math.max(left, n); // minimum largest sum
            right += n;               // maximum possible sum
        }

        int ans = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int subarrays = 1;
            int currentSum = 0;

            for (int n : nums) {

                if (currentSum + n > mid) {
                    subarrays++;
                    currentSum = 0;
                }

                currentSum += n;
            }

            if (subarrays <= k) {
                ans = mid;
                right = mid - 1; // try smaller max sum
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {7,2,5,10,8};
        int k = 2;

        System.out.println(splitArray(nums, k));
    }
}
