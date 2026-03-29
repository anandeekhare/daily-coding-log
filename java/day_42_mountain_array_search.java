// Combine peak finding and binary search for bitonic array
public class Day42 {

    static int findPeak(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static int binarySearch(int[] arr, int target, int left, int right, boolean asc) {

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;

            if (asc) {
                if (arr[mid] < target) left = mid + 1;
                else right = mid - 1;
            } else {
                if (arr[mid] > target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    static int search(int[] arr, int target) {

        int peak = findPeak(arr);

        int left = binarySearch(arr, target, 0, peak, true);
        if (left != -1) return left;

        return binarySearch(arr, target, peak + 1, arr.length - 1, false);
    }

    public static void main(String[] args) {

        int[] arr = {1,3,5,7,6,4,2};
        int target = 6;

        System.out.println(search(arr, target));
    }
}
