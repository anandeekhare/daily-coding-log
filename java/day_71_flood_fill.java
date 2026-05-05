public class Day71 {

    static void dfs(int[][] image, int i, int j, int oldColor, int newColor) {

        int n = image.length, m = image[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m || image[i][j] != oldColor)
            return;

        image[i][j] = newColor;

        dfs(image, i+1, j, oldColor, newColor);
        dfs(image, i-1, j, oldColor, newColor);
        dfs(image, i, j+1, oldColor, newColor);
        dfs(image, i, j-1, oldColor, newColor);
    }

    static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldColor = image[sr][sc];

        if (oldColor != color) {
            dfs(image, sr, sc, oldColor, color);
        }

        return image;
    }

    public static void main(String[] args) {

        int[][] image = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };

        floodFill(image, 1, 1, 2);

        for (int[] row : image) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
