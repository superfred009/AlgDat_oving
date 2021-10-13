package ovingUke41;

import java.util.Comparator;

public class Oppgave2 {
    // Oppgaver til avsnitt 4.1.2 i kompendiet

    //// Oppdave 1 ////
    /** laget metoden nullstill() i java-klassen "Stakk"
     * @Override
     * public void nullstill() {
     *     for (int i = 0; i < antall; i++) {
     *         a[i] = null;
     *     }
     *     antall = 0;
     * }
     */

    //// Oppgave 2 ////

    /** laget metoden toString() i java-klassen "Stakk"
     *
     */


    //// Oppgave 3 ////
    public static <T> void snu(Stakk.TabellStakk<T> A) {

        Stakk.TabellStakk<T> B = new Stakk.TabellStakk();
        Stakk.TabellStakk<T> C = new Stakk.TabellStakk();

        while (!A.tom()) {
            B.leggInn(A.taUt());
        }
        while (!B.tom()) {
            C.leggInn(B.taUt());
        }
        while (!C.tom()) {
            A.leggInn(C.taUt());
        }
    }

    //// Oppgave 4 ////
    public static <T> void kopier(Stakk.TabellStakk<T> A, Stakk.TabellStakk<T> B) {
        Stakk.TabellStakk<T> tmpStakk = new Stakk.TabellStakk<>();

        while(!B.tom()){
            B.taUt();
        }
        while(!A.tom()) {
            tmpStakk.leggInn(A.taUt());
        }
        while(!tmpStakk.tom()) {
            T tmp = tmpStakk.taUt();
            B.leggInn(tmp);
            A.leggInn(tmp);
        }
    }

    //// Oppgave 5 ////
    public static <T> void snu2(Stakk.TabellStakk<T> A){
        Stakk.TabellStakk<T> B = new Stakk.TabellStakk();
        int n = A.antall()-1;

        while (n > 0) {
            T tmp = A.taUt();
            for (int j = 0; j < n; j++) {
                B.leggInn(A.taUt());
            }
            A.leggInn(tmp);
            while(!B.tom()){
                A.leggInn(B.taUt());
            }
            n--;
        }
    }

    //// Oppgave 6 ////
    public static <T> void kopier2(Stakk.TabellStakk<T> A, Stakk.TabellStakk<T> B) {
        int n = A.antall();

        while (n > 0) {
            for (int j = 0; j < n; j++) {
                B.leggInn(A.taUt());
            }
            T tmp = B.kikk();
            for (int j = 0; j < n; j++) {
                A.leggInn(B.taUt());
            }
            B.leggInn(tmp);
            n--;
        }
    }

    //// Oppgave 7 ////
    public static <T> void sorter(Stakk.TabellStakk<T> A, Comparator<? super T> c) {
        Stakk.TabellStakk<T> B = new Stakk.TabellStakk();
        T tmp;

        while (!A.tom()) {
            tmp = A.taUt();
            int n = 0;
            while (!B.tom() && c.compare(tmp, B.kikk()) < 0) {
                n++;
                A.leggInn(B.taUt());
            }
            B.leggInn(tmp);
            for (int i = 0; i < n; i++) {
                B.leggInn(A.taUt());
            }
        }
        while (!B.tom()) {
            A.leggInn(B.taUt());
        }
    }

    public static void main(String[] args) {
        Stakk.TabellStakk<Integer> A = new Stakk.TabellStakk();
        A.leggInn(4);
        A.leggInn(5);
        A.leggInn(2);
        A.leggInn(7);
        A.leggInn(3);

        System.out.println(A);
        sorter(A, Comparator.reverseOrder());
        System.out.println(A);
    }
}
