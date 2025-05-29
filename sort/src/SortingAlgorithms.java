// Clase 3: SortingAlgorithms.java
// Clase genérica para ordenar cualquier tipo de objeto usando comparadores
// Puedes usar esta clase con cualquier tipo de objeto (Producto, Persona, etc.) y definir cómo ordenarlo con un Comparator

import java.util.Comparator;
import java.util.List;

public class SortingAlgorithms {

    /**
     * BUBBLE SORT
     * Recorre la lista varias veces, comparando elementos adyacentes e intercambiándolos si están en el orden incorrecto.
     * Es lento pero fácil de implementar. Ideal para listas pequeñas o demostraciones educativas.
     */
    public static <T> void bubbleSort(List<T> list, Comparator<T> comparator) {
        int n = list.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break; // termina si no hubo intercambios
        }
    }

    /**
     * INSERTION SORT
     * Recorre la lista, tomando un elemento y "insertándolo" en la posición correcta dentro de la parte ya ordenada.
     * Eficiente para listas pequeñas o casi ordenadas.
     */
    public static <T> void insertionSort(List<T> list, Comparator<T> comparator) {
        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    /**
     * SELECTION SORT
     * Encuentra el elemento mínimo y lo coloca en su posición final. Repite esto para cada posición.
     * No es muy eficiente para listas largas.
     */
    public static <T> void selectionSort(List<T> list, Comparator<T> comparator) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(list.get(j), list.get(minIdx)) < 0) {
                    minIdx = j;
                }
            }
            T temp = list.get(minIdx);
            list.set(minIdx, list.get(i));
            list.set(i, temp);
        }
    }

    /**
     * QUICK SORT
     * Algoritmo recursivo que divide la lista en sublistas usando un pivote, ordenando recursivamente las partes.
     * Muy rápido en la práctica, aunque sensible al pivote elegido.
     */
    public static <T> void quickSort(List<T> list, Comparator<T> comparator) {
        quickSortHelper(list, 0, list.size() - 1, comparator);
    }

    private static <T> void quickSortHelper(List<T> list, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pi = partition(list, low, high, comparator);
            quickSortHelper(list, low, pi - 1, comparator);
            quickSortHelper(list, pi + 1, high, comparator);
        }
    }

    private static <T> int partition(List<T> list, int low, int high, Comparator<T> comparator) {
        T pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
                i++;
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        T temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }

    /**
     * MERGE SORT
     * Algoritmo recursivo que divide la lista en mitades, ordena cada mitad y las fusiona.
     * Muy estable y predecible. Ideal para listas grandes.
     */
    public static <T> void mergeSort(List<T> list, Comparator<T> comparator) {
        if (list.size() > 1) {
            int mid = list.size() / 2;
            List<T> left = new java.util.ArrayList<>(list.subList(0, mid));
            List<T> right = new java.util.ArrayList<>(list.subList(mid, list.size()));

            mergeSort(left, comparator);
            mergeSort(right, comparator);
            merge(list, left, right, comparator);
        }
    }

    private static <T> void merge(List<T> list, List<T> left, List<T> right, Comparator<T> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }
}
