package ovingUke41;

public class Stakk {
    public interface Stakken<T> {         // eng: Stack

        public void leggInn(T verdi);    // eng: push
        public T kikk();                 // eng: peek
        public T taUt();                 // eng: pop
        public int antall();             // eng: size
        public boolean tom();            // eng: isEmpty
        public void nullstill();         // eng: clear

    } // interface Stakk

    public static class TabellStakk<T> implements Stakken<T> {
        private T[] a;                     // en T-tabell
        private int antall;                // antall verdier på stakken

        public TabellStakk() {              // konstruktør - tabellengde 8
            this(8);
        }

        @SuppressWarnings("unchecked")     // pga. konverteringen: Object[] -> T[]
        public TabellStakk(int lengde) {    // valgfri tabellengde
            if (lengde < 0)
                throw new IllegalArgumentException("Negativ tabellengde!");

            a = (T[])new Object[lengde];     // oppretter tabellen
            antall = 0;                      // stakken er tom
        }

        // de andre metodene skal inn her!
        @Override
        public boolean tom() {
            if (antall == 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int antall() {
            return antall;
        }

        @Override
        public void leggInn(T verdi) {
            if (antall + 1 > a.length) {
                throw new IndexOutOfBoundsException("Tabellen er full!");
            }
            a[antall] = verdi;
            antall++;
        }

        @Override
        public T taUt() {
            if (tom()) {
                throw new IndexOutOfBoundsException("Tabellen er tom!");
            }
            T verdi = a[antall-1];
            a[antall-1] = null;
            antall --;
            return verdi;
        }

        @Override
        public T kikk() {
            if (tom()) {
                throw new IndexOutOfBoundsException("Tabellen er tom!");
            }
            return a[antall-1];
        }

        @Override
        public void nullstill() {
            for (int i = 0; i < antall; i++) {
                a[i] = null;
            }
            antall = 0;
        }

        @Override
        public String toString(){
            StringBuilder s = new StringBuilder();
            s.append('[');
            for (int i = 0; i < antall; i++) {
                if (i != 0) {
                    s.append(',').append(' ');
                }
                s.append(a[i]);
            }
            s.append(']');

            return s.toString();
        }
    }  // class TabellStakk

    public static void main(String[] args) {
        char[] values = "ABCDEF".toCharArray();
        TabellStakk stakk = new TabellStakk<>();

        for (int i = 0; i< values.length; i++) {
            stakk.leggInn(values[i]);
        }
        System.out.println(stakk);
        System.out.println();

        System.out.println("Tar ut : "+stakk.taUt());
        System.out.println("Stakken nå : "+stakk);
        System.out.println();

        System.out.println("siste verdi er nå "+stakk.kikk());
        System.out.println();

        stakk.leggInn("K");
        System.out.println("La inn K");
        System.out.println("Stakken nå : "+stakk);
        System.out.println();

        stakk.nullstill();
        System.out.println("Stakken er nullstilt : "+stakk);
    }
}
