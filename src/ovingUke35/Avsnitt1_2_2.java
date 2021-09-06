package ovingUke35;

import java.util.*;

public class Avsnitt1_2_2 {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(20);              // en tilfeldig tabell
        for (int k : a) System.out.print(k + " ");  // skriver ut a

        int m = Tabell.maks(a);   // finner posisjonen til største verdi

        System.out.println("\nStørste verdi ligger på plass " + m);

        Tabell.skriv(a);
        System.out.println();
        Tabell.skrivFraTil(a, 3, 7);
        System.out.println();

        Tabell.skrivln(a);
        Tabell.skrivFraTilln(a, 3, 7);
    }
}

class Tabell {
    private Tabell() {}

    public static void skrivFraTil(int[] a, int fra, int til) {
        for (int i = fra; i<til; i++) {
            if (i == til-1) {
                System.out.print(a[i]);
            } else {
                System.out.print(a[i]+" ");
            }
        }
    }

    public static void skriv(int[] a) {
        for (int i=0; i<a.length; i++) {
            if (i == a.length-1) {
                System.out.print(a[i]);
            } else {
                System.out.print(a[i]+" ");
            }
        }
    }

    public static void skrivFraTilln(int[] a, int fra, int til) {
        for (int i = fra; i<til; i++) {
            if (i == til-1) {
                System.out.println(a[i]);
            } else {
                System.out.print(a[i]+" ");
            }
        }
    }

    public static void skrivln(int[] a) {
        for (int i=0; i<a.length; i++) {
            if (i == a.length-1) {
                System.out.println(a[i]);
            } else {
                System.out.print(a[i]+" ");
            }
        }
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] randPerm(int n) {  // en effektiv versjon
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--) {  // løkke som går n - 1 ganger
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    public static void randPerm(int[] a) { // stokker om a
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    public static int maks1(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) {
            if (a[i] > maksverdi) {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    public static int maks(int[] a) { // bruker hele tabellen
        return maks1(a,0,a.length);     // kaller metoden over
    }

    public static int min1(int[] a, int from, int end) {
        if (from < 0 || end > a.length || from >= end) {
            throw new IllegalArgumentException("Illegal interval");
        }

        int m = from;
        int min_value = a[from];

        for (int i = from + 1; i < end; i++) {
            if (a[i] < min_value) {
                m = i;
                min_value = a[i];

            }
        }
        return m;
    }

    public static int min(int[] a) {
        return min1(a, 0, a.length);
    }

}