package array;

import base.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 54. Spiral Matrix
 */
public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return Collections.emptyList();
		}

		List<Integer> resultList = new ArrayList<>();
		int row = 0, line = 0;
		int minRow = 0;
		int minLine = 0;
		int maxRow = matrix.length - 1;
		int maxLine = matrix[0].length - 1;
		while (minRow < maxRow && minLine < maxLine) {
			while (line <= maxLine) {
				resultList.add(matrix[row][line]);
				line++;
			}
			minRow++;
			line--;
			row++;
			while (row <= maxRow) {
				resultList.add(matrix[row][line]);
				row++;
			}

			maxLine--;
			row--;
			line--;
			while (line >= minLine) {
				resultList.add(matrix[row][line]);
				line--;
			}

			maxRow--;
			line++;
			row--;
			while (row >= minRow) {
				resultList.add(matrix[row][line]);
				row--;
			}

			minLine++;
			row++;
			line++;
		}

		row = minRow;
		line = minLine;
		if (minLine == maxLine) {
			while (row <= maxRow) {
				resultList.add(matrix[row][line]);
				row++;
			}
		} else if (minRow == maxRow) {
			while (line <= maxLine) {
				resultList.add(matrix[row][line]);
				line++;
			}
		}

		return resultList;
	}

	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2, 3},
				{8, 9, 4},
				{7, 6, 5}
		};

		Lists.printList(spiralOrder(matrix));
	}
}
