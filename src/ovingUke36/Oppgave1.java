package ovingUke36;

import java.util.Arrays;

public class Oppgave1 {
    public static void main(String[] args) {
        Tabell tabell = new Tabell();

        // avsnitt 1.3.1 oppgave 2
        int[] a = {2, 3, 6, 1, 4, 5}; // neste permutasjon: 2 3 6 1 5 4
        tabell.nestePermutasjon(a);
        System.out.println(Arrays.toString(a));
        int[] b = {2, 3, 6, 1, 5, 4}; // neste permutasjon: 2 3 6 4 1 5
        tabell.nestePermutasjon(b);
        System.out.println(Arrays.toString(b));
        int[] c = {2, 3, 1, 6, 5, 4}; // neste permutasjon: 2 3 4 1 5 6
        tabell.nestePermutasjon(c);
        System.out.println(Arrays.toString(c));
        int[] d = {2, 3, 6, 5, 4, 1}; // neste permutasjon: 2 4 1 3 5 6
        tabell.nestePermutasjon(d);
        System.out.println(Arrays.toString(d));
        int[] e = {2, 6, 5, 4, 3, 1}; // neste permutasjon: 3 1 2 4 5 6
        tabell.nestePermutasjon(e);
        System.out.println(Arrays.toString(e));

        // avsnitt 1.3.1 oppgave 3
        System.out.println("Oppgave 3");
        int[] f = {3, 1, 4, 9, 7, 10, 8, 6, 5, 2};
        /** 10 neste permutasjoner til f:
         * 3 1 4 9 10 2 5 6 7 8
         * 3 1 4 9 10 2 5 6 8 7
         * 3 1 4 9 10 2 5 8 6 7
         * 3 1 4 9 10 2 5 8 7 6
         * 3 1 4 9 10 2 8 5 6 7
         * 3 1 4 9 10 2 8 5 7 6
         * 3 1 4 9 10 2 8 7 5 6
         * 3 1 4 9 10 2 8 7 6 5
         * 3 1 4 9 10 8 2 5 6 7
         * 3 1 4 9 10 8 2 5 7 6
         **/
        for (int i = 1; i<11; i++){
            tabell.nestePermutasjon(f);
            System.out.println(i+": "+Arrays.toString(f));
        }

        // avsnitt 1.3.2 oppgave 1
        int[] a1 = {3, 5, 4, 7, 6, 8, 1, 2, 9, 10}; // 14 inversjoner
        System.out.println(inversjoner(a1));
    }

    public static int inversjoner(int[] a) {
        int antall = 0;  // antall inversjoner
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) antall++;  // en inversjon siden i < j
            }
        }
        return antall;
    }
}

class Tabell {
    public static void snu(int[] a, int v, int h) { // snur intervallet a[v:h]
        while (v < h) bytt(a, v++, h--);
    }

    public static void snu(int[] a, int v) {  // snur fra og med v og ut tabellen
        snu(a, v, a.length - 1);
    }

    public static void snu(int[] a) {  // snur hele tabellen
        snu(a, 0, a.length - 1);
    }

    public static boolean nestePermutasjon(int[] a) {
        int i = a.length - 2;                    // i starter nest bakerst
        while (i >= 0 && a[i] > a[i + 1]) i--;   // går mot venstre
        if (i < 0) return false;                 // a = {n, n-1, . . . , 2, 1}

        int j = a.length - 1;                    // j starter bakerst
        while (a[j] < a[i]) j--;                 // stopper når a[j] > a[i]
        bytt(a,i,j); snu(a,i + 1);               // bytter og snur

        return true;                             // en ny permutasjon
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
