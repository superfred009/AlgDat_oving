package forelesningUke38;

import java.util.Date;

public class Faculty {

    //// Rekursiv fakultet ////

    public static int rekursivFakultet(int n) {
        // Basistilfelle
        if (n == 1) {
            return 1;
        }
        // kaller seg selv, meg forenklet argument
        return n * rekursivFakultet(n-1);
    }

    public static void main(String[] args) {
        System.out.println(rekursivFakultet(5));
        System.out.println(rekursivFakultet(10));
    }
}