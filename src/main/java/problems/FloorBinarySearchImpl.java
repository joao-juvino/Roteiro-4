package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if (array == null || array.length == 0 || this.containsNull(array))
			return null;

		this.quickSortMedianOfThree(array, 0, array.length - 1);
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

	/**
	 * Implementação do quickSort mediana de três
	 * 
	 * @param array      o array a ser ordenado
	 * @param leftIndex  o index que delimita a partição do array à esquerda
	 * @param rightIndex o index que delimita a partição do array à direita
	 */
	public void quickSortMedianOfThree(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			// Cálculo da mediana e ordenação dos valores: central e extremos do array
			int middle = leftIndex + (rightIndex - leftIndex) / 2;

			if (array[leftIndex].compareTo(array[middle]) > 0)
				Util.swap(array, leftIndex, middle);
			if (array[rightIndex].compareTo(array[middle]) < 0)
				Util.swap(array, rightIndex, middle);
			if (array[leftIndex].compareTo(array[middle]) > 0)
				Util.swap(array, leftIndex, middle);

			// Colocação estratégica do valor central
			Util.swap(array, middle, rightIndex - 1);

			// Algoritmo recursivo do quickSelection
			int pivot = partition(array, leftIndex, rightIndex);

			quickSortMedianOfThree(array, leftIndex, pivot - 1);
			quickSortMedianOfThree(array, pivot + 1, rightIndex);
		}
	}

	/**
	 * Implementação do particionamento do array
	 * 
	 * @param array      o array de dados a procurar o k-esimo menor elemento este
	 *                   array
	 *                   normalmente nao esta ordenado
	 * @param leftIndex  o index que delimita a partição do array à esquerda
	 * @param rightIndex o index que delimita a partição do array à direita
	 * 
	 * @return pivot A posição ordenada do pivot
	 */
	private int partition(Integer[] array, int left, int right) {
		Integer pivot = array[left];

		int i = left;
		for (int j = left + 1; j <= right; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, left, i);

		return i;
	}

	/**
	 * Método que verifica se um array contém um elemento com valor null
	 * 
	 * @param array, o array a ser verficado
	 * @return true/false, boolean que indica se o array contém ou não o elemento
	 *         null
	 */
	private boolean containsNull(Integer[] array) {
		for (int i = 0; i < array.length; i++)
			if (array[i] == null)
				return true;
		return false;
	}

}
