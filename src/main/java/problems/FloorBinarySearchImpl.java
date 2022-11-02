package problems;

import java.util.Arrays;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if(array == null || array.length == 0) return null;

		Arrays.sort(array);
		return floorBinarySearch(array, x, 0, array.length - 1);
	}

	private Integer floorBinarySearch(Integer[] array, Integer value, int leftIndex, int rightIndex) {
		int middle = (leftIndex + rightIndex) / 2;

		// Caso base da recursão
		if (leftIndex > rightIndex) {
			if (rightIndex == -1) return null;
			// O elemento em rightIndex é o valor mais próximo do valor buscado
			return array[rightIndex];
		}
		
		// O valor buscado faz parte do array
		if (array[middle] == value)
			return array[middle];

		// Busca recursiva que particiona o array pelos índices
		if (array[middle] > value)
			return floorBinarySearch(array, value, leftIndex, middle - 1);
		else
			return floorBinarySearch(array, value, middle + 1, rightIndex);
	}

}
