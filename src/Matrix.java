import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 Matrix
 *
 */
public class Matrix {
    /**
     * bfs 广度优先遍历
     *
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }

                matrix[i][j] = bfs(matrix, i, j, m - 1, n - 1);
            }
        }

        return matrix;
    }

    private int bfs(int[][] matrix, int row, int line, int maxRow, int maxLine) {
        int result = 0;

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(row, line));
        HashSet<Pos> set = new HashSet<>();

        int i, j;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Pos pos = queue.poll();
                i = pos.i;
                j = pos.j;
                if (i > 0) {
                    Pos next = new Pos(i - 1, j);
                    if (matrix[i - 1][j] == 0) {
                        result++;
                        return result;
                    } else if (!set.contains(next)) {
                        queue.add(next);
                        set.add(next);
                    }
                }

                if (i < maxRow) {
                    Pos next = new Pos(i + 1, j);
                    if (matrix[i + 1][j] == 0) {
                        result++;
                        return result;
                    } else if (!set.contains(next)) {
                        queue.add(next);
                        set.add(next);
                    }
                }

                if (j > 0) {
                    Pos next = new Pos(i, j - 1);
                    if (matrix[i][j - 1] == 0) {
                        result++;
                        return result;
                    } else if (!set.contains(next)) {
                        queue.add(next);
                        set.add(next);
                    }
                }

                if (j < maxLine) {
                    Pos next = new Pos(i, j + 1);
                    if (matrix[i][j + 1] == 0) {
                        result++;
                        return result;
                    } else if (!set.contains(next)) {
                        queue.add(next);
                        set.add(next);
                    }
                }
            }
            result++;
        }
        return 0;
    }

    class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
        };

        matrix = new Matrix().updateMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
