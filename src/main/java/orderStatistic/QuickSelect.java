package orderStatistic;

import util.Util;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 *
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 *
 * @author adalberto e campelo
 *
 */
public class QuickSelect<T extends Comparable<T>> {

	/**
	 * O algoritmo quickselect usa a mesma abordagem do quicksort para calcular o
	 * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado array
	 * de dados comparaveis. Primeiro ele escolhe um elemento como o pivot e
	 * particiona os dados em duas partes, baseando-se no pivot (exatemente da mesma
	 * forma que o quicksort). Depois disso, ele chama recursivamente o mesmo
	 * algoritmo em apenas uma das metades (a que contem o k-esimo menor elemento).
	 * Isso reduz a complexidade de O(n.log n) para O(n).
	 *
	 * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja fora
	 * do tamanho do array, o metodo deve retornar null.
	 *
	 *
	 * @param array o array de dados a procurar o k-esimo menor elemento este array
	 *              normalmente nao esta ordenado
	 * @param k     a ordem do elemento desejado. 1 significa primeiro menor
	 *              elemento, 2 significa segundo menor elemento e assim por diante
	 * @return T o k-esimo menor valor do array
	 *
	 */
	public T quickSelect(T[] array, int k) {
		if (array.length == 0 || k > array.length || array == null || k <= 0)
			return null;

		return this.quickSelectMedianOfThree(array, k, 0, array.length - 1);
	}

	/**
	 * Implementação do quickSelect mediana de três
	 * 
	 * @param array      o array de dados a procurar o k-esimo menor elemento este
	 *                   array
	 *                   normalmente nao esta ordenado
	 * @param k          a ordem do elemento desejado. 1 significa primeiro menor
	 *                   elemento, 2 significa segundo menor elemento e assim por
	 *                   diante
	 * @param leftIndex  o index que delimita a partição do array à esquerda
	 * @param rightIndex o index que delimita a partição do array à direita
	 * 
	 * @return T o k-esimo menor valor do array
	 */
	private T quickSelectMedianOfThree(T[] array, int k, int leftIndex, int rightIndex) {
		// Cálculo da mediana e ordenação dos valores: central e extremos do array
		int middle = (rightIndex + leftIndex) / 2;

		if (array[leftIndex].compareTo(array[middle]) > 0)
			Util.swap(array, leftIndex, middle);
		if (array[rightIndex].compareTo(array[middle]) < 0)
			Util.swap(array, rightIndex, middle);
		if (array[leftIndex].compareTo(array[middle]) > 0)
			Util.swap(array, leftIndex, middle);

		// Colocação estratégica do valor central
		if (middle < rightIndex)
			Util.swap(array, middle, rightIndex - 1);

		// Algoritmo recursivo do quickSelection
		int pivot = this.partition(array, leftIndex, rightIndex);

		if (pivot + 1 > k)
			return this.quickSelectMedianOfThree(array, k, leftIndex, pivot - 1);
		else if (pivot + 1 < k)
			return this.quickSelectMedianOfThree(array, k, pivot + 1, rightIndex);
		else
			return array[pivot]; // Caso base
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
	 * @return i A posição ordenada do pivot
	 */
	private int partition(T[] array, int left, int right) {
		T pivot = array[left];

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

}