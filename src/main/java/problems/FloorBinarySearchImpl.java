package problems;

import java.util.Arrays;

public class FloorBinarySearchImpl implements Floor {
	
	@Override
	public Integer floor(Integer[] array, Integer x) {
		if (array == null || array.length == 0 || this.containsNull(array))
			return null;

		this.mergeSort(array, 0, array.length - 1);
		return this.floorBinarySearch(array, x, 0, array.length - 1);
	}

	private Integer floorBinarySearch(Integer[] array, Integer value, int leftIndex, int rightIndex) {
		int middle = (leftIndex + rightIndex) / 2;

		// Caso base da recursão
		if (leftIndex > rightIndex) {
			if (rightIndex == -1)
				return null;
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

	private void mergeSort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int middle = leftIndex + (rightIndex - leftIndex) / 2;

			mergeSort(array, leftIndex, middle);
			mergeSort(array, middle + 1, rightIndex);

			merge(array, leftIndex, rightIndex, middle);
		}
	}

	private void merge(Integer[] array, int leftIndex, int rightIndex, int middle) {

		Integer[] helper = Arrays.copyOf(array, array.length);
		for (int i = leftIndex; i <= rightIndex; i++) {
			helper[i] = array[i];
		}

		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;

		while (i <= middle && j <= rightIndex) {

			if (helper[i].compareTo(helper[j]) <= 0) {
				array[k] = helper[i];
				i++;
			} else {
				array[k] = helper[j];
				j++;
			}
			k++;

		}

		while (i <= middle) {
			array[k] = helper[i];
			i++;
			k++;
		}

		while (j <= rightIndex) {
			array[k] = helper[j];
			j++;
			k++;
		}
	}

	/**
	 * Método que verifica se um array contém um elemento com valor null
	 * 
	 * @param array, o array a ser verficado
	 * @return true/false, boolean que indica se o array contém ou não o elemento null
	 * */
	private boolean containsNull(Integer[] array) {
		for (int i = 0; i < array.length; i++) if (array[i] == null) return true;
		return false;
	}

}
