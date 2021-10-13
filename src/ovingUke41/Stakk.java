package ovingUke41;

import java.util.NoSuchElementException;

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
            return antall == 0;
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


    public class LenketStakk<T> implements Stakken<T>
    {
        private static final class Node<T>       // en «nøstet» nodeklasse
        {
            private T verdi;
            private Node<T> neste;

            private Node(T verdi, Node<T> neste)   // nodekonstruktør
            {
                this.verdi = verdi;
                this.neste = neste;
            }

        } // class Node

        private Node<T> hode;             // stakkens topp
        private int antall;               // antall på stakken

        public LenketStakk()              // konstruktør
        {
            hode = null;
            antall = 0;
        }

        // Her skal de andre metodene fra grensesnittet Stakk<T> stå

        @Override
        public void leggInn(T verdi) {
            hode = new Node<>(verdi, hode);
            antall++;
        }

        @Override
        public T kikk() {
            if (tom()) {
                throw new NoSuchElementException("Listen er tom!");
            }
            return hode.verdi;
        }

        @Override
        public T taUt() {
            if (tom()) {
                throw new NoSuchElementException("Listen er tom!");
            }
            T tmp = hode.verdi;
            hode = hode.neste;
            antall--;
            return tmp;
        }

        @Override
        public int antall() {
            return antall;
        }

        @Override
        public boolean tom() {
            return antall == 0;
        }

        @Override
        public void nullstill() {
            hode = null;
            antall = 0;
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            Node<T> p = hode;
            for (int i = 0; i < antall; i++) {
                if (i != 0) {
                    s.append(',').append(' ');
                }
                s.append(p.verdi);
                p = p.neste;
            }
            s.append(']');

            return s.toString();
        }

    }  // class LenketStakk
}
