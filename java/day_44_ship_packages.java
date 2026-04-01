public class Day44 {

    static int shipWithinDays(int[] weights, int days) {

        int left = 0, right = 0;

        for (int w : weights) {
            left = Math.max(left, w); // min capacity
            right += w;               // max capacity
        }

        int ans = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int requiredDays = 1;
            int currentLoad = 0;

            for (int w : weights) {

                if (currentLoad + w > mid) {
                    requiredDays++;
                    currentLoad = 0;
                }

                currentLoad += w;
            }

            if (requiredDays <= days) {
                ans = mid;
                right = mid - 1; // try smaller capacity
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println(shipWithinDays(weights, days));
    }
}
