public class Day43 {

    static int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        for (int p : piles) {
            right = Math.max(right, p);
        }

        int ans = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int totalHours = 0;

            for (int p : piles) {
                totalHours += (p + mid - 1) / mid; // ceil division
            }

            if (totalHours <= h) {
                ans = mid;
                right = mid - 1; // try smaller speed
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] piles = {3,6,7,11};
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));
    }
}
