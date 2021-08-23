package ovingUke34;

public class oppgave1 {

    public static int maks(int[] a) {  // finner og returnerer verdien til største element
        if (a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen a er tom!");
        }
        int m = a[0];
        for (int i = 1; i<a.length; i++) {
            int verdi = a[i];
            if (verdi > m) {
                m = verdi;
            }
        }
        return m;
    }

    public static int min(int[] a) {  // finner og returnerer verdien til minste element
        if (a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen a er tom!");
        }
        int m = a[0];
        for (int i = 1; i<a.length; i++) {
            int verdi = a[i];
            if (verdi < m) {
                m = verdi;
            }
        }
        return m;
    }

    public static int maksIndex(int[] a) {  // finner og returnerer indeksen til største element
        if (a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen a er tom!");
        }
        int m = (a.length - 1);
        for (int i = (a.length - 1); i>0; i--) {
            if (a[i] > a[m]) {
                m = i;
            }
        }
        return m;
    }

    public static int minIndex(int[] a) {  // finner og returnerer indeksen til minste element
        if (a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen a er tom!");
        }
        int m = 0;
        for (int i = 1; i<a.length; i++) {
            if (a[i] < a[m]) {
                m = i;
            }
        }
        return m;
    }

    public static int[] minmaks(int[] a) {
        if (a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen a er tom!");
        }
        int maks = 0;
        int min = 0;
        for (int i = 0; i<a.length; i++) {
            if (a[i] < a[min]) {
                min = i;
            }
            if (a[i] > a[maks]) {
                maks = i;
            }
        }
        int[] b = {min, maks};
        return b;
    }

    public static void skrivUtListe(int[] a) {
        for (int i = 0; i<a.length; i++) {
            System.out.println(a[i]);
        }
    }



    public static void main(String[] args){
        System.out.println("Hei AlgDat!");

        int liste[] = {2, 3, 6, 1, 5, 6};
        System.out.println("Største tallet er "+maks(liste));
        System.out.println("Minste tallet er "+min(liste));
        System.out.println("Indeksen til største tall er "+maksIndex(liste));
        System.out.println("Indeksen til minste tall er "+minIndex(liste));
        skrivUtListe(minmaks(liste));
    }
}
