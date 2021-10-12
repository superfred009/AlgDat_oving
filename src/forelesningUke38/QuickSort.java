package forelesningUke38;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {8, 5, 3, 6, 5, 2, 9};
        System.out.println("Usortert "+Arrays.toString(a));
        quicksort(a, 0, a.length-1);
        System.out.println("Sortert "+Arrays.toString(a));
    }

    static void quicksort(int[] values, int left, int right) {
        // basistilfelle - hvis vi ikke har noe intervall
        // (left == right) så slutter vi rekursjon.
        if (left >= right){
            System.out.println("Slutter rekursjon");
            return;
        }

        // 1. byttt midterste verdi i arrayet til slutten - dette er pivot
        int middle = (left + right) / 2;
        int pivot = values[middle];
        swap(values, middle, right);
        System.out.println("Pivot er indeks "+middle+" verdi "+pivot);

        // 2. partisjoner arrayet fra start til "nest siste kort"
        //      - flytt alt som er større eller lik skilleverdi til høyre
        //      - flytt alt som er mindre enn skilleverdi til vnestre
        //      - ta vare på indexen til siste verdien som er mindre enn skilleverdi
        int index = partition(values, pivot, left, right-1);

        // 3. Flytt skilleverdi tilbake til riktig sortert plass
        int sorted_index = index+1;
        int tmp = values[sorted_index];
        values[sorted_index] = values[right];
        values[right] = tmp;
        System.out.println("Flytter pivot tilbake til indeks "+sorted_index);

        // 4. gjenta for høyre sub-array og venstre sub-array
        System.out.println("Rekursjon venstre sub-array");
        quicksort(values, left, sorted_index-1);
        System.out.println("Rekursjon høyre sub-array");
        quicksort(values, sorted_index+1, right);
    }

    /**
     * Partisjonerer arrrayet basert på en skilleverdi
     * vi plasserer alle verdier som er mindre enn pivot til venstre
     * og alle verdier som er større eller lik til høyre
     * vi returnerer til slutt indeksen til venstre peker
     * @param values
     * @param pivot
     * @param left
     * @param right
     * @return
     */

    static int partition(int[] values, int pivot, int left, int right) {
        int l = left;
        int r = right;

        while (l < r) {
            while (l <= r && values[l] < pivot) {
                l++;
            }
            while (l <= r && values[r] >= pivot) {
                r--;
            }
            if (l < r) {
                System.out.println("Bytter om "+l+" - "+r);
                swap(values, r, l);
                l++;
                r--;
            }
        }

        return l-1;
    }


    static void swap(int[] a, int b, int c) {
        int tmp = a[b];
        a[b] = a[c];
        a[c] = tmp;
    }
}
