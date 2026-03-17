public class Day30 {

    static void moveZeroes(int[] nums) {

        int j = 0; // place for non-zero

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {0,1,0,3,12};

        moveZeroes(nums);

        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
