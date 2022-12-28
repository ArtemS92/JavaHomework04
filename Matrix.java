import java.util.ArrayDeque;

public class Matrix {
    int EMPTY = Integer.MAX_VALUE;
    int[][] STEPS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix(int[][] mat) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    stack.add(new int[]{i, j});
                } else {
                    mat[i][j] = EMPTY;
                }
            }
        }
        while (!stack.isEmpty()) {
            int[] curPoint = stack.poll();
            int curRow = curPoint[0];
            int curCol = curPoint[1];
            for (int[] step : STEPS) {
                int newRow = curRow + step[0];
                int newCol = curCol + step[1];
                if (newRow >= 0 && newRow < mat.length &&
                        newCol >= 0 && newCol < mat.length &&
                        mat[newRow][newCol] == EMPTY) {
                    mat[newRow][newCol] = mat[curRow][curCol] + 1;
                    stack.add(new int[]{newRow, newCol});
                }
            }
        }
        return mat;
    }
}
