// Binary search variation to find first and last index
public class Day37 {

    static int firstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ans = mid;
                right = mid - 1; // move left
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    static int lastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ans = mid;
                left = mid + 1; // move right
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,2,2,3,4,5};
        int target = 2;

        System.out.println(firstOccurrence(arr, target));
        System.out.println(lastOccurrence(arr, target));
    }
}
