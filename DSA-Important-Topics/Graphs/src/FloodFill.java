import java.util.*;
public class FloodFill {
    void dfs(int[][] image, int i, int j, int n, int m, int color, int prevColor) {
        if (i < 0 || j < 0 || i >= n || j >= m || image[i][j] == color
                || image[i][j] != prevColor) {
            return;
        }

        image[i][j] = color;

        dfs(image, i - 1, j, n, m, color, prevColor);
        dfs(image, i + 1, j, n, m, color, prevColor);
        dfs(image, i, j - 1, n, m, color, prevColor);
        dfs(image, i, j + 1, n, m, color, prevColor);

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, image.length, image[0].length, color, image[sr][sc]);
        return image;
    }
}
