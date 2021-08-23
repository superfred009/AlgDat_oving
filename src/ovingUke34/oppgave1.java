package ovingUke34;

public class oppgave1 {

    public static int maks(int[] a) {
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

    public static int min(int[] a) {
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


    public static void main(String[] args){
        System.out.println("Hei AlgDat!");

        int liste[] = {2, 3, 5, 3, 5, 6};
        System.out.println("Største tallet er "+maks(liste));
        System.out.println("Minste tallet er "+min(liste));

    }
}
