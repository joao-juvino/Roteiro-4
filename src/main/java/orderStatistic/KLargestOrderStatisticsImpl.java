package orderStatistic;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. A 3a
 * estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as
 * estatisticas de ordem maiores que k.
 * 
 * Requisitos do algoritmo: - DEVE ser in-place. Porem, voce pode modificar o
 * array original. Voce pode criar ainda um array de tamanho k que vai armazenar
 * apenas os elementos a serem retornados. - Voce DEVE usar alguma ideia de
 * algoritmo de ordenacao visto em sala para calcular estatisticas de ordem. -
 * Se a entrada for invalida, deve-se retornar um array vazio (por exemplo, ao
 * solicitar os 5 maiores elementos em um array que soh contem 3 elementos).
 * Este metodo NUNCA deve retornar null.
 * 
 * @author campelo and adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T> {

	@Override
  public T[] getKLargest(T[] array,  int k) {
    if (array.length == 0 || k > array.length || array == null || k <= 0 || this.containsNull(array))
			return Arrays.copyOf(array, 0);
    
    T[] kLargest = Arrays.copyOf(array, k);
    int kLargestIndex = 0;
    
    for (int i = k; i > 0; i--) {
      kLargest[kLargestIndex++] = orderStatistics(array, i);
    }

    return kLargest;
  }

/**
   * Metodo que retorna a k-esima estatistica de ordem de um array, usando a ideia
   * de algum algoritmo de ordenacao visto em sala. Caso nao exista a k-esima
   * estatistica de ordem, entao retorna null.
   * 
   * Obs: o valor de k deve ser entre 1 e N.
   * 
   * @param array
   * @param k
   * @return
   */
  public T orderStatistics (T[] array,  int k) {
    return this.quickSelectMedianOfThree(array, k, 0, array.length - 1);
  }

  /**
   * Implementação do quickSelect mediana de três
   * 
   * @param array      o array de dados a procurar o k-esimo maior elemento este
   *                   array
   *                   normalmente nao esta ordenado
   * @param k          a ordem do elemento desejado. 1 significa primeiro maior
   *                   elemento, 2 significa segundo maior elemento e assim por
   *                   diante
   * @param leftIndex  o index que delimita a partição do array à esquerda
   * @param rightIndex o index que delimita a partição do array à direita
   * 
   * @return T o k-esimo maior valor do array
   */
  private T quickSelectMedianOfThree ( T[] array,  int k,  int leftIndex,  int rightIndex) {
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
  private int partition ( T[] array,  int left,  int right) {
     T pivot = array[left];

    int i = left;
    for (int j = left + 1; j <= right; j++) {
      if (array[j].compareTo(pivot) >= 0) {
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
	 * @return true/false, boolean que indica se o array contém ou não o elemento null
	 * */
	private boolean containsNull(T[] array) {
		for (int i = 0; i < array.length; i++) if (array[i] == null) return true;
		return false;
	}

}
