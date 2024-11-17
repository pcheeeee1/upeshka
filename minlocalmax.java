import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {6, 5, 4},
                {7, 8, 9}
        };

        Integer minLocalMax = findMinLocalMax(matrix);

        if (minLocalMax != null) {
            System.out.println("Наименьший локальный максимум: " + minLocalMax);
        } else {
            System.out.println("Локальные максимумы не найдены.");
        }
    }

    public static Integer findMinLocalMax(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> localMaxima = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isLocalMaximum(matrix, i, j)) {
                    localMaxima.add(matrix[i][j]);
                }
            }
        }

        return localMaxima.isEmpty() ? null : Collections.min(localMaxima);
    }

    private static boolean isLocalMaximum(int[][] matrix, int row, int col) {
        int value = matrix[row][col];
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Проверяем соседей
        for (int i = Math.max(0, row - 1); i <= Math.min(rows - 1, row + 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(cols - 1, col + 1); j++) {
                if (i == row && j == col) continue;
                if (matrix[i][j] >= value) return false;
            }
        }

        return true;
    }
}
