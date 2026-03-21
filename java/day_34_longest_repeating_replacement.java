// Sliding window with frequency array to allow k replacements
public class Day34 {

    static int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int left = 0, maxCount = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            freq[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        System.out.println(characterReplacement(s, k));
    }
}
